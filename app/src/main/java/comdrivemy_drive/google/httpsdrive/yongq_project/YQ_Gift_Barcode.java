package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;

public class YQ_Gift_Barcode extends AppCompatActivity {


    private Button gift_Data;
    private Button cancel_gift;
    private TextView stu_name;
    private TextView stu_num;
    private EditText stu_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("QR 스캐너");

        setContentView(R.layout.activity_yq__gift__barcode);



        final Activity activity = this;

        cancel_gift = (Button)findViewById(R.id.cancel_gift);
        gift_Data = (Button)findViewById(R.id.gift_Data);

        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("QR코드를 화면 가까이에 보여지도록 하세요");
        integrator.setCameraId( 0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();



        cancel_gift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YQ_Gift_Barcode.this , YQ_Final_Main_Menu.class);
                YQ_Gift_Barcode.this.startActivity(intent);
            }
        });



    }

   protected void onActivityResult(int requestCode, int resultCode, Intent data) {




        IntentResult result =IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);

        if(result != null){
            if(result.getContents()==null){

                Toast.makeText(this,"알맞은 QR이 존재하지 않습니다.", Toast.LENGTH_LONG).show();


            }
            else{


                final String K= result.getContents();

                stu_num = (TextView)findViewById(R.id.stu_num);
                stu_name=(TextView)findViewById(R.id.stu_name);
                stu_price= (EditText)findViewById(R.id.stu_price);
                String all_name= K;

                String show_stu_num = all_name.split(";")[0];
                String show_stu_name = all_name.split(";")[1];
                final String show_stu_price=stu_price.getText().toString();

                stu_num.setText(show_stu_num);
                stu_name.setText(show_stu_name);


                gift_Data.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new AlertDialog.Builder(YQ_Gift_Barcode.this)
                                .setTitle("선물")
                                .setMessage("선물하시겠습니까?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        // 확인시 처리 로직



                                        Params params = new Params();
                                        params.add("send_id", Student_Login_Page.stu_id);
                                        params.add("mn_price",stu_price.getText().toString());
                                        params.add("re_id",stu_num.getText().toString());

                                        new HttpNetwork("stuGift_Info.jsp",params.getParams(), new HttpNetwork.AsyncResponse()
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










                                        Intent intent = new Intent( YQ_Gift_Barcode.this, YQ_Gift_Payment.class);
                                        intent.putExtra("menu_Info",K);
                                        intent.putExtra("send_money",show_stu_price);
                                        YQ_Gift_Barcode.this.startActivity(intent);
                                    }})
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        // 취소시 처리 로직
                                        Toast.makeText(YQ_Gift_Barcode.this, "취소하였습니다.", Toast.LENGTH_SHORT).show();
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
