package com.ikeguang.web.util;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static String objectToJson(Object data) {
		try {
			return MAPPER.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public static String objectToFormatJson(Object data) {
		try {
			String result = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(data);
			return result;
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T jsonToBean(String jsonData, Class<T> beanType) {
		try {
			T result = MAPPER.readValue(jsonData, beanType);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);

		try {
			List<T> resultList = MAPPER.readValue(jsonData, javaType);
			return resultList;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <K, V> Map<K, V> jsonToMap(String jsonData, Class<K> keyType, Class<V> valueType) {
		JavaType javaType = MAPPER.getTypeFactory().constructMapType(Map.class, keyType, valueType);

		try {
			Map<K, V> resultMap = MAPPER.readValue(jsonData, javaType);
			return resultMap;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
