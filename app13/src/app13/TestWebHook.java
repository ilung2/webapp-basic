package app13;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

public class TestWebHook {
	public static void main(String[] args) {
		final String urlSTR = "https://webhook.site/4d6fd713-c1fc-4fbf-a50a-4ed4733077a4";

		HttpURLConnection conn = TestCarAPI.connect(urlSTR);
		try {
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;, charset=utf-8");
			conn.setDoOutput(true);

			Map<String, String> queryParamMap = new LinkedHashMap<>();
			queryParamMap.put("paramName", "paramValue");
			queryParamMap.put("korName", "한글값");

			String urlEncoded = getURLEncodedParam(queryParamMap);

			try (OutputStream os = conn.getOutputStream()) {
				byte[] bytes = urlEncoded.getBytes();
				os.write(bytes, 0, bytes.length);
				os.flush();
			}
			
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				String body = TestCarAPI.readBody(conn.getInputStream());
				System.out.println("응답 바디: " + body);
			}
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

	private static String getURLEncodedParam(Map<String, String> queryParamMap) throws UnsupportedEncodingException {
		StringJoiner joiner = new StringJoiner("&");

		for (Entry<String, String> entry : queryParamMap.entrySet()) {
			String q = URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
			joiner.add(q);
		}
		return joiner.toString();
	}
}
