package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class YQ_Barcode extends AppCompatActivity {


    Button send_Data;
    Button cancel_Data;
    TextView m_date;
    TextView m_name;
    TextView m_type;
    TextView m_chain;
    TextView m_price;

    //private Button scan_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setTitle("QR 스캐너");

        setContentView(R.layout.activity_yq__barcode);

        //scan_btn = (Button)findViewById(R.id.scan_btn);
        final Activity activity = this;
        cancel_Data= (Button)findViewById(R.id.cancel_Data);
        send_Data=  (Button)findViewById(R.id.send_Data);
        //call_Data= (TextView)findViewById(R.id.call_Data);

        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("QR코드를 화면 가까이에 보여지도록 하세요");
        integrator.setCameraId( 0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();


        cancel_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(YQ_Barcode.this , YQ_Final_Main_Menu.class);
                YQ_Barcode.this.startActivity(intent);
            }
        });



    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result =IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
             if(result.getContents()==null){

                 Toast.makeText(this,"알맞은 메뉴가 존재하지 않습니다.", Toast.LENGTH_LONG).show();


             }
             else{

                 final String K= result.getContents();

                 m_date = (TextView)findViewById(R.id.m_date);
                 m_name=(TextView)findViewById(R.id.m_name);
                 m_type=(TextView)findViewById(R.id.m_type);
                 m_chain=(TextView)findViewById(R.id.m_chain);
                 m_price=(TextView)findViewById(R.id.m_price);
                 String all_Menu= K;

                 String show_date = all_Menu.split(";")[0];
                 String show_m_name = all_Menu.split(";")[1];
                 String show_m_type = all_Menu.split(";")[2];
                 String show_chain = all_Menu.split(";")[3];
                 String show_price = all_Menu.split(";")[4];

                 m_date.setText(show_date);
                 m_name.setText(show_m_name);
                 m_type.setText(show_m_type);
                 m_chain.setText(show_chain);
                 m_price.setText(show_price);






                 send_Data.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {

                         new AlertDialog.Builder(YQ_Barcode.this)
                                 .setTitle("결제")
                                 .setMessage("결제하시겠습니까?")
                                 .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                     public void onClick(DialogInterface dialog, int whichButton) {



                                         Params params = new Params();
                                         params.add("buy_id", Student_Login_Page.stu_id);
                                         params.add("mn_price",m_price.getText().toString());
                                         params.add("mn_chain",m_chain.getText().toString());
                                         params.add("mn_name",m_name.getText().toString());

                                         new HttpNetwork("stuBuyMenu_Info.jsp",params.getParams(), new HttpNetwork.AsyncResponse()
                                         {
                                             @Override
                                             public void onSuccess (String response){

                                                 try {
                                                     //필요없는 부분
                                                     JSONArray useMthArr = new JSONArray(response);

                                                 } catch (JSONException e) {
                                                     e.printStackTrace();
                                                 }
                                             }
                                             @Override
                                             public void onFailure (String response){
                                             }
                                             @Override
                                             public void onPreExcute () {
                                             }
                                         });
















                                         // 확인시 처리 로직
                                         Intent intent = new Intent(YQ_Barcode.this , YQ_CheckPayment_Page.class);
                                         intent.putExtra("menu_Info",K);
                                         YQ_Barcode.this.startActivity(intent);

                                     }})
                                 .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                     public void onClick(DialogInterface dialog, int whichButton) {
                                         // 취소시 처리 로직
                                         Toast.makeText(YQ_Barcode.this, "취소하였습니다.", Toast.LENGTH_SHORT).show();
                                     }})
                                 .show();

                     }
                 });



             }
        }

        else {


            super.onActivityResult(requestCode, resultCode, data);

        }
    }
}
