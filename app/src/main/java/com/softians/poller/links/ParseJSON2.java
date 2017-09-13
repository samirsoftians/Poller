package com.softians.poller.links;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lenovo on 9/4/2017.
 */

public class ParseJSON2 {
    public static String[] ids;
    public static String[] questionnumber;
       public static String[] question;
   public static String[] answer;
    public static String[] m_name;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_QUESTION = "question";
    public static final String KEY_ANSWER = "answer";
    public static final String KEY_MODULE = "m_name";

    private JSONArray users = null;

    private String json;

    public ParseJSON2(String json){
        this.json = json;
    }

    public void parseJSON2(){
        JSONObject jsonObject=null;
        try {

//            Toast.makeText(getClass(), "", Toast.LENGTH_SHORT).show();
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[users.length()];
            question = new String[users.length()];
           answer = new String[users.length()];
            m_name = new String[users.length()];
            questionnumber=new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
               question[i] = jo.getString(KEY_QUESTION);
               answer[i] = jo.getString(KEY_ANSWER);
                m_name[i] = jo.getString(KEY_MODULE);
                questionnumber[i]= String.valueOf(i);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
