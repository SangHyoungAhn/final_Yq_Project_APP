package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class YQ_Final_Main_Menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Press Cancle Button Do not change
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                Intent intent = new Intent(this, YQ_Final_Main_Menu.class);
                startActivity(intent);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        menu_stu_name=(TextView)findViewById(R.id.menu_bar_stu_name);
        menu_stu_name.setText(Student_Login_Page.stu_name);


        menu_stu_id=(TextView)findViewById(R.id.menu_bar_stu_id);
        menu_stu_id.setText(Student_Login_Page.stu_id);
        */


        setContentView(R.layout.activity_yq__final__main__menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("학생 메뉴");


        // Log.d("1234d",Student_Login_Page.stu_name);

        //정보 이동
        Button InfoButton = (Button) findViewById(R.id.Stu_Info);


        InfoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                FragmentManager fM = getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                getIntent().putExtra("stu_name", Student_Login_Page.stu_name);
                getIntent().putExtra("stu_id", Student_Login_Page.stu_id);
                getIntent().putExtra("stu_change", Student_Login_Page.stu_change);
                // getIntent().putExtra("stu_change",getIntent().getExtras().getString("stu_change"));
                fT.replace(R.id.contents, new Student_Info_Page());
                fT.commit();



            }
        });


        Button scannerButton = (Button) findViewById(R.id.qr_Scanner);
        scannerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(YQ_Final_Main_Menu.this, YQ_Barcode.class);
                YQ_Final_Main_Menu.this.startActivity(intent);


            }
        });


        //메뉴 이동
        Button MenuButton = (Button) findViewById(R.id.Menu);
        MenuButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                FragmentManager fM = getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                fT.replace(R.id.contents, new Student_Menu_Page());
                fT.commit();

            }

        });


        //주간 메뉴이동
        Button WeekMenuButton = (Button) findViewById(R.id.WeekMenu);
        WeekMenuButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                FragmentManager fM = getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                fT.replace(R.id.contents, new YQ_Week_Menu());
                fT.commit();
            }


        });

        /*
        Button RechargeButton = (Button)findViewById(R.id.Recharge);
        RechargeButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
                fT.replace(R.id.contents, Student_Recharge_Page.newInstance());
                fT.commit();
            }


        });

        */

        Button RechargeButton = (Button) findViewById(R.id.Recharge);
        RechargeButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                FragmentManager fM = getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                fT.replace(R.id.contents, new Student_Recharge_Page());
                fT.commit();


            }
        });


        Button UsageButton = (Button) findViewById(R.id.Usage);
        UsageButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
                fT.replace(R.id.contents, new Student_Foruse_Page());
                fT.commit();
            }


        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View nav_header_view = navigationView.getHeaderView(0);

        TextView menu_stu_name = (TextView) nav_header_view.findViewById(R.id.menu_bar_stu_name);
        menu_stu_name.setText(Student_Login_Page.stu_name);


        TextView menu_stu_id = (TextView) nav_header_view.findViewById(R.id.menu_bar_stu_id);
        menu_stu_id.setText(Student_Login_Page.stu_id);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {


            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.yq__final__main__menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automaticallQQ handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Intent homeIntent =  new Intent(YQ_Final_Main_Menu.this, YQ_Final_Main_Menu.class);
            //YQ_Final_Main_Menu.this.startActivity(homeIntent);
            Intent intent = new Intent(this, YQ_Final_Main_Menu.class);
            this.startActivity(intent);
        } else if (id == R.id.nav_facility) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/d/embed?mid=1ImfGBHOdJQXm7FcBI6UhtBTpPqs"));
            YQ_Final_Main_Menu.this.startActivity(intent);


        } else if (id == R.id.nav_recharge) {

            FragmentManager fM = getSupportFragmentManager();
            FragmentTransaction fT = fM.beginTransaction();
            fT.replace(R.id.contents, new Student_Show_Recharge_Page());
            fT.commit();

        } else if (id == R.id.nav_logOut) {

            Intent intent = new Intent(YQ_Final_Main_Menu.this, Student_Login_Page.class);
            YQ_Final_Main_Menu.this.startActivity(intent);


        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.show_recharge) {

            FragmentManager fM = getSupportFragmentManager();
            FragmentTransaction fT = fM.beginTransaction();
            fT.replace(R.id.contents, new Student_Tot_Recharge());
            fT.commit();
        } else if (id == R.id.show_usage) {

            FragmentManager fM = getSupportFragmentManager();
            FragmentTransaction fT = fM.beginTransaction();
            fT.replace(R.id.contents, new Student_Tot_Usage());
            fT.commit();

        } else if (id == R.id.intro_app) {

            FragmentManager fM = getSupportFragmentManager();
            FragmentTransaction fT = fM.beginTransaction();
            fT.replace(R.id.contents, new YQ_Intro_APP());
            fT.commit();

        } else if (id == R.id.create_by) {

            FragmentManager fM = getSupportFragmentManager();
            FragmentTransaction fT = fM.beginTransaction();
            fT.replace(R.id.contents, new YQ_CreateBY_Page());
            fT.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
