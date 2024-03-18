package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 요청을 처리하는 흐름의 전/후 개입가능한 코드 조각을 작성할 수 있습니다.
		HttpServletRequest req = (HttpServletRequest) request;
		req.setCharacterEncoding("UTF-8");

		chain.doFilter(request, response);
	}
}
