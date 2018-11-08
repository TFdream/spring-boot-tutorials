package io.dreamstudio.springboot.cache.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ricky Fung
 */
public class JsonUtils {
    private static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Date.class, new JsonDateSerializer())
            .create();

    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }

    public static <T> T parseObject(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }
    public static <T> T parseObject(String json, Type typeOfT) {
        return GSON.fromJson(json, typeOfT);
    }

    /**
     * gson Date序列化/反序列化
     * @author Ricky Fung
     */
    static class JsonDateSerializer implements
            JsonSerializer<Date>,JsonDeserializer<Date> {

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (json==null || json.isJsonNull()) {
                return null;
            }
            String dateStr = json.getAsString();
            if (dateStr==null || dateStr.length()<1) {
                return null;
            }
            try {
                return new SimpleDateFormat(STANDARD_FORMAT).parse(dateStr);
            } catch (ParseException e) {
                throw new JsonParseException("unknown dateStr:"+dateStr, e);
            }
        }

        @Override
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            if (src==null) {
                return null;
            }
            return new JsonPrimitive(new SimpleDateFormat(STANDARD_FORMAT).format(src));
        }
    }

}
