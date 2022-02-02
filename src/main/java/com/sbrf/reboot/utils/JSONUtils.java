package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

public class JSONUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJSON(Request request) throws JsonProcessingException {
        return mapper.writeValueAsString(request);
    }

    public static String toJSON(Response response) throws JsonProcessingException {
        return mapper.writeValueAsString(response);
    }

    public static Request JSONtoRequest(String s) throws JsonProcessingException {
        return mapper.readValue(s, Request.class);
    }

    public static Response JSONtoResponse(String s) throws JsonProcessingException {
        return mapper.readValue(s, Response.class);
    }
}
