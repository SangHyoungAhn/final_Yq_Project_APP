package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class YQ_CheckPayment_Page extends AppCompatActivity {

    TextView mn_date , mn_name , mn_type , mn_chain, mn_price;
    Button payment_btn;
    TextView send_Data;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setTitle("결 제");


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);


        setContentView(R.layout.activity_yq__check_payment__page);

        Intent intent = getIntent();
        String J = intent.getStringExtra("menu_Info");

        mn_date = (TextView)findViewById(R.id.mn_date);
        mn_name=(TextView)findViewById(R.id.mn_name);
        mn_type=(TextView)findViewById(R.id.mn_type);
        mn_chain=(TextView)findViewById(R.id.mn_chain);
        mn_price=(TextView)findViewById(R.id.mn_price);
        String all_Menu= J;

        String show_date = all_Menu.split(";")[0];
        String show_m_name = all_Menu.split(";")[1];
        String show_m_type = all_Menu.split(";")[2];
        String show_chain = all_Menu.split(";")[3];
        String show_price = all_Menu.split(";")[4];

        mn_date.setText(show_date);
        mn_name.setText(show_m_name);
        mn_type.setText(show_m_type);
        mn_chain.setText(show_chain);
        mn_price.setText(show_price);



      //  int idx = all_Menu.indexOf("=");
      //  String Menu= J.substring(idx+1);

       // check_Data.setText(Menu);



    }

}
