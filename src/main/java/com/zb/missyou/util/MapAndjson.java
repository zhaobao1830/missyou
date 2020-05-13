package com.zb.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zb.missyou.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import java.util.Map;

// 封装序列化和反序列化
public class MapAndjson implements AttributeConverter<Map<String, Object>, String> {

    @Autowired
    private ObjectMapper mapper;

    // 序列化
    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        try {
            return mapper.writeValueAsString(stringObjectMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        return null;
    }
}
