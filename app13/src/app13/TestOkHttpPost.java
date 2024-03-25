package app13;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.fasterxml.jackson.core.JsonProcessingException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TestOkHttpPost {
	public static void main(String[] args) throws JsonProcessingException, UnsupportedEncodingException {
		String url = "https://webhook.site/ad240b4d-8b52-4cc9-bb3c-e28827045654";
//		JsonMapper mapper = new JsonMapper();
//		ObjectNode objectNode = mapper.createObjectNode();
//		objectNode.put("propName", "propValue");
//		String json = mapper.writeValueAsString(objectNode);
		
		RequestBody bodyUrlEncoded = new FormBody.Builder().addEncoded("이름값", "한글값").build();
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
								.url(url)			
								.post(bodyUrlEncoded).build();
		try (Response resp = client.newCall(request).execute()) {
			System.out.println(resp.code());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}






