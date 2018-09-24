package Util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonHelper {
    public static Object mapToCorrespondingObject(String data, Class c)
    {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //convert json string to object
            Object object = objectMapper.readValue(data, c);
            return object;
        } catch (Exception e)
        {
           e.printStackTrace();
        }
        return null;
    }
}
