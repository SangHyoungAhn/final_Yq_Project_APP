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
 * {@link Usage_ThMonth.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Usage_ThMonth#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Usage_ThMonth extends Fragment {
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
    //private OnFragmentInteractionListener mListener;

    public  static Usage_ThMonth newInstance(String param1 ,String param2) {



        Usage_ThMonth fragment = new Usage_ThMonth();
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
     * @return A new instance of fragment Usage_ThMonth.
     */
    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        super.onCreate(savedInstanceState);


        }
    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_usage__th_month, container, false);




        Bundle bundle = this.getArguments();
        bundle.getStringArrayList("useThMonthList");
        ArrayList<String> useThMthStu = new ArrayList<String>();
        useThMthStu =bundle.getStringArrayList("useThMonthList");

        Log.d("bungThMth123",useThMthStu.toString());

        tableLayout= (TableLayout)view.getRootView().findViewById(R.id.useThMthTable);

        tableRow1 = new TableRow(getActivity());
        tableRow1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tableRow1.setBackgroundColor(Color.parseColor("#0091EA"));

        TextView view_thMthDate= new TextView(getActivity());
        view_thMthDate.setGravity(Gravity.CENTER_HORIZONTAL);
        view_thMthDate.setTextSize(20);
        view_thMthDate.setText("일자");
        view_thMthDate.setTextColor(Color.WHITE);
        tableRow1.addView(view_thMthDate);

        TextView view_thMthChain = new TextView(getActivity());
        view_thMthChain.setGravity(Gravity.CENTER_HORIZONTAL);
        view_thMthChain.setTextSize(20);
        view_thMthChain.setText("장소");
        view_thMthChain.setTextColor(Color.WHITE);
        tableRow1.addView(view_thMthChain);


        TextView view_thMthMenu = new TextView(getActivity());
        view_thMthMenu.setGravity(Gravity.CENTER_HORIZONTAL);
        view_thMthMenu.setTextSize(20);
        view_thMthMenu.setText("메뉴명");
        view_thMthMenu.setTextColor(Color.WHITE);
        tableRow1.addView(view_thMthMenu);


        TextView view_thMthPrice = new TextView(getActivity());
        view_thMthPrice.setGravity(Gravity.CENTER_HORIZONTAL);
        view_thMthPrice.setTextSize(20);
        view_thMthPrice.setText("사용금액");
        view_thMthPrice.setTextColor(Color.WHITE);
        tableRow1.addView(view_thMthPrice);

        tableLayout.addView(tableRow1, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

        int i;
        for(i=0; i<useThMthStu.size(); i++){


            i=6*i;
            if(i>=useThMthStu.size()){
                break;
            }

            ArrayList<String>useThMthLastList = new ArrayList<String>();
            useThMthLastList.add(useThMthStu.get(i).toString());
            useThMthLastList.add(useThMthStu.get(i+1).toString());
            useThMthLastList.add(useThMthStu.get(i+2).toString());
            useThMthLastList.add(useThMthStu.get(i+3).toString());
            useThMthLastList.add(useThMthStu.get(i+4).toString());
            useThMthLastList.add(useThMthStu.get(i+5).toString());

//0,2,4,3
            i=i/6;
            Log.d("usethMth123",useThMthLastList.toString());

            for(int j=1; j<2; j++){

                madeRow = new TableRow(getActivity());
                madeRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

                TextView thMthDate = new TextView(getActivity());
                thMthDate.setId(10+j);
                thMthDate.setText(useThMthLastList.get(0).toString());
                thMthDate.setTextColor(Color.parseColor("#616161"));
                thMthDate.setGravity(Gravity.CENTER_HORIZONTAL);
                thMthDate.setTextSize(17);
                madeRow.addView(thMthDate);


                TextView thMthChain = new TextView(getActivity());
                thMthChain.setId(60+j);
                thMthChain.setText(useThMthLastList.get(2).toString());
                thMthChain.setTextColor(Color.parseColor("#616161"));
                thMthChain.setGravity(Gravity.CENTER_HORIZONTAL);
                thMthChain.setTextSize(17);
                madeRow.addView(thMthChain);

                TextView  thMthMenu = new TextView(getActivity());
                thMthMenu.setId(110+j);
                thMthMenu.setText(useThMthLastList.get(4).toString());
                thMthMenu.setTextColor(Color.parseColor("#616161"));
                thMthMenu.setGravity(Gravity.CENTER_HORIZONTAL);
                thMthMenu.setTextSize(17);
                madeRow.addView(thMthMenu);

                TextView thMthPrice = new TextView(getActivity());
                thMthPrice.setId(160+j);
                thMthPrice.setText(useThMthLastList.get(3).toString());
                thMthPrice.setTextColor(Color.parseColor("#616161"));
                thMthPrice.setGravity(Gravity.CENTER_HORIZONTAL);
                thMthPrice.setTextSize(17);
                madeRow.addView(thMthPrice);


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
