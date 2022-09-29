package net.braniumacademy.customanotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class ObjectToJsonConverter {
    private void checkifSerializable(Object obj) {
        if (Objects.isNull(obj)) {
            throw new JSonSerializationException("The object to serialize is null");
        }
        Class<?> c = obj.getClass();
        if (!c.isAnnotationPresent(JsonSerializable.class)) {
            throw new JSonSerializationException("The class " + c.getSimpleName() +
                    " is not annotated with net.braniumacademy.customanotations.JsonSerializable");
        }
    }

    private void initializeObject(Object obj) throws Exception {
        Class<?> c = obj.getClass();
        for (Method method : c.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(obj);
            }
        }
    }

    private String getJsonString(Object obj) throws Exception {
        Class<?> c = obj.getClass();
        Map<String, String> jsonElementsMap = new HashMap<>();
        for (Field field : c.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(getKey(field), field.get(obj) + "");
            }
        }
        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }

    private String getKey(Field field) {
        String value = field.getAnnotation(JsonElement.class).key();
        return value.isEmpty() ? field.getName() : value;
    }

    public String convertToJson(Object obj) throws JSonSerializationException {
        try {
            checkifSerializable(obj);
            initializeObject(obj);
            return getJsonString(obj);
        } catch (Exception e) {
            throw new JSonSerializationException(e.getMessage());
        }
    }
}
