package app13;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestOKHttpGet {
	public static void main(String[] args) {
		String url = "https://webhook.site/4d6fd713-c1fc-4fbf-a50a-4ed4733077a4";
		
		OkHttpClient client = new OkHttpClient(); // 모든걸 객체 구성
		Request request = new Request.Builder()
									.url(url)
									.build();
		
		try (Response resp = client.newCall(request).execute()) {
			System.out.println("응답코드 확인: " + resp.code());
			System.out.println("응답바디 확인: " + resp.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
