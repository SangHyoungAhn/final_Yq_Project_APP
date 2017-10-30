package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Usage_Month.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Usage_Month#newInstance} factory method to
 * create an instance of this fragment.
 */



public class Usage_Month extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TableLayout tableLayout;
    TableRow tableRow1;
    TableRow madeRow;



    private String mParam1;
    private String mParam2;

    //private OnFragmentInteractionListener mListener;

    public static Usage_Month newInstance(String param1 , String param2) {

        Usage_Month fragment = new Usage_Month();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

        // Required empty public constructor
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

        View view=  inflater.inflate(R.layout.fragment_usage__month, container, false);


        Bundle bundle = this.getArguments();
        bundle.getStringArrayList("useMonthList");
        ArrayList<String> useMonthStu = new ArrayList<String>();
        useMonthStu = bundle.getStringArrayList("useMonthList");


        Log.d("bungMonth",useMonthStu.toString());


        tableLayout= (TableLayout)view.getRootView().findViewById(R.id.useMthTable);

        tableRow1 = new TableRow(getActivity());
        tableRow1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tableRow1.setBackgroundColor(Color.parseColor("#0091EA"));

        TextView view_mthDate= new TextView(getActivity());
        view_mthDate.setGravity(Gravity.CENTER_HORIZONTAL);
        view_mthDate.setTextSize(20);
        view_mthDate.setText("일자");
        view_mthDate.setTextColor(Color.WHITE);
        tableRow1.addView(view_mthDate);

        TextView view_mthChain = new TextView(getActivity());
        view_mthChain.setGravity(Gravity.CENTER_HORIZONTAL);
        view_mthChain.setTextSize(20);
        view_mthChain.setText("장소");
        view_mthChain.setTextColor(Color.WHITE);
        tableRow1.addView(view_mthChain);


        TextView view_mthMenu = new TextView(getActivity());
        view_mthMenu.setGravity(Gravity.CENTER_HORIZONTAL);
        view_mthMenu.setTextSize(20);
        view_mthMenu.setText("메뉴명");
        view_mthMenu.setTextColor(Color.WHITE);
        tableRow1.addView(view_mthMenu);


        TextView view_mthPrice = new TextView(getActivity());
        view_mthPrice.setGravity(Gravity.CENTER_HORIZONTAL);
        view_mthPrice.setTextSize(20);
        view_mthPrice.setText("사용금액");
        view_mthPrice.setTextColor(Color.WHITE);
        tableRow1.addView(view_mthPrice);

        tableLayout.addView(tableRow1, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

        int i;
        for(i=0; i<useMonthStu.size(); i++){


            i=6*i;
            if(i>=useMonthStu.size()){
                break;
            }

            ArrayList<String>useMthLastList = new ArrayList<String>();
            useMthLastList.add(useMonthStu.get(i).toString());
            useMthLastList.add(useMonthStu.get(i+1).toString());
            useMthLastList.add(useMonthStu.get(i+2).toString());
            useMthLastList.add(useMonthStu.get(i+3).toString());
            useMthLastList.add(useMonthStu.get(i+4).toString());
            useMthLastList.add(useMonthStu.get(i+5).toString());

//0,2,4,3
            i=i/6;
            Log.d("useMth123",useMthLastList.toString());

            for(int j=1; j<2; j++){

                madeRow = new TableRow(getActivity());
                madeRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

                TextView mthDate = new TextView(getActivity());
                mthDate.setId(10+j);
                mthDate.setText(useMthLastList.get(0).toString());
                mthDate.setTextColor(Color.parseColor("#616161"));
                mthDate.setGravity(Gravity.CENTER_HORIZONTAL);
                mthDate.setTextSize(17);
                madeRow.addView(mthDate);


                TextView mthChain = new TextView(getActivity());
                mthChain.setId(60+j);
                mthChain.setText(useMthLastList.get(2).toString());
                mthChain.setTextColor(Color.parseColor("#616161"));
                mthChain.setGravity(Gravity.CENTER_HORIZONTAL);
                mthChain.setTextSize(17);
                madeRow.addView(mthChain);

                TextView  mthMenu = new TextView(getActivity());
                mthMenu.setId(110+j);
                mthMenu.setText(useMthLastList.get(4).toString());
                mthMenu.setTextColor(Color.parseColor("#616161"));
                mthMenu.setGravity(Gravity.CENTER_HORIZONTAL);
                mthMenu.setTextSize(17);
                madeRow.addView(mthMenu);

                TextView mthPrice = new TextView(getActivity());
                mthPrice.setId(160+j);
                mthPrice.setText(useMthLastList.get(3).toString());
                mthPrice.setTextColor(Color.parseColor("#616161"));
                mthPrice.setGravity(Gravity.CENTER_HORIZONTAL);
                mthPrice.setTextSize(17);
                madeRow.addView(mthPrice);


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
