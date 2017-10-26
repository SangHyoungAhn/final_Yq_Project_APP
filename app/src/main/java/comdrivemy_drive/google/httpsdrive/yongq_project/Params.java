package comdrivemy_drive.google.httpsdrive.yongq_project;

/**
 * Created by AHN on 2017. 10. 21..
 */
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;


public class Params {

    ArrayList<NameValuePair> params;

    public Params() {
        params = new ArrayList<NameValuePair>();
    }

    public void add(String key, String value) {
        params.add(new BasicNameValuePair(key, value));
    }

    public void InitParams() {
        params.clear();
    }

    public ArrayList<NameValuePair> getParams() {
        return params;
    }


}