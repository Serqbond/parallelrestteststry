package models;

import com.google.gson.*;

import java.lang.reflect.Type;

public class CountryInfoDeserializer implements JsonDeserializer<CountryInfo[]>{

    @Override
    public CountryInfo[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException
    {
        if (json instanceof JsonArray)
        {
            return new Gson().fromJson(json, CountryInfo[].class);
        }
        CountryInfo child = context.deserialize(json, CountryInfo.class);
        return new CountryInfo[] { child };
    }
}
