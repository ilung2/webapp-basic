package app12;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

@Mapper
public interface BeerMapper {
	class BeerSelectProvider {
		public static String orderBy(String columnName) {
			SQL sql = new SQL();
			
			sql.SELECT("*")
				.FROM("beer");
			
			if (columnName != null) {
				sql.ORDER_BY(columnName);
			}
			
			return sql.toString();
		}
		
		public static String betweenPrice(Integer low, Integer high) {
			return new SQL() {{
				SELECT("*");
				FROM("beer");
				if (low != null && high != null) {
					WHERE("price BETWEEN #{low} AND #{high}");
				} else if (low == null) {
					WHERE("price <= #{high}");
				} else if (high == null) {
					WHERE("price >= #{low}");
				}
			}}.toString();
		}
	}
	
	@SelectProvider(type = BeerSelectProvider.class, method="betweenPrice")
	@ResultMap("beerResultMap")
	List<Beer> getBetween(@Param(value = "low") Integer low, @Param(value = "high") Integer high);
	
	@SelectProvider(type = BeerSelectProvider.class, method = "orderBy")
	@ResultMap("beerResultMap")
	List<Beer> orderBy(String columnName);
	
	@Select("SELECT COUNT(*) FROM beer")
	int countAll();

	@Select("SELECT * FROM beer")
	@Results(id = "beerResultMap"
			, value = {
					@Result(column = "id", property = "id", id = true)
					, @Result(column = "name", property = "name")
					, @Result(column = "price", property = "price")
			})
	List<Beer> getAll();
	
	@Select("SELECT * FROM beer LIMIT #{limit} OFFSET #{offset}")
	@ResultMap("beerResultMap")
	List<Beer> getPage(Map<String, Integer> params);

	@Select("SELECT * FROM beer WHERE id = #{id}")
	@ResultMap("beerResultMap")
	Beer getById(Integer id);
	
	@Insert("INSERT INTO beer (name, price) VALUES (#{name}, #{price})")
	int insert(Beer beer);
	
	@Delete("DELETE FROM beer WHERE id = #{id}")
	int delete(@Param(value = "id") Integer id);
	
	@Update("UPDATE beer SET name = #{name}, price = #{price} WHERE id = #{id}")
	int update(Beer beer);

}

