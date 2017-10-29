package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
 * {@link Student_Foruse_Page.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Student_Foruse_Page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Student_Foruse_Page extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button UseWeekBtn;
    private Button UseMonthBtn;
    private Button UseThMonthBtn;
    Fragment fragment;

    public static ArrayList<String> UsageWeekList = new ArrayList<String>();

    //private OnFragmentInteractionListener mListener;

    public void Init(ArrayList<String> list){

        list.clear();
        return ;
    }


    public static Student_Foruse_Page newInstance() {
        // Required empty public constructor
        return new Student_Foruse_Page();
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("사용 내역");
        View view= inflater.inflate(R.layout.fragment_student__foruse__page, container, false);


        UseWeekBtn = (Button)view.findViewById(R.id.UseWeekBtn);
        UseWeekBtn.setOnClickListener(this);



        UseMonthBtn= (Button)view.findViewById(R.id.UseMonthBtn);
        UseMonthBtn.setOnClickListener(this);

        UseThMonthBtn= (Button)view.findViewById(R.id.UseThMonthBtn);
        UseThMonthBtn.setOnClickListener(this);





        return view;

    }

    public void onClick(View view){

        //Fragment fragment;
        switch(view.getId()){


            case R.id.UseWeekBtn:

                        Params params = new Params();
                        params.add("stu_id",Student_Login_Page.stu_id);
                        new HttpNetwork("stuViewUse_Info.jsp", params.getParams(), new HttpNetwork.AsyncResponse()
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

            case R.id.UseMonthBtn:
                fragment=Usage_Month.newInstance();
                setChildFragment(fragment);
                break;

            case R.id.UseThMonthBtn:
                fragment=Usage_ThMonth.newInstance();
                setChildFragment(fragment);
                break;
        }
    }


    private void setChildFragment(Fragment child)
    {
        FragmentTransaction fT = getChildFragmentManager().beginTransaction();

        if(!child.isAdded()){
            fT.replace(R.id.Usage_contents,child);
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
