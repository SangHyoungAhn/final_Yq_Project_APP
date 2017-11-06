package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class YQ_CheckPayment_Page extends AppCompatActivity {

    TextView mn_date , mn_name , mn_type , mn_chain, mn_price;
    Button payment_btn;
    TextView send_Data;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                new AlertDialog.Builder(YQ_CheckPayment_Page.this)
                        .setTitle("알림")
                        .setMessage("메뉴로 이동하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent = new Intent(YQ_CheckPayment_Page.this, YQ_Final_Main_Menu.class);
                                startActivity(intent);

                            }

                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                Toast.makeText(YQ_CheckPayment_Page.this, "취소하였습니다.", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .show();

        }
        return super.onKeyDown(keyCode, event);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setTitle("결 제");


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);


        setContentView(R.layout.activity_yq__check_payment__page);

        Intent intent = getIntent();
        String J = intent.getStringExtra("menu_Info");


        mn_name=(TextView)findViewById(R.id.mn_name);
        mn_type=(TextView)findViewById(R.id.mn_type);
        mn_chain=(TextView)findViewById(R.id.mn_chain);
        mn_price=(TextView)findViewById(R.id.mn_price);
        String all_Menu= J;


        String show_m_name = all_Menu.split(";")[0];
        String show_m_type = all_Menu.split(";")[1];
        String show_chain = all_Menu.split(";")[2];
        String show_price = all_Menu.split(";")[3];


        mn_name.setText(show_m_name);
        mn_type.setText(show_m_type);
        mn_chain.setText(show_chain);
        mn_price.setText(show_price);



    }

}
