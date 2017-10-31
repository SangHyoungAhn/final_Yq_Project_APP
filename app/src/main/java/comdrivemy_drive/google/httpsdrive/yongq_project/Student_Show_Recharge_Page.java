package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Student_Show_Recharge_Page.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Student_Show_Recharge_Page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Student_Show_Recharge_Page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static ArrayList<String> RcgWeekList = new ArrayList<String>();
    public static ArrayList<String> RcgMonthList = new ArrayList<String>();
    public static ArrayList<String> RcgThMonthList = new ArrayList<String>();


    private TabLayout tabLayout;

    public Student_Show_Recharge_Page(){


    }



    public void Init(ArrayList<String> list){

        list.clear();
        return ;
    }



    // private OnFragmentInteractionListener mListener;

    public  static Student_Show_Recharge_Page newInstance(String param1 , String param2) {


        Bundle args = new Bundle();
        Student_Show_Recharge_Page fragment = new Student_Show_Recharge_Page();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Student_Show_Recharge_Page.
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

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("충전 내역");
        View view= inflater.inflate(R.layout.fragment_student__show__recharge__page, container, false);


        tabLayout = (TabLayout)view.findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("1주일"));
        tabLayout.addTab(tabLayout.newTab().setText("1개월"));
        tabLayout.addTab(tabLayout.newTab().setText("3개월"));


        final ViewPager pager = (ViewPager)view.findViewById(R.id.viewPager);

        final Student_Show_Recharge_Page.PagerAdapter adapter = new Student_Show_Recharge_Page.PagerAdapter(getChildFragmentManager(),tabLayout.getTabCount());
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



        Params params = new Params();
        params.add("stu_id", Student_Login_Page.stu_id);

        new HttpNetwork("stuViewRcgWeek_Info.jsp",params.getParams(), new HttpNetwork.AsyncResponse()
        {
            @Override
            public void onSuccess (String response){

                try {

                    JSONArray useWeekArr = new JSONArray(response);
                    Init(RcgWeekList);

                    Log.d("kkkk",useWeekArr.toString());
                    for (int i = 0; i < useWeekArr.length(); i++) {

                        JSONObject weekOb = new JSONObject(useWeekArr.get(i).toString());
                        ArrayList<String> rcgWeekList = new ArrayList<String>();

                        rcgWeekList.add(weekOb.getString("date"));
                        rcgWeekList.add(weekOb.getString("stu_id"));
                        rcgWeekList.add(weekOb.getString("chain"));
                        rcgWeekList.add(weekOb.getString("mn_price"));
                        rcgWeekList.add(weekOb.getString("mn_name"));
                        rcgWeekList.add(weekOb.getString("f_use"));


                        RcgWeekList.add(rcgWeekList.get(0).toString());
                        RcgWeekList.add(rcgWeekList.get(1).toString());
                        RcgWeekList.add(rcgWeekList.get(2).toString());
                        RcgWeekList.add(rcgWeekList.get(3).toString());
                        RcgWeekList.add(rcgWeekList.get(4).toString());
                        RcgWeekList.add(rcgWeekList.get(5).toString());

                    }
                    Log.d("ssdsd", RcgWeekList.toString());
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


        Params mparams = new Params();
        mparams.add("stu_id", Student_Login_Page.stu_id);

        new HttpNetwork("stuViewRcgMth_Info.jsp",mparams.getParams(), new HttpNetwork.AsyncResponse()
        {
            @Override
            public void onSuccess (String response){

                try {

                    JSONArray useMthArr = new JSONArray(response);
                    Init(RcgMonthList);
                    Log.d("kkkk",useMthArr.toString());
                    for (int i = 0; i < useMthArr.length(); i++) {

                        JSONObject weekOb = new JSONObject(useMthArr.get(i).toString());
                        ArrayList<String> rcgMthList = new ArrayList<String>();

                        rcgMthList.add(weekOb.getString("date"));
                        rcgMthList.add(weekOb.getString("stu_id"));
                        rcgMthList.add(weekOb.getString("chain"));
                        rcgMthList.add(weekOb.getString("mn_price"));
                        rcgMthList.add(weekOb.getString("mn_name"));
                        rcgMthList.add(weekOb.getString("f_use"));


                        RcgMonthList.add(rcgMthList.get(0).toString());
                        RcgMonthList.add(rcgMthList.get(1).toString());
                        RcgMonthList.add(rcgMthList.get(2).toString());
                        RcgMonthList.add(rcgMthList.get(3).toString());
                        RcgMonthList.add(rcgMthList.get(4).toString());
                        RcgMonthList.add(rcgMthList.get(5).toString());

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

        Params thparams = new Params();
        thparams.add("stu_id", Student_Login_Page.stu_id);

        new HttpNetwork("stuViewRcgThMth_Info.jsp",thparams.getParams(), new HttpNetwork.AsyncResponse()
        {
            @Override
            public void onSuccess (String response){

                try {

                    JSONArray usethMthArr = new JSONArray(response);
                    Init(RcgThMonthList);
                    Log.d("kkkk",usethMthArr.toString());
                    for (int i = 0; i < usethMthArr.length(); i++) {

                        JSONObject weekOb = new JSONObject(usethMthArr.get(i).toString());
                        ArrayList<String> rcgthMthList = new ArrayList<String>();

                        rcgthMthList.add(weekOb.getString("date"));
                        rcgthMthList.add(weekOb.getString("stu_id"));
                        rcgthMthList.add(weekOb.getString("chain"));
                        rcgthMthList.add(weekOb.getString("mn_price"));
                        rcgthMthList.add(weekOb.getString("mn_name"));
                        rcgthMthList.add(weekOb.getString("f_use"));


                        RcgThMonthList.add(rcgthMthList.get(0).toString());
                        RcgThMonthList.add(rcgthMthList.get(1).toString());
                        RcgThMonthList.add(rcgthMthList.get(2).toString());
                        RcgThMonthList.add(rcgthMthList.get(3).toString());
                        RcgThMonthList.add(rcgthMthList.get(4).toString());
                        RcgThMonthList.add(rcgthMthList.get(5).toString());

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
                    Show_Recharge_Week rWeek  = new Show_Recharge_Week();
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("rcgWeekList", RcgWeekList);
                    // Log.d("cxcx", UsageWeekList.toString());
                    rWeek.setArguments(bundle);


                    return rWeek;
                case 1:


                    Show_Recharge_Month rMonth = new Show_Recharge_Month();
                    Bundle bundle2 = new Bundle();
                    bundle2.putStringArrayList("rcgMonthList", RcgMonthList);
                    // Log.d("cxcx", UsageMonthList.toString());
                    rMonth.setArguments(bundle2);
                    return rMonth;


                case 2:

                    Show_Recharge_ThMonth rThMonth = new Show_Recharge_ThMonth();

                    Bundle bundle3 = new Bundle();
                    bundle3.putStringArrayList("rcgThMonthList", RcgThMonthList);
                    //Log.d("cxcx", UsageThMonthList.toString());
                    rThMonth.setArguments(bundle3);


                    return rThMonth;



                default:
                    return null;

            }

        }

        @Override
        public int getCount() {
            return num_tab;
        }
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

