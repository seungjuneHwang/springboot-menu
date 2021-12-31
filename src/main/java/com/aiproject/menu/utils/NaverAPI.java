package com.aiproject.menu.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NaverAPI {
	public static String searchNews(String str) {
		// String[] code = Util.readLineFile("c:/dev/네이버API_시크릿코드.txt").split("\\n");
//		String[] cArr = code.split("\\n");
		
        String clientId = "NV4EdkvVJqhHxFRRL2JL"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "f8es3ieBOX"; //애플리케이션 클라이언트 시크릿값"

        String text = null;
        try {
            text = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        String apiURL = "https://openapi.naver.com/v1/search/news?query=" + text;    // json 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
        System.out.println(apiURL);

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);
        // System.out.println(responseBody);
        return responseBody;
	}
	
// 	public String searchBlog(String str) {
// 		String[] code = Util.readLineFile("c:/dev/네이버API_시크릿코드.txt").split("\\n");
// //		String[] cArr = code.split("\\n");
		
//         String clientId = code[0]; //애플리케이션 클라이언트 아이디값"
//         String clientSecret = code[1]; //애플리케이션 클라이언트 시크릿값"

//         String text = null;
//         try {
//             text = URLEncoder.encode(str, "UTF-8");
//         } catch (UnsupportedEncodingException e) {
//             throw new RuntimeException("검색어 인코딩 실패",e);
//         }


//         String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;    // json 결과
//         //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과


//         Map<String, String> requestHeaders = new HashMap<>();
//         requestHeaders.put("X-Naver-Client-Id", clientId);
//         requestHeaders.put("X-Naver-Client-Secret", clientSecret);
//         String responseBody = get(apiURL,requestHeaders);
//         return responseBody;
// 	}
	
	// json 데이터 파싱해서 전달
// 	public ArrayList<NaverApiDTO> getListJson(String responseBody) {
// 		// json 파싱
// 		Gson gson = new Gson();
// 		ArrayList<NaverApiDTO> list = new ArrayList<NaverApiDTO>();
// //        NaverApiDTO dto = gson.fromJson(responseBody, NaverApiDTO.class);
// //        System.out.println(dto.getTitle());
// 		JsonObject jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
// 		JsonArray jsonArray = jsonObject.getAsJsonArray("items");
// //		System.out.println(jsonArray.get(0));
// 		for (JsonElement em : jsonArray) {
// 			NaverApiDTO dto = gson.fromJson(em, NaverApiDTO.class);
// 			list.add(dto);
// //			System.out.println(dto.getTitle());
// //			System.out.println(dto.getLink());
// //			System.out.println(dto.getPubDate());
// 		}
// 		return list;
// 	}
	
	public static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	public static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	public static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}
}