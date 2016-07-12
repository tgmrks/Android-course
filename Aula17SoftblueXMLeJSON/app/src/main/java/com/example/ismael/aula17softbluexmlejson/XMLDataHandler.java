package com.example.ismael.aula17softbluexmlejson;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ismael on 08/07/15.
 */
public class XMLDataHandler implements DataHandler {

    @Override
    public String convertToString(DataBean data) throws IOException {

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter out = new StringWriter();

        serializer.setOutput(out);
        serializer.startDocument("UTF-8", true);
        serializer.startTag("", "numeros");

            serializer.startTag("", "min");
            serializer.text(String.valueOf(data.getMin()));
            serializer.endTag("", "min");

            serializer.startTag("", "max");
            serializer.text(String.valueOf(data.getMax()));
            serializer.endTag("", "max");

            serializer.startTag("", "qtde");
            serializer.text(String.valueOf(data.getQtde()));
            serializer.endTag("", "qtde");

        serializer.endTag("", "numeros");
        serializer.endDocument();

        return out.toString();
    }

    @Override
    public List<Integer> extractNumbers(String string) throws IOException {

        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(new StringReader(string));

            List<Integer> numbers = new ArrayList<>();
            boolean isNumber = false;

            int eventType = parser.getEventType();

            while(eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_TAG &&  parser.getName().equals("numero")){
                    isNumber = true;
                }
                else if(eventType == XmlPullParser.END_TAG && parser.getName().equals("numero")){
                    isNumber = false;
                }
                else if(eventType == XmlPullParser.TEXT && isNumber){
                    String number = parser.getText();
                    numbers.add(Integer.valueOf(number));
                }

                eventType = parser.next();
            }

            return numbers;

        } catch (XmlPullParserException e) {
            throw new IOException(e);
        }
    }










}
