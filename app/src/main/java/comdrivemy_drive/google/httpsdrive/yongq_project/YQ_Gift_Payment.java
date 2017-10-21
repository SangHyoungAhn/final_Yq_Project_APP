package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class YQ_Gift_Payment extends AppCompatActivity {


    private TextView send_stu_name;
    private TextView send_stu_num;
    private TextView send_stu_money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yq__gift__payment);




        Intent intent = getIntent();
        String J = intent.getStringExtra("menu_Info");
        String send_money =intent.getStringExtra("send_money");
        send_stu_num = (TextView)findViewById(R.id.send_stu_num);
        send_stu_name= (TextView)findViewById(R.id.send_stu_name);
        send_stu_money= (TextView)findViewById(R.id.send_stu_price);
        String all_Menu= J;

        String show_stu_num = all_Menu.split(";")[0];
        String show_stu_name = all_Menu.split(";")[1];


        send_stu_num.setText(show_stu_num);
        send_stu_name.setText(show_stu_name);
        send_stu_money.setText("3000");

    }
}
