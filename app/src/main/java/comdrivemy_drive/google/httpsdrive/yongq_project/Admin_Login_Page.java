package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Admin_Login_Page extends AppCompatActivity {


    public static String ad_id;
    public static String ad_name;


    //Press Cancle Button Do not change
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_page);


        final EditText adminIdText = (EditText) findViewById(R.id.adminIdText);
        final EditText adminPasswordText = (EditText) findViewById(R.id.adminPasswordText);

        Button LoginButton = (Button) findViewById(R.id.adminLoginButton);
        Button AdminButton = (Button) findViewById(R.id.studentButton);


        adminIdText.setOnKeyListener(new View.OnKeyListener() {


            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    return true;
                }
                return false;
            }
        });


        adminPasswordText.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {


                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    return true;
                }
                return false;
            }
        });

        AdminButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent studentIntent = new Intent(Admin_Login_Page.this, Student_Login_Page.class);
                Admin_Login_Page.this.startActivity(studentIntent);

            }
        });

        LoginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Params params = new Params();
                params.add("ad_id", adminIdText.getText().toString());

                new HttpNetwork("adlogin_Info.jsp", params.getParams(), new HttpNetwork.AsyncResponse()

                {

                    @Override
                    public void onSuccess(String response) {


                        JSONObject json = null;

                        try {

                            JSONArray userArr = new JSONArray(response);
                            for (int i = 0; i < userArr.length(); i++) {

                                JSONObject jOb = new JSONObject(userArr.get(i).toString());

                                ArrayList<String> userList = new ArrayList<String>();

                                userList.add(jOb.getString("ad_id"));
                                userList.add(jOb.getString("ad_pw"));
                                userList.add(jOb.getString("ad_name"));

                                if (adminIdText.getText().toString().equals(userList.get(0).toString())
                                        && adminPasswordText.getText().toString().equals(userList.get(1).toString())) {

                                    Toast.makeText(Admin_Login_Page.this, "로그인이 완료되었습니다.", Toast.LENGTH_SHORT).show();

                                    Intent adminLoginIntent = new Intent(Admin_Login_Page.this, YQ_Final_Admin_Menu.class);
                                    ad_id = userList.get(0).toString();
                                    ad_name = userList.get(2).toString();
                                    adminLoginIntent.putExtra("ad_id", adminIdText.getText().toString());
                                    adminLoginIntent.putExtra("ad_name", ad_name);

                                    adminIdText.getText().clear();
                                    adminPasswordText.getText().clear();


                                    Admin_Login_Page.this.startActivity(adminLoginIntent);


                                } else if (adminIdText.getText().toString().length() == 0
                                        || adminPasswordText.getText().toString().length() == 0) {
                                    Toast.makeText(Admin_Login_Page.this, "관리자번호 or 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                                    adminIdText.getText().clear();
                                    adminPasswordText.getText().clear();

                                }
                            }


                            // Log.d("stu_kk",userList.toString());


                            // Log.d("1234dd",stu_name);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(String response) {

                    }

                    @Override
                    public void onPreExcute() {
                    }
                });


            }
        });

    }
}
