package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link YQ_Week_Menu.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link YQ_Week_Menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YQ_Week_Menu extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static ArrayList<String>insungWeekMenu = new ArrayList<String>();
    public static ArrayList<String>hwanWeekMenu = new ArrayList<String>();
    public static ArrayList<String>dormWeekMenu = new ArrayList<String>();

   //private OnFragmentInteractionListener mListener;

    TabLayout tabLayout;

    public void Init(ArrayList<String> list){

        list.clear();
        return;



    }




    public YQ_Week_Menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment YQ_Week_Menu.
     */
    // TODO: Rename and change types and number of parameters
    public static YQ_Week_Menu newInstance(String param1, String param2) {
        YQ_Week_Menu fragment = new YQ_Week_Menu();
        Bundle args = new Bundle();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("주간 메뉴");
        View view= inflater.inflate(R.layout.fragment_yq__week__menu, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.sliding_week_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("인성관"));
        tabLayout.addTab(tabLayout.newTab().setText("환과대"));
        tabLayout.addTab(tabLayout.newTab().setText("기숙사"));


        final ViewPager pager = (ViewPager)view.findViewById(R.id.week_viewPager);
        final PagerAdapter adapter = new PagerAdapter(getChildFragmentManager(),tabLayout.getTabCount());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){


            public void onTabSelected(TabLayout.Tab tab){
                pager.setCurrentItem(tab.getPosition());
            }


            public void onTabUnselected(TabLayout.Tab tab)
            {


            }



            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });

        Params params =new Params();

        new HttpNetwork("menuWeek_Info.jsp",params.getParams(),new HttpNetwork.AsyncResponse(){
            @Override
            public void onSuccess(String response) {

                JSONObject json =null;

                try{

                    JSONArray weekmenuArr =new JSONArray(response);
                    Init(insungWeekMenu);
                    Init(hwanWeekMenu);
                    Init(dormWeekMenu);


                    for(int i=0; i<weekmenuArr.length();i++){

                        JSONObject menuWeekOb = new JSONObject(weekmenuArr.get(i).toString());

                        ArrayList<String> menuWeekList = new ArrayList<String>();

                        menuWeekList.add(menuWeekOb.getString("mn_date"));
                        menuWeekList.add(menuWeekOb.getString("chain"));
                        menuWeekList.add(menuWeekOb.getString("mn_type"));
                        menuWeekList.add(menuWeekOb.getString("mn_name"));
                        menuWeekList.add(menuWeekOb.getString("mn_price"));

                        Log.d("skt1",menuWeekList.toString());
                        if(menuWeekList.get(1).equals("환경과학대")){


                            hwanWeekMenu.add(menuWeekList.get(0).toString());
                            hwanWeekMenu.add(menuWeekList.get(1).toString());
                            hwanWeekMenu.add(menuWeekList.get(2).toString());
                            hwanWeekMenu.add(menuWeekList.get(3).toString());
                            hwanWeekMenu.add(menuWeekList.get(4).toString());

                        }


                        if(menuWeekList.get(1).equals("인성관")){

                            insungWeekMenu.add(menuWeekList.get(0).toString());
                            insungWeekMenu.add(menuWeekList.get(1).toString());
                            insungWeekMenu.add(menuWeekList.get(2).toString());
                            insungWeekMenu.add(menuWeekList.get(3).toString());
                            insungWeekMenu.add(menuWeekList.get(4).toString());

                        }

                        if(menuWeekList.get(1).equals("생활관")){

                            dormWeekMenu.add(menuWeekList.get(0).toString());
                            dormWeekMenu.add(menuWeekList.get(1).toString());
                            dormWeekMenu.add(menuWeekList.get(2).toString());
                            dormWeekMenu.add(menuWeekList.get(3).toString());
                            dormWeekMenu.add(menuWeekList.get(4).toString());

                        }


                        Log.d("weekkk",menuWeekList.toString());


                    }
                    Log.d("weekInsung",insungWeekMenu.toString());
                    Log.d("weekHwan",hwanWeekMenu.toString());
                    Log.d("weekDorm",dormWeekMenu.toString());

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




        return view;
    }


    public class PagerAdapter extends FragmentStatePagerAdapter {
        int num_tab;


        public PagerAdapter(FragmentManager fM, int numOfTabs){

            super(fM);
            this.num_tab=numOfTabs;


        }

        public Fragment getItem(int position){
            switch(position){
                case 0:
                    Week_Menu_Insung week_Insung = new Week_Menu_Insung();

                    Bundle bundle =new Bundle();
                    bundle.putStringArrayList("weekmenuInsung",insungWeekMenu);
                    Log.d("weekmenuInsung",insungWeekMenu.toString());
                    week_Insung.setArguments(bundle);


                    return week_Insung;

                case 1:
                    Week_Menu_Hwan week_Hwan = new Week_Menu_Hwan();


                    Bundle bundle2 =new Bundle();
                    bundle2.putStringArrayList("weekmenuHwan",hwanWeekMenu);
                    Log.d("weekmenuHwan",hwanWeekMenu.toString());
                    week_Hwan.setArguments(bundle2);

                    return week_Hwan;

                case 2:
                    Week_Menu_Dorm week_Dorm = new Week_Menu_Dorm();

                    Bundle bundle3 =new Bundle();
                    bundle3.putStringArrayList("weekmenuDorm",dormWeekMenu);
                    Log.d("weekmenuDorm",dormWeekMenu.toString());
                    week_Dorm.setArguments(bundle3);

                    return week_Dorm;

                default:
                    return null;
            }
        }

        public int getCount() { return num_tab;}
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
