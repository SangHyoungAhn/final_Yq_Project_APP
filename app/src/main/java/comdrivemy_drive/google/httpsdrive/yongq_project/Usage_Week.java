package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Usage_Week.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Usage_Week#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Usage_Week extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TableLayout tableLayout;
    TableRow tableRow1;
    TableRow madeRow;
    Fragment fragment;

    //private OnFragmentInteractionListener mListener;

    public static Usage_Week newInstance(String param1, String param2) {



        Usage_Week fragment = new Usage_Week();
        Bundle args = new Bundle();
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
     * @return A new instance of fragment Usage_Week.
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
        View view= inflater.inflate(R.layout.fragment_usage__week, container, false);



        Bundle bundle = this.getArguments();
        bundle.getStringArrayList("useWeekList");
        ArrayList<String> useWeekStu = new ArrayList<String>();
        useWeekStu =bundle.getStringArrayList("useWeekList");

        Log.d("bung",useWeekStu.toString());


        tableLayout= (TableLayout)view.getRootView().findViewById(R.id.useWeekTable);

        tableRow1 = new TableRow(getActivity());
        tableRow1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tableRow1.setBackgroundColor(Color.parseColor("#0091EA"));

        TextView view_weekDate= new TextView(getActivity());
        view_weekDate.setGravity(Gravity.CENTER_HORIZONTAL);
        view_weekDate.setTextSize(20);
        view_weekDate.setText("일자");
        view_weekDate.setTextColor(Color.WHITE);
        tableRow1.addView(view_weekDate);

        TextView view_weekChain = new TextView(getActivity());
        view_weekChain.setGravity(Gravity.CENTER_HORIZONTAL);
        view_weekChain.setTextSize(20);
        view_weekChain.setText("장소");
        view_weekChain.setTextColor(Color.WHITE);
        tableRow1.addView(view_weekChain);


        TextView view_weekMenu = new TextView(getActivity());
        view_weekMenu.setGravity(Gravity.CENTER_HORIZONTAL);
        view_weekMenu.setTextSize(20);
        view_weekMenu.setText("메뉴명");
        view_weekMenu.setTextColor(Color.WHITE);
        tableRow1.addView(view_weekMenu);


        TextView view_weekPrice = new TextView(getActivity());
        view_weekPrice.setGravity(Gravity.CENTER_HORIZONTAL);
        view_weekPrice.setTextSize(20);
        view_weekPrice.setText("사용금액");
        view_weekPrice.setTextColor(Color.WHITE);
        tableRow1.addView(view_weekPrice);

        tableLayout.addView(tableRow1, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

        int i;
        for(i=0; i<useWeekStu.size(); i++){


            i=6*i;
            if(i >=useWeekStu.size()){
                break;
            }

            ArrayList<String>useWeekLastList = new ArrayList<String>();
            useWeekLastList.add(useWeekStu.get(i).toString());
            useWeekLastList.add(useWeekStu.get(i+1).toString());
            useWeekLastList.add(useWeekStu.get(i+2).toString());
            useWeekLastList.add(useWeekStu.get(i+3).toString());
            useWeekLastList.add(useWeekStu.get(i+4).toString());
            useWeekLastList.add(useWeekStu.get(i+5).toString());

//0,2,4,3
            i=i/6;
            Log.d("useWekk123",useWeekLastList.toString());

            for(int j=1; j<2; j++){

                madeRow = new TableRow(getActivity());
                madeRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

                TextView weekDate = new TextView(getActivity());
                weekDate.setId(10+j);
                weekDate.setText(useWeekLastList.get(0).toString());
                weekDate.setTextColor(Color.parseColor("#616161"));
                weekDate.setGravity(Gravity.CENTER_HORIZONTAL);
                weekDate.setTextSize(17);
                madeRow.addView(weekDate);


                TextView weekChain = new TextView(getActivity());
                weekChain.setId(60+j);
                weekChain.setText(useWeekLastList.get(2).toString());
                weekChain.setTextColor(Color.parseColor("#616161"));
                weekChain.setGravity(Gravity.CENTER_HORIZONTAL);
                weekChain.setTextSize(17);
                madeRow.addView(weekChain);

                TextView  weekMenu = new TextView(getActivity());
                weekMenu.setId(110+j);
                weekMenu.setText(useWeekLastList.get(4).toString());
                weekMenu.setTextColor(Color.parseColor("#616161"));
                weekMenu.setGravity(Gravity.CENTER_HORIZONTAL);
                weekMenu.setTextSize(17);
                madeRow.addView(weekMenu);

                TextView weekPrice = new TextView(getActivity());
                weekPrice.setId(160+j);
                weekPrice.setText(useWeekLastList.get(3).toString());
                weekPrice.setTextColor(Color.parseColor("#616161"));
                weekPrice.setGravity(Gravity.CENTER_HORIZONTAL);
                weekPrice.setTextSize(17);
                madeRow.addView(weekPrice);


                tableLayout.addView(madeRow, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

            }

        }


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
