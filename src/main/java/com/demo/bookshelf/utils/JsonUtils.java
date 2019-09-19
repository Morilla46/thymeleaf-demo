package com.demo.bookshelf.utils;

import org.springframework.core.io.ClassPathResource;
import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class JsonUtils {
    public static <T> List<T> getArrayFromJson(String path, Class<T> clazz) throws IOException {
        BufferedReader reader = null;
        String lastStr = "";
        ClassPathResource resource = new ClassPathResource(path);
        if (resource.exists()) {
            InputStream data = resource.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(data, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                lastStr += tempString;
            }
            reader.close();
            return JSON.parseArray(lastStr, clazz);
        } else {
            throw new IOException();
        }
    }
}
