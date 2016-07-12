package com.example.ismael.aula17softbluexmlejson;

/**
 * Created by ismael on 08/07/15.
 */
public class DataHandlerFactory {

    public static DataHandler newDataHandller(DataHandler.Format format) {

        if (format == DataHandler.Format.XML) {
            return new XMLDataHandler();
        } else if (format == DataHandler.Format.JSON) {
            return new JSONDataHandler();
        }

        return null;
    }
}
