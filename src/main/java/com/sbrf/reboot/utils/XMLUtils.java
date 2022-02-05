package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

public class XMLUtils {

    private static final XmlMapper mapper = new XmlMapper();

    public static String toXML(Response response) throws JsonProcessingException {
        return mapper.writeValueAsString(response);
    }

    public static String toXML(Request request) throws JsonProcessingException {
        return mapper.writeValueAsString(request);
    }

    public static Request XMLtoRequest(String s) throws JsonProcessingException {
        return mapper.readValue(s, Request.class);
    }

    public static Response XMLtoResponse(String s) throws JsonProcessingException {
        return mapper.readValue(s, Response.class);
    }
}
