package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static comdrivemy_drive.google.httpsdrive.yongq_project.R.id.idText;
import static comdrivemy_drive.google.httpsdrive.yongq_project.R.id.passwordText;

public class Student_Login_Page extends Activity {



    Button LoginButton , AdminButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login_page);

        //task.execute("201233022","1234");


        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText PasswordText = (EditText) findViewById(R.id.passwordText);


        final Button LoginButton = (Button) findViewById(R.id.loginButton);
        final Button AdminButton = (Button) findViewById(R.id.adminButton);

        AdminButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent adminIntent = new Intent(Student_Login_Page.this, Admin_Login_Page.class);
                Student_Login_Page.this.startActivity(adminIntent);

            }
        });


        LoginButton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                Params params = new Params();
                params.add("stu_id", idText.toString());

                //"DBConnection" jsp이름
                new HttpNetwork("Login.do", params.getParams(), new HttpNetwork.AsyncResponse() {
                    @Override
                    public void onSuccess(String response) {


                        System.out.println("asdf..." + response);
                        JSONObject json = null;
                        try {


                            System.out.println("success");
                            json = new JSONObject(response);
                            //Log.d("Res" , json.getString(response));


                           /*
                            String parse = json.getString("JSPdata");
                            JSONArray dataArray = new JSONArray(parse);

                            for (int i = 0; i < dataArray.length(); i++) {
                                JSONObject jsonData = new JSONObject(dataArray.get(i).toString());
                                Log.d("array", jsonData.getString("stu_id"));
                            }
                            */
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

                Intent studentlogin = new Intent(Student_Login_Page.this, YQ_Final_Main_Menu.class);
                Student_Login_Page.this.startActivity(studentlogin);
            }

        });

    }
}









