package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Admin_Login_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_page);


        EditText adminIdText = (EditText) findViewById(R.id.adminIdText);
        EditText adminPasswordText = (EditText) findViewById(R.id.adminPasswordText);

        Button LoginButton = (Button) findViewById(R.id.adminLoginButton);
        Button AdminButton = (Button) findViewById(R.id.studentButton);

        AdminButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent studentIntent = new Intent(Admin_Login_Page.this, Student_Login_Page.class);
                Admin_Login_Page.this.startActivity(studentIntent);

            }
        });

        LoginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent adminLoginIntent = new Intent(Admin_Login_Page.this, YQ_Final_Admin_Menu.class);
                Admin_Login_Page.this.startActivity(adminLoginIntent);
            }
        });

    }
}
