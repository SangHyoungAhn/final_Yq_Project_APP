package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class YQ_Page extends AppCompatActivity {

    private Handler handler;

    Runnable runnable = new Runnable(){

        public void run() {
            Intent intent = new Intent(YQ_Page.this, YQ_Sort_Page.class);
            startActivity(intent);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_yq__page);
        setContentView(R.layout.activity_yq__page);
        Init();

        handler.postDelayed(runnable, 2000);
    }

    public void Init(){
        handler = new Handler();
    }

    public void onBackPressed() {
        super.onBackPressed();
        handler.removeCallbacks(runnable);
    }




}
