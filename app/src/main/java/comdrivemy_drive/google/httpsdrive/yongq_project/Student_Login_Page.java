package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Student_Login_Page extends Activity{


    public static String stu_name;
    public static String stu_id;
    public static String stu_change;
    //public static ArrayList<String> userList =new ArrayList<String>();
    // public static ArrayList<String> userPWList = new ArrayList<String>();
    //public static ArrayList<String> userNameList = new ArrayList<String>();
    //public static ArrayList<String> userChangeList = new ArrayList<String>();
    Button LoginButton, AdminButton;



    // Press Button -> Not Press Button
    @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK: return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login_page);


        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText PasswordText = (EditText) findViewById(R.id.passwordText);


        idText.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //Enter키눌렀을떄 처리
                    return true;
                }
                return false;
            }

        });


        PasswordText.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    return true;
                }
                return false;
            }
        });

        Button LoginButton = (Button) findViewById(R.id.loginButton);
        Button AdminButton = (Button) findViewById(R.id.adminButton);


        AdminButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent adminIntent = new Intent(Student_Login_Page.this, Admin_Login_Page.class);
                Student_Login_Page.this.startActivity(adminIntent);

            }
        });


        LoginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Params params = new Params();
                params.add("stu_id", idText.getText().toString());

                new HttpNetwork("login_Info.jsp", params.getParams(), new HttpNetwork.AsyncResponse()
                {
                    @Override
                    public void onSuccess(String response) {

                        JSONObject json = null;
                        try {
                            JSONArray userArr = new JSONArray(response);
                            for (int i = 0; i < userArr.length(); i++) {

                                JSONObject jOb = new JSONObject(userArr.get(i).toString());

                                ArrayList<String> userList = new ArrayList<String>();

                                userList.add(jOb.getString("stu_id"));
                                userList.add(jOb.getString("stu_pw"));
                                userList.add(jOb.getString("stu_name"));
                                userList.add(jOb.getString("stu_change"));


                                if (idText.getText().toString().equals(userList.get(0).toString())
                                        && PasswordText.getText().toString().equals(userList.get(1).toString())) {

                                    Toast.makeText(Student_Login_Page.this, "로그인이 완료되었습니다.", Toast.LENGTH_SHORT).show();


                                    Intent intent = new Intent(Student_Login_Page.this, YQ_Final_Main_Menu.class);

                                    stu_name = userList.get(2).toString();
                                    stu_id = idText.getText().toString();
                                    stu_change = userList.get(3).toString();
                                    intent.putExtra("stu_id", idText.getText().toString());
                                    intent.putExtra("stu_name", stu_name);
                                    intent.putExtra("stu_change", userList.get(3).toString());

                                    idText.getText().clear();
                                    PasswordText.getText().clear();

                                    Student_Login_Page.this.startActivity(intent);


                                } else if (idText.getText().toString().length() == 0
                                        || PasswordText.getText().toString().length() == 0) {
                                    Toast.makeText(Student_Login_Page.this, "학번 or 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();


                                    idText.getText().clear();
                                    PasswordText.getText().clear();


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



