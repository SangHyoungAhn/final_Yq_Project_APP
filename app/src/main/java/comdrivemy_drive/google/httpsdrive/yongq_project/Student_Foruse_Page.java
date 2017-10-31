package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Student_Foruse_Page.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Student_Foruse_Page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Student_Foruse_Page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    Fragment fragment;

    private TabLayout tabLayout;

    public static ArrayList<String> UsageWeekList = new ArrayList<String>();
    public static ArrayList<String> UsageMonthList = new ArrayList<String>();
    public static ArrayList<String> UsageThMonthList = new ArrayList<String>();


    public Student_Foruse_Page(){


    }


    public void Init(ArrayList<String> list){

        list.clear();
        return ;
    }


    public static Student_Foruse_Page newInstance(String param1 , String param2) {
        // Required empty public constructor
        Bundle args = new Bundle();
        Student_Foruse_Page fragment = new Student_Foruse_Page();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Student_Foruse_Page.
     */
    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("사용 내역");

        View view= inflater.inflate(R.layout.fragment_student__foruse__page, container, false);


        tabLayout = (TabLayout)view.findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("1주일"));
        tabLayout.addTab(tabLayout.newTab().setText("1개월"));
        tabLayout.addTab(tabLayout.newTab().setText("3개월"));


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






        //주
        Params params = new Params();
        params.add("stu_id", Student_Login_Page.stu_id);

        new HttpNetwork("stuViewUseWeek_Info.jsp",params.getParams(), new HttpNetwork.AsyncResponse()
        {
            @Override
            public void onSuccess (String response){

                try {

                    JSONArray useWeekArr = new JSONArray(response);
                    Init(UsageWeekList);

                    Log.d("kkkk",useWeekArr.toString());
                    for (int i = 0; i < useWeekArr.length(); i++) {

                        JSONObject weekOb = new JSONObject(useWeekArr.get(i).toString());
                        ArrayList<String> useWeekList = new ArrayList<String>();

                        useWeekList.add(weekOb.getString("date"));
                        useWeekList.add(weekOb.getString("stu_id"));
                        useWeekList.add(weekOb.getString("chain"));
                        useWeekList.add(weekOb.getString("mn_price"));
                        useWeekList.add(weekOb.getString("mn_name"));
                        useWeekList.add(weekOb.getString("f_use"));


                        UsageWeekList.add(useWeekList.get(0).toString());
                        UsageWeekList.add(useWeekList.get(1).toString());
                        UsageWeekList.add(useWeekList.get(2).toString());
                        UsageWeekList.add(useWeekList.get(3).toString());
                        UsageWeekList.add(useWeekList.get(4).toString());
                        UsageWeekList.add(useWeekList.get(5).toString());

                    }
                    Log.d("ssdsd", UsageWeekList.toString());
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




        //달
        Params mparams = new Params();
        mparams.add("stu_id", Student_Login_Page.stu_id);

        new HttpNetwork("stuViewUseMth_Info.jsp",mparams.getParams(), new HttpNetwork.AsyncResponse()
        {
            @Override
            public void onSuccess (String response){

                try {

                    JSONArray useMthArr = new JSONArray(response);
                    Init(UsageMonthList);
                    Log.d("kkkk",useMthArr.toString());
                    for (int i = 0; i < useMthArr.length(); i++) {

                        JSONObject weekOb = new JSONObject(useMthArr.get(i).toString());
                        ArrayList<String> useMthList = new ArrayList<String>();

                        useMthList.add(weekOb.getString("date"));
                        useMthList.add(weekOb.getString("stu_id"));
                        useMthList.add(weekOb.getString("chain"));
                        useMthList.add(weekOb.getString("mn_price"));
                        useMthList.add(weekOb.getString("mn_name"));
                        useMthList.add(weekOb.getString("f_use"));


                        UsageMonthList.add(useMthList.get(0).toString());
                        UsageMonthList.add(useMthList.get(1).toString());
                        UsageMonthList.add(useMthList.get(2).toString());
                        UsageMonthList.add(useMthList.get(3).toString());
                        UsageMonthList.add(useMthList.get(4).toString());
                        UsageMonthList.add(useMthList.get(5).toString());

                    }
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





        //3달

        Params thparams = new Params();
        thparams.add("stu_id", Student_Login_Page.stu_id);

        new HttpNetwork("stuViewUseThMth_Info.jsp",thparams.getParams(), new HttpNetwork.AsyncResponse()
        {
            @Override
            public void onSuccess (String response){

                try {

                    JSONArray usethMthArr = new JSONArray(response);
                    Init(UsageThMonthList);
                    Log.d("kkkk",usethMthArr.toString());
                    for (int i = 0; i < usethMthArr.length(); i++) {

                        JSONObject weekOb = new JSONObject(usethMthArr.get(i).toString());
                        ArrayList<String> usethMthList = new ArrayList<String>();

                        usethMthList.add(weekOb.getString("date"));
                        usethMthList.add(weekOb.getString("stu_id"));
                        usethMthList.add(weekOb.getString("chain"));
                        usethMthList.add(weekOb.getString("mn_price"));
                        usethMthList.add(weekOb.getString("mn_name"));
                        usethMthList.add(weekOb.getString("f_use"));


                        UsageThMonthList.add(usethMthList.get(0).toString());
                        UsageThMonthList.add(usethMthList.get(1).toString());
                        UsageThMonthList.add(usethMthList.get(2).toString());
                        UsageThMonthList.add(usethMthList.get(3).toString());
                        UsageThMonthList.add(usethMthList.get(4).toString());
                        UsageThMonthList.add(usethMthList.get(5).toString());

                    }
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

        return view;

    }

    public class PagerAdapter extends FragmentStatePagerAdapter {

        //탭의 수
        int num_tab;


        public PagerAdapter(FragmentManager fm, int numOfTabs) {
            super(fm);
            this.num_tab = numOfTabs;
        }

        public Fragment getItem(int position) {
            switch (position) {

                case 0:

                    Usage_Week uWeek = new Usage_Week();
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("useWeekList", UsageWeekList);
                   // Log.d("cxcx", UsageWeekList.toString());
                    uWeek.setArguments(bundle);

                    return uWeek;

                case 1:



                    Usage_Month uMonth = new Usage_Month();

                    Bundle bundle2 = new Bundle();
                    bundle2.putStringArrayList("useMonthList", UsageMonthList);
                   // Log.d("cxcx", UsageMonthList.toString());
                    uMonth.setArguments(bundle2);
                    return uMonth;

                case 2:


                    Usage_ThMonth thMonth = new Usage_ThMonth();

                    Bundle bundle3 = new Bundle();
                    bundle3.putStringArrayList("useThMonthList", UsageThMonthList);
                    //Log.d("cxcx", UsageThMonthList.toString());
                    thMonth.setArguments(bundle3);

                    return thMonth;


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
                    public void onClick(View view){

        //Fragment fragment;
        switch(view.getId()){


            case R.id.UseWeekBtn:

                        final Params params = new Params();
                        params.add("stu_id",Student_Login_Page.stu_id);
                        Log.d("kk","hello");
                        new HttpNetwork("stuViewUseWeek_Info.jsp", params.getParams(), new HttpNetwork.AsyncResponse()
                        {

                            @Override
                            public void onSuccess(String response) {


                                JSONObject json = null;

                                try {
                                    JSONArray useWeekArr = new JSONArray(response);
                                    Init(UsageWeekList);
                                    Log.d("kk245",useWeekArr.toString());

                                    for (int i = 0; i < useWeekArr.length(); i++) {

                                        JSONObject jOb = new JSONObject(useWeekArr.get(i).toString());
                                        ArrayList<String> useWeekList = new ArrayList<String>();

                                        useWeekList.add(jOb.getString("date"));
                                        useWeekList.add(jOb.getString("stu_id"));
                                        useWeekList.add(jOb.getString("chain"));
                                        useWeekList.add(jOb.getString("mn_price"));
                                        useWeekList.add(jOb.getString("mn_name"));
                                        useWeekList.add(jOb.getString("f_use"));


                                        UsageWeekList.add(useWeekList.get(0).toString());
                                        UsageWeekList.add(useWeekList.get(1).toString());
                                        UsageWeekList.add(useWeekList.get(2).toString());
                                        UsageWeekList.add(useWeekList.get(3).toString());
                                        UsageWeekList.add(useWeekList.get(4).toString());
                                        UsageWeekList.add(useWeekList.get(5).toString());
                                        Log.d("use123",useWeekList.toString());
                                    }


                                    Log.d("123235555d",UsageWeekList.toString());
                                } catch (JSONException e) {
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

                Log.d("kk2134a",UsageWeekList.toString());
                Log.d("kk2134a",UsageWeekList.toString());
                fragment=Usage_Week.newInstance();
                Log.d("kk2134b",UsageWeekList.toString());
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("useWeekList",UsageWeekList);
                Log.d("kk2134c",UsageWeekList.toString());
                fragment.setArguments(bundle);

                setChildFragment(fragment);
                break;

            case R.id.UseMonthBtn:

                Params mthparams = new Params();
                mthparams.add("stu_id",Student_Login_Page.stu_id);
                new HttpNetwork("stuViewUseMth.jsp", mthparams.getParams(), new HttpNetwork.AsyncResponse()
                {
                    @Override
                    public void onSuccess(String response) {


                        JSONObject json = null;

                        try {

                            JSONArray useMonthArr = new JSONArray(response);
                            Init(UsageMonthList);

                            for (int i = 0; i < useMonthArr.length(); i++) {

                                JSONObject jOb = new JSONObject(useMonthArr.get(i).toString());


                                ArrayList<String> useMonthList = new ArrayList<String>();

                                useMonthList.add(jOb.getString("date"));
                                useMonthList.add(jOb.getString("stu_id"));
                                useMonthList.add(jOb.getString("chain"));
                                useMonthList.add(jOb.getString("mn_price"));
                                useMonthList.add(jOb.getString("mn_name"));
                                useMonthList.add(jOb.getString("f_use"));


                                UsageMonthList.add(useMonthList.get(0).toString());
                                UsageMonthList.add(useMonthList.get(1).toString());
                                UsageMonthList.add(useMonthList.get(2).toString());
                                UsageMonthList.add(useMonthList.get(3).toString());
                                UsageMonthList.add(useMonthList.get(4).toString());
                                UsageMonthList.add(useMonthList.get(5).toString());

                            }



                        } catch (JSONException e) {
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

                fragment=Usage_Month.newInstance();
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("useMonthList",UsageMonthList);
                fragment.setArguments(bundle2);
                setChildFragment(fragment);
                break;


            case R.id.UseThMonthBtn:

                Params thparams = new Params();
                thparams.add("stu_id",Student_Login_Page.stu_id);
                new HttpNetwork("stuViewUseThMth.jsp", thparams.getParams(), new HttpNetwork.AsyncResponse()
                {
                    @Override
                    public void onSuccess(String response) {

                        JSONObject json = null;
                        try {
                            JSONArray useThMonthArr = new JSONArray(response);
                            Init(UsageThMonthList);

                            for (int i = 0; i < useThMonthArr.length(); i++) {

                                JSONObject jOb = new JSONObject(useThMonthArr.get(i).toString());

                                ArrayList<String> useThMonthList = new ArrayList<String>();

                                useThMonthList.add(jOb.getString("date"));
                                useThMonthList.add(jOb.getString("stu_id"));
                                useThMonthList.add(jOb.getString("chain"));
                                useThMonthList.add(jOb.getString("mn_price"));
                                useThMonthList.add(jOb.getString("mn_name"));
                                useThMonthList.add(jOb.getString("f_use"));


                                UsageThMonthList.add(useThMonthList.get(0).toString());
                                UsageThMonthList.add(useThMonthList.get(1).toString());
                                UsageThMonthList.add(useThMonthList.get(2).toString());
                                UsageThMonthList.add(useThMonthList.get(3).toString());
                                UsageThMonthList.add(useThMonthList.get(4).toString());
                                UsageThMonthList.add(useThMonthList.get(5).toString());

                            }
                        } catch (JSONException e) {
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
                fragment=Usage_ThMonth.newInstance();
                Bundle bundle3 = new Bundle();
                bundle3.putStringArrayList("useThMonthList",UsageThMonthList);
                fragment.setArguments(bundle3);
                setChildFragment(fragment);

        }
    }


    private void setChildFragment(Fragment fragment)
    {
        FragmentTransaction fT = getFragmentManager().beginTransaction();

        if(!fragment.isAdded()){
            fT.replace(R.id.Usage_contents,fragment);
            fT.addToBackStack(null);
            fT.commit();
        }


    }

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
}
