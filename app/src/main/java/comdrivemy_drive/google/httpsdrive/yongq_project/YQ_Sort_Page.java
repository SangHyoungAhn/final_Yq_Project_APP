package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;

public class YQ_Sort_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yq__sort__page);


        Button choiceStu = (Button) findViewById(R.id.choiceStu);
        Button choiceAdmin = (Button) findViewById(R.id.choiceAdmin);
        final Activity activity = this;


        choiceStu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


            //    Intent intent = new Intent(YQ_Sort_Page.this,exerCISE.class);
            //    YQ_Sort_Page.this.startActivity(intent);






               Intent stuIntent = new Intent(YQ_Sort_Page.this, Student_Login_Page.class);
                YQ_Sort_Page.this.startActivity(stuIntent);

            }
        });

        choiceAdmin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent adminIntent = new Intent(YQ_Sort_Page.this, Admin_Login_Page.class);
                YQ_Sort_Page.this.startActivity(adminIntent);
            }
        });

    }
}
