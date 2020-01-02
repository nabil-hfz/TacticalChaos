package com.company.utilities;

import com.company.champion.Champion;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Adapter extends TypeAdapter<Champion> {
    @Override
    public Champion read(JsonReader reader) throws IOException {
        Champion champion = new Champion();
        reader.beginObject();
        String fieldname = null;

        while (reader.hasNext()) {
            JsonToken token = reader.peek();

            if (token.equals(JsonToken.STRING)) {
                //get the current token
                fieldname = reader.nextName();
            }

            if ("name".equals(fieldname)) {
                //move to next token
                token = reader.peek();
           //     champion.setName(reader.nextString());
            }

            if("rollNo".equals(fieldname)) {
                //move to next token
          //      token = reader.peek();
            }
        }
        reader.endObject();
        return champion;

    //    return null;
    }

    @Override
    public void write(JsonWriter out, Champion value) throws IOException {

    }


}
