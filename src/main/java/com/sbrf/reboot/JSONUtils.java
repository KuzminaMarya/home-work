package com.sbrf.reboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
    public static String toJSON(Request request) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(request);
            System.out.println(json);
            return json;
        } catch (JsonProcessingException e) {
            return ("Не удалось преобразовать в JSON");
        }
    }

    public static String toJSON(Response response) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(response);
            System.out.println(json);
            return json;
        } catch (JsonProcessingException e) {
            return ("Не удалось преобразовать в JSON");
        }
    }

    public static Request JSONtoRequest(String json) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(json);
            return new Request(jsonNode.get("atmNumber").asText());
        } catch (JsonProcessingException e) {
            System.out.println("Не удалось преобразовать в Request");
            return new Request("Не удалось преобразовать в Request");
        }
    }

    public static Response JSONtoResponse(String json) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(json);
            return new Response(jsonNode.get("statusCode").asText());
        } catch (JsonProcessingException e) {
            System.out.println("Не удалось преобразовать в Response");
            return new Response("Не удалось преобразовать в Response");
        }
    }
}
