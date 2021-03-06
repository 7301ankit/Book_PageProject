package com.Book_project.Book_Page.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class ResponseHandler {
    public static ResponseEntity<Object> response(HttpStatus httpStatus, Boolean isError, String message
    ) {

        Map<String, Object> map = new TreeMap<>();
        map.put("timestamp", new Date().getTime());
        map.put("status", httpStatus.value());
        map.put("isError", isError);
        map.put("message", message);
//		map.put("responseCode", responseCode.value());
        return new ResponseEntity<>(map, httpStatus);

    }
    public static ResponseEntity<Object> response(HttpStatus httpStatus, Boolean isError, String message,
                                                  Object responseObject) {

        Map<String, Object> map = new TreeMap<>();
        map.put("timestamp", new Date().getTime());
        map.put("status", httpStatus.value());
        map.put("isError", isError);
        map.put("message", message);
//		map.put("responseCode", responseCode.value());
        map.put("responseObject", responseObject);
        return new ResponseEntity<>(map, httpStatus);

    }
}
