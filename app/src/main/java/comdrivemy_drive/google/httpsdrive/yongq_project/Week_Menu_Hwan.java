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
 * {@link Week_Menu_Hwan.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Week_Menu_Hwan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Week_Menu_Hwan extends Fragment {
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

    public Week_Menu_Hwan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Week_Menu_Hwan.
     */
    // TODO: Rename and change types and number of parameters
    public static Week_Menu_Hwan newInstance(String param1, String param2) {
        Week_Menu_Hwan fragment = new Week_Menu_Hwan();
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
        View view= inflater.inflate(R.layout.fragment_week__menu__hwan, container, false);

        Bundle bundle = this.getArguments();
        bundle.getStringArrayList("weekmenuHwan");
        ArrayList<String>HwanWeekMenu = new ArrayList<String>();
        HwanWeekMenu=bundle.getStringArrayList("weekmenuHwan");


        tableLayout = (TableLayout)view.getRootView().findViewById(R.id.hwanWeekTable);

        tableRow1 = new TableRow(getActivity());
        tableRow1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tableRow1.setBackgroundColor(Color.parseColor("#0091EA"));

        TextView view_menu_date = new TextView(getActivity());
        view_menu_date.setGravity(Gravity.CENTER_HORIZONTAL);
        view_menu_date.setTextSize(20);
        view_menu_date.setText("날짜");
        view_menu_date.setTextColor(Color.WHITE);
        tableRow1.addView(view_menu_date);



        TextView view_menu_sort = new TextView(getActivity());
        view_menu_sort.setGravity(Gravity.CENTER_HORIZONTAL);
        view_menu_sort.setTextSize(20);
        view_menu_sort.setText("종류");
        view_menu_sort.setTextColor(Color.WHITE);
        tableRow1.addView(view_menu_sort);


        TextView view_menu_name = new TextView(getActivity());
        view_menu_name.setGravity(Gravity.CENTER_HORIZONTAL);
        view_menu_name.setTextSize(20);
        view_menu_name.setText("메뉴명");
        view_menu_name.setTextColor(Color.WHITE);
        tableRow1.addView(view_menu_name);

        TextView view_Price = new TextView(getActivity());
        view_Price.setGravity(Gravity.CENTER_HORIZONTAL);
        view_Price.setTextSize(20);
        view_Price.setText("가격");
        view_Price.setTextColor(Color.WHITE);
        tableRow1.addView(view_Price);


        tableLayout.addView(tableRow1, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

        int i;
        for(i=0; i<HwanWeekMenu.size(); i++){


            i=5*i;
            if(i >= HwanWeekMenu.size()){
                break;
            }

            ArrayList<String> hwanWeekLastList = new ArrayList<String>();
            hwanWeekLastList.add(HwanWeekMenu.get(i).toString());
            hwanWeekLastList.add(HwanWeekMenu.get(i + 1).toString());
            hwanWeekLastList.add(HwanWeekMenu.get(i + 2).toString());
            hwanWeekLastList.add(HwanWeekMenu.get(i + 3).toString());
            hwanWeekLastList.add(HwanWeekMenu.get(i + 4).toString());
            i = i / 5;

            Log.d("correctHwanWeekList", hwanWeekLastList.toString());
            for(int j =1; j<2; j++){


                madeRow=new TableRow(getActivity());
                madeRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

                TextView hwanWeekDateText = new TextView(getActivity());
                hwanWeekDateText.setId(160+j);
                hwanWeekDateText.setText(hwanWeekLastList.get(0).toString());
                hwanWeekDateText.setGravity(Gravity.CENTER_HORIZONTAL);
                hwanWeekDateText.setTextColor(Color.parseColor("#616161"));
                hwanWeekDateText.setTextSize(17);
                madeRow.addView(hwanWeekDateText);



                TextView hwanWeekTypeText = new TextView(getActivity());
                hwanWeekTypeText.setId(10+j);
                hwanWeekTypeText.setText(hwanWeekLastList.get(2).toString());
                hwanWeekTypeText.setTextColor(Color.parseColor("#616161"));
                hwanWeekTypeText.setGravity(Gravity.CENTER_HORIZONTAL);
                hwanWeekTypeText.setTextSize(17);
                madeRow.addView(hwanWeekTypeText);


                TextView hwanWeekMenuText = new TextView(getActivity());
                hwanWeekMenuText.setId(60+j);
                hwanWeekMenuText.setText(hwanWeekLastList.get(3).toString());
                hwanWeekMenuText.setTextColor(Color.parseColor("#616161"));
                hwanWeekMenuText.setGravity(Gravity.CENTER_HORIZONTAL);
                hwanWeekMenuText.setTextSize(17);
                madeRow.addView(hwanWeekMenuText);


                TextView hwanWeekPriceText = new TextView(getActivity());
                hwanWeekPriceText.setId(110+j);
                hwanWeekPriceText.setText(hwanWeekLastList.get(4).toString());
                hwanWeekPriceText.setTextColor(Color.parseColor("#616161"));
                hwanWeekPriceText.setGravity(Gravity.CENTER_HORIZONTAL);
                hwanWeekPriceText.setTextSize(17);
                madeRow.addView(hwanWeekPriceText);


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
