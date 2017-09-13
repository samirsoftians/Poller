package com.softians.poller.links;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lenovo on 2/28/2017.
 */

public class ParseJSON {
    public static String[] ids;
//    public static String[] question;
//    public static String[] answer;
    public static String[] m_name;
    public static String[] txtTImeID;
    public static String[] tid;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_QUESTION = "question";
    public static final String KEY_ANSWER = "answer";
    public static final String KEY_MODULE = "m_name";
    public static final String KEY_TIME = "m_start_time";


    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    public void parseJSON(){
        JSONObject jsonObject=null;
        try {

//            Toast.makeText(getClass(), "", Toast.LENGTH_SHORT).show();
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[users.length()];
//            question = new String[users.length()];
//            answer = new String[users.length()];
            m_name = new String[users.length()];
            txtTImeID = new String[users.length()];

            tid = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
//                question[i] = jo.getString(KEY_QUESTION);
//                answer[i] = jo.getString(KEY_ANSWER);
                m_name[i] = jo.getString(KEY_MODULE);
                txtTImeID[i]=jo.getString(KEY_TIME);
                tid[i]= String.valueOf(i);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
