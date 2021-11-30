package com.sbrf.reboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import com.sun.deploy.xml.XMLNode;

import javax.xml.stream.XMLStreamReader;
import java.io.*;


public class XMLUtils {
    public static String toXML(Request request) throws JsonProcessingException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(request);
            System.out.println(xml);
            return xml;
        } catch (JsonProcessingException e) {
            return ("Не удалось преобразовать в XML");
        }
    }

    public static String toXML(Response response) throws JsonProcessingException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(response);
            System.out.println(xml);
            return xml;
        } catch (JsonProcessingException e) {
            return ("Не удалось преобразовать в XML");
        }
    }

    public static Request XMLtoRequest(String xml) {
        try {
            XmlMapper mapper = new XmlMapper();
            JsonNode xmlNode = mapper.readTree(xml);
            return new Request(xmlNode.get("atmNumber").asText());
        } catch (JsonProcessingException e) {
            System.out.println("Не удалось преобразовать в Request");
            return new Request("Не удалось преобразовать в Request");
        }
    }

    public static Response XMLtoResponse(String xml) {
        try {
            XmlMapper mapper = new XmlMapper();
            JsonNode jsonNode = mapper.readTree(xml);
            return new Response(jsonNode.get("statusCode").asText());
        } catch (JsonProcessingException e) {
            System.out.println("Не удалось преобразовать в Response");
            return new Response("Не удалось преобразовать в Response");
        }
    }
}
