package com.example.ismael.aula17softbluexmlejson;

import java.io.IOException;
import java.util.List;

/**
 * Created by ismael on 08/07/15.
 */
public interface DataHandler {

    public enum Format {
        XML, JSON
    }

    public String convertToString(DataBean data) throws IOException;

    public List<Integer> extractNumbers(String string) throws IOException;
}
