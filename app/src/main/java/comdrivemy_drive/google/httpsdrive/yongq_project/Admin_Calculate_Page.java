package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
 * {@link Admin_Calculate_Page.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Admin_Calculate_Page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Admin_Calculate_Page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText totDateText;
    EditText totChainText;
    TextView adminTotText;
    TextView adminTotMenuText;
    Button adminTotSearch;
    TableLayout tableLayout;
    TableRow tableRow1;
    TableRow madeRow;

    ArrayList<String>adTotLastList = new ArrayList<String>();
    ArrayList<String>adTotAwardLastList = new ArrayList<String>();
    //private OnFragmentInteractionListener mListener;

    public void Init(ArrayList<String> lit){

        lit.clear();
        return;
    }


    public Admin_Calculate_Page() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Admin_Calculate_Page.
     */
    // TODO: Rename and change types and number of parameters
    public static Admin_Calculate_Page newInstance(String param1, String param2) {
        Admin_Calculate_Page fragment = new Admin_Calculate_Page();
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

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("정 산");
         final View  view =inflater.inflate(R.layout.fragment_admin__calculate__page, container, false);

         totDateText = (EditText)view.findViewById(R.id.totDateText);
         totChainText= (EditText)view.findViewById(R.id.totChainText);
         adminTotText= (TextView)view.findViewById(R.id.adminTotText);

         adminTotSearch=(Button)view.findViewById(R.id.adminTotSearch);


        adminTotSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                Params params = new Params();

                params.add("date", totDateText.getText().toString());
                params.add("chain", totChainText.getText().toString());


                new HttpNetwork("adTotuse.jsp", params.getParams(), new HttpNetwork.AsyncResponse() {
                    @Override
                    public void onSuccess(String response) {


                        try {


                            JSONArray totUseArr = new JSONArray(response);
                            Init(adTotLastList);

                            for (int i = 0; i < totUseArr.length(); i++) {

                                JSONObject totOb = new JSONObject(totUseArr.get(i).toString());
                                ArrayList<String> adTotList = new ArrayList<String>();

                                adTotList.add(totOb.getString("adTot"));
                                adTotLastList.add(adTotList.get(0).toString());
                                Log.d("mvmcv", adTotLastList.toString());
                            }
                            Log.d("mv223v", adTotLastList.toString());

                            adminTotText.setText(adTotLastList.get(0).toString());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(String response) {
                    }

                    public void onPreExcute() {
                    }


                });


                Params params2 = new Params();

                params2.add("date", totDateText.getText().toString());
                params2.add("chain", totChainText.getText().toString());


                new HttpNetwork("adTotuseAward.jsp", params2.getParams(), new HttpNetwork.AsyncResponse() {
                    @Override
                    public void onSuccess(String response) {

                        try {

                            JSONArray totUseArr = new JSONArray(response);
                            Init(adTotAwardLastList);
                            for (int i = 0; i < totUseArr.length(); i++) {

                                JSONObject totOb = new JSONObject(totUseArr.get(i).toString());

                                ArrayList<String> adTotawardList = new ArrayList<String>();
                                adTotawardList.add(totOb.getString("getAward"));
                                adTotawardList.add(totOb.getString("mn_name"));

                                adTotAwardLastList.add(adTotawardList.get(0).toString());
                                adTotAwardLastList.add(adTotawardList.get(1).toString());


                            }
                                Log.d("kvnxxcv",adTotAwardLastList.toString());
                            tableLayout = (TableLayout)view.getRootView().findViewById(R.id.awardTable);

                            //when create table automatically , tableRow1 is fixed row.
                            tableRow1 = new TableRow(getActivity());
                            tableRow1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
                            tableRow1.setBackgroundColor(Color.parseColor("#0091EA"));


                            TextView view_menu_sort = new TextView(getActivity());
                            view_menu_sort.setGravity(Gravity.CENTER_HORIZONTAL);
                            view_menu_sort.setTextSize(20);
                            view_menu_sort.setText("메뉴명");
                            view_menu_sort.setTextColor(Color.WHITE);

                            tableRow1.addView(view_menu_sort);


                            TextView view_menu_name = new TextView(getActivity());
                            view_menu_name.setGravity(Gravity.CENTER_HORIZONTAL);
                            view_menu_name.setTextSize(20);
                            view_menu_name.setText("구매횟수");
                            view_menu_name.setTextColor(Color.WHITE);
                            tableRow1.addView(view_menu_name);

                            int i;
                            for (i = 0; i < adTotAwardLastList.size(); i=i+2) {


                                if (i >= adTotAwardLastList.size()) {
                                    break;
                                }
                                ArrayList<String> adLastList = new ArrayList<String>();
                                adLastList.add(adTotAwardLastList.get(i).toString());
                                adLastList.add(adTotAwardLastList.get(i + 1).toString());


                                Log.d("correctInsungList", adLastList.toString());
                                for (int j = 1; j < 2; j++) {

                                    madeRow = new TableRow(getActivity());
                                    madeRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

                                    TextView insungTypeText = new TextView(getActivity());
                                    insungTypeText.setId(10 + j);
                                    insungTypeText.setText(adLastList.get(1).toString());
                                    insungTypeText.setTextColor(Color.parseColor("#616161"));
                                    insungTypeText.setGravity(Gravity.CENTER_HORIZONTAL);
                                    insungTypeText.setTextSize(17);
                                    madeRow.addView(insungTypeText);


                                    TextView insungMenuText = new TextView(getActivity());
                                    insungMenuText.setId(50 + j);
                                    insungMenuText.setText(adLastList.get(0).toString());
                                    insungMenuText.setTextColor(Color.parseColor("#616161"));
                                    insungMenuText.setGravity(Gravity.CENTER_HORIZONTAL);
                                    insungMenuText.setTextSize(17);
                                    madeRow.addView(insungMenuText);


                                    tableLayout.addView(madeRow, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

                                }

                            }

                            totDateText.getText().clear();
                            totChainText.getText().clear();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(String response) {
                    }

                    public void onPreExcute() {
                    }


                });

            }
        });

        return view;
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
