package com.example.ismael.aula17softbluexmlejson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ismael on 08/07/15.
 */
public class JSONDataHandler implements DataHandler {

    @Override
    public String convertToString(DataBean data) throws IOException {

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("min", data.getMin());
        map.put("max", data.getMax());
        map.put("qtde", data.getQtde());

        JSONObject jsonObject = new JSONObject(map);

        return jsonObject.toString();
    }

    @Override
    public List<Integer> extractNumbers(String string) throws IOException {

        try {
            List<Integer> numbers = new ArrayList<>();

            JSONArray jsonArray = new JSONArray(string);

            for (int i = 0; i < jsonArray.length(); i++){
                int number = jsonArray.getInt(i);
                numbers.add(number);
            }

            return numbers;

        } catch (JSONException e) {
            throw new IOException(e);
        }
    }
}
