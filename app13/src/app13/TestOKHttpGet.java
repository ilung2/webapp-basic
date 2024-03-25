package app13;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestOkHttpGet {
	public static void main(String[] args) {
		String url = "https://webhook.site/ad240b4d-8b52-4cc9-bb3c-e28827045654";
		
		OkHttpClient client = new OkHttpClient();
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
