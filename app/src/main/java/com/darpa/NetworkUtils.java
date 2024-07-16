package com.darpa;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

class NetworkUtils {

    private static final String TAG = "";
    public String get(String packageName) throws UnsupportedEncodingException {
        String url = "http://172.16.108.178:1316/ClickShield/" + packageName;
        StringBuilder response = new StringBuilder();

        try {
            // 创建 URL 对象
            URL apiUrl = new URL(url);

            // 打开 HTTP 连接
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");


            // 设置连接属性
            connection.setConnectTimeout(5000); // 连接超时时间 5 秒
            connection.setReadTimeout(5000); // 读取超时时间 5 秒

            // 获取响应状态码
            int responseCode = connection.getResponseCode();

            // 处理响应
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 读取响应内容
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                String responseString = decodeUnicodeEscape(response.toString());
                return responseString;
            } else {
                System.out.println("HTTP request failed with response code: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            System.out.println("Error occurred during HTTP request: " + e.getMessage());
            return null;
        }

    }
    private static String decodeUnicodeEscape(String input) {
        StringBuilder output = new StringBuilder();
        int length = input.length();
        int index = 0;

        while (index < length) {
            char c = input.charAt(index);
            if (c == '\\' && index + 1 < length && input.charAt(index + 1) == 'u') {
                // 处理 Unicode 转义序列
                int start = index + 2;
                int end = start + 4;
                while (end <= input.length() && isHexDigit(input.charAt(start)) && isHexDigit(input.charAt(start + 1)) &&
                        isHexDigit(input.charAt(start + 2)) && isHexDigit(input.charAt(start + 3))) {
                    int codePoint = Integer.parseInt(input.substring(start, end), 16);
                    output.appendCodePoint(codePoint);
                    index = end;
                    start = index + 2;
                    end = start + 4;
                }
            } else {
                output.append(c);
                index++;
            }
        }

        return output.toString();
    }

    private static boolean isHexDigit(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }
}