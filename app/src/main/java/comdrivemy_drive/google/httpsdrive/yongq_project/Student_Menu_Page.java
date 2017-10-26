package comdrivemy_drive.google.httpsdrive.yongq_project;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Student_Menu_Page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // private Fragment fragment;
    // private FragmentManager fragmentManager;

    TextView dateNow;

    public Student_Menu_Page() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Student_Menu_Page newInstance(String param1, String param2) {

        Bundle args = new Bundle();
        Student_Menu_Page fragment = new Student_Menu_Page();

        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }




    }

    private TabLayout tabLayout;
    /*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    */

    //날짜 받아오기
    private String date() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = df.format(date);

        return formatDate;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        Params params =new Params();

        new HttpNetwork("menu_Info.jsp",params.getParams(),new HttpNetwork.AsyncResponse(){
            @Override
            public void onSuccess(String response) {

                JSONObject json =null;

                try{

                    JSONArray menuArr =new JSONArray(response);

                    for(int i=0; i<menuArr.length();i++){

                        JSONObject menuOb = new JSONObject(menuArr.get(i).toString());
                        ArrayList<String> menuList = new ArrayList<String>();

                        menuList.add(menuOb.getString("mn_date"));
                        menuList.add(menuOb.getString("chain"));
                        menuList.add(menuOb.getString("mn_type"));
                        menuList.add(menuOb.getString("mn_name"));
                        menuList.add(menuOb.getString("mn_price"));



                        Log.d("12kkk",menuList.toString());

                    }



                }catch(JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(String response) {

            }

            @Override
            public void onPreExcute() {

            }
        });





        View view = inflater.inflate(R.layout.fragment_student__menu__page, container, false);

        tabLayout = (TabLayout)view.findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("인성관"));
        tabLayout.addTab(tabLayout.newTab().setText("환과대"));
        tabLayout.addTab(tabLayout.newTab().setText("기숙사"));


        final ViewPager pager = (ViewPager)view.findViewById(R.id.viewPager);

        final PagerAdapter adapter = new PagerAdapter(getChildFragmentManager(),tabLayout.getTabCount());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));







        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            //탭의 선택 상태가 변경될 때 호출되는 리스너
            //addOnTabSelectedListener를 통해 설정
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

//            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //          ((AppCompatActivity) getActivity()).getSupportActionBar().setCustomView(R.layout.action_bar);

        //Fragment 안에 버튼이 위치할 때는 페이지(액티비티) 이동이 가능하지만, 프래그먼트 이동은 불가능하다


        dateNow = (TextView) view.findViewById(R.id.text_date);
        dateNow.setText(date());

        return view;

    }
    //각 탭을 추가하고 각 탭 객체를 관리하는 FragmentStatePagerAdapter를 상속받는 PagerAdapter를 추가
    //탭이 변할때마다 position을 받아 Fragment를 전환해주는 역할을 한다.

    public class PagerAdapter extends FragmentStatePagerAdapter {

        //탭의 수
        int num_tab;

        public PagerAdapter(FragmentManager fm, int numOfTabs) {
            super(fm);
            this.num_tab = numOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Menu_Insung Insung= new Menu_Insung();



                    return Insung;
                case 1:
                    Menu_Hwan Hwan = new Menu_Hwan();
                    return Hwan;
                case 2:
                    Menu_Dorm Dorm = new Menu_Dorm();
                    return Dorm;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return num_tab;
        }
    }
    /*
    public void selectWeekMenu(View view){

        FragmentManager fM = ((AppCompatActivity)getActivity()).getSupportFragmentManager();
        FragmentTransaction fT = fM.beginTransaction();
        fT.replace(R.id.viewPager,new YQ_MenuWeekPage() );
    }
    */
    /*
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mI = getActivity().getMenuInflater();
        mI.inflate(R.menu.action_bar_map,menu);
        return super.onCreateOptionsMenu(menu);


    }
    */
}