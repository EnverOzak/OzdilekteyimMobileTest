package com.testinium.ozdilekteyim.backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class BackEnd {

    public static String findMobileElementByKey(String key, String pageObject) throws IOException {

        ClassLoader classLoader = BackEnd.class.getClassLoader();
        File file = new File(classLoader.getResource(pageObject).getFile());

        String content = new String(Files.readAllBytes(file.toPath()));
        ObjectMapper mapper = new ObjectMapper();

        List<MobileElements> listElems = mapper.readValue(content, new TypeReference<List<MobileElements>>(){});
        for (MobileElements listElem : listElems) {
            if (listElem.key.equals(key))
                return listElem.androidValue;
        }
        return "";
    }

}
