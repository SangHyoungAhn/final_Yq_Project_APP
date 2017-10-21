package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class YQ_Final_Admin_Menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_yq__final__admin__menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("관리자 메뉴");




        Button CalButton = (Button) findViewById(R.id.admin_calculate);
        CalButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                FragmentManager fM = getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                fT.replace(R.id.admin_contents, new Admin_Calculate_Page());
                fT.commit();





            }
        });


        Button InsertMenuButton = (Button) findViewById(R.id.admin_Insert_Menu);
        InsertMenuButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                FragmentManager fM = getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                fT.replace(R.id.admin_contents, new Admin_Insert_Menu_Page());
                fT.commit();
            }
        });


        Button SeeMenuButton  = (Button) findViewById(R.id.admin_Menu);
        SeeMenuButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                FragmentManager fM = getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                fT.replace(R.id.admin_contents, new YQ_Week_Menu());
                fT.commit();
            }
        });



        Button PwButton  = (Button) findViewById(R.id.admin_Search_Pw);
        PwButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                FragmentManager fM = getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                fT.replace(R.id.admin_contents, new Admin_Password_Page());
                fT.commit();

            }
        });


        Button AdminUsageButton = (Button)findViewById(R.id.admin_Usage);
        AdminUsageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
                fT.replace(R.id.admin_contents, Admin_Usage_Page.newInstance());
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
        getMenuInflater().inflate(R.menu.yq__final__admin__menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
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

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(YQ_Final_Admin_Menu.this, YQ_Final_Admin_Menu.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.admin_soldout) {

            FragmentManager fM = getSupportFragmentManager();
            FragmentTransaction fT = fM.beginTransaction();
            fT.replace(R.id.admin_contents, new Admin_Manage_soldOut());
            fT.commit();


        } else if (id == R.id.nav_adminLogout) {

            Intent intent = new Intent(YQ_Final_Admin_Menu.this , Admin_Login_Page.class);
            YQ_Final_Admin_Menu.this.startActivity(intent);


        } else if (id == R.id.admin_intro_app) {


            FragmentManager fM = getSupportFragmentManager();
            FragmentTransaction fT = fM.beginTransaction();
            fT.replace(R.id.admin_contents, new YQ_Intro_APP());
            fT.commit();



         //   Intent intent = new Intent(YQ_Final_Admin_Menu.this,YQ_Barcode.class);
         //   YQ_Final_Admin_Menu.this.startActivity(intent);

        } else if (id == R.id.admin_createby) {

            FragmentManager fM = getSupportFragmentManager();
            FragmentTransaction fT = fM.beginTransaction();
            fT.replace(R.id.admin_contents, new YQ_CreateBY_Page());
            fT.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
