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
 * {@link Week_Menu_Dorm.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Week_Menu_Dorm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Week_Menu_Dorm extends Fragment {
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

    public Week_Menu_Dorm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Week_Menu_Dorm.
     */
    // TODO: Rename and change types and number of parameters
    public static Week_Menu_Dorm newInstance(String param1, String param2) {
        Week_Menu_Dorm fragment = new Week_Menu_Dorm();
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
       View view= inflater.inflate(R.layout.fragment_week__menu__dorm, container, false);

        Bundle bundle = this.getArguments();
        bundle.getStringArrayList("weekmenuDorm");
        ArrayList<String> DormWeekMenu = new ArrayList<String>();
        DormWeekMenu=bundle.getStringArrayList("weekmenuDorm");





        tableLayout= (TableLayout)view.getRootView().findViewById(R.id.dormWeekTable);

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

        for(i=0; i<DormWeekMenu.size(); i++) {

            i = 5 * i;
            if (i >= DormWeekMenu.size()) {
                break;
            }
            ArrayList<String> dormWeekLastList = new ArrayList<String>();
            dormWeekLastList.add(DormWeekMenu.get(i).toString());
            dormWeekLastList.add(DormWeekMenu.get(i + 1).toString());
            dormWeekLastList.add(DormWeekMenu.get(i + 2).toString());
            dormWeekLastList.add(DormWeekMenu.get(i + 3).toString());
            dormWeekLastList.add(DormWeekMenu.get(i + 4).toString());
            i = i / 5;

            Log.d("correctDormWeekList", dormWeekLastList.toString());
            for(int j=1; j<2; j++){

                madeRow=new TableRow(getActivity());
                madeRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));


                TextView dormWeekDateText = new TextView(getActivity());
                dormWeekDateText.setId(160+j);
                dormWeekDateText.setText(dormWeekLastList.get(0).toString());
                dormWeekDateText.setGravity(Gravity.CENTER_HORIZONTAL);
                dormWeekDateText.setTextColor(Color.parseColor("#616161"));
                dormWeekDateText.setTextSize(17);
                madeRow.addView(dormWeekDateText);



                TextView dormWeekTypeText = new TextView(getActivity());
                dormWeekTypeText.setId(10+j);
                dormWeekTypeText.setText(dormWeekLastList.get(2).toString());
                dormWeekTypeText.setTextColor(Color.parseColor("#616161"));
                dormWeekTypeText.setGravity(Gravity.CENTER_HORIZONTAL);
                dormWeekTypeText.setTextSize(17);
                madeRow.addView(dormWeekTypeText);


                TextView dormWeekMenuText = new TextView(getActivity());
                dormWeekMenuText.setId(60+j);
                dormWeekMenuText.setText(dormWeekLastList.get(3).toString());
                dormWeekMenuText.setTextColor(Color.parseColor("#616161"));
                dormWeekMenuText.setGravity(Gravity.CENTER_HORIZONTAL);
                dormWeekMenuText.setTextSize(17);
                madeRow.addView(dormWeekMenuText);


                TextView dormWeekPriceText = new TextView(getActivity());
                dormWeekPriceText.setId(110+j);
                dormWeekPriceText.setText(dormWeekLastList.get(4).toString());
                dormWeekPriceText.setTextColor(Color.parseColor("#616161"));
                dormWeekPriceText.setGravity(Gravity.CENTER_HORIZONTAL);
                dormWeekPriceText.setTextSize(17);
                madeRow.addView(dormWeekPriceText);


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
