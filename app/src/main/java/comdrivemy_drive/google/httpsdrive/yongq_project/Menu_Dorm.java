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
 * {@link Menu_Dorm.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Menu_Dorm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu_Dorm extends Fragment {
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
   // private OnFragmentInteractionListener mListener;

    public Menu_Dorm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Menu_Dorm.
     */
    // TODO: Rename and change types and number of parameters
    public static Menu_Dorm newInstance(String param1, String param2) {
        Menu_Dorm fragment = new Menu_Dorm();
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
        View view = inflater.inflate(R.layout.fragment_menu__dorm,container,false);

        Bundle bundle = this.getArguments();
        bundle.getStringArrayList("DormMenu");
        ArrayList<String> Dorm = new ArrayList<String>();
        Dorm=bundle.getStringArrayList("DormMenu");

        Log.d("dorm123",Dorm.toString());

        tableLayout=(TableLayout)view.getRootView().findViewById(R.id.dormTable);

        //when create table automatically , tableRow1 is fixed row.
        tableRow1 = new TableRow(getActivity());
        tableRow1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tableRow1.setBackgroundColor(Color.parseColor("#0091EA"));


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

        TextView view_soldOut = new TextView(getActivity());
        view_soldOut.setGravity(Gravity.CENTER_HORIZONTAL);
        view_soldOut.setTextSize(20);
        view_soldOut.setText("매진");
        view_soldOut.setTextColor(Color.WHITE);
        tableRow1.addView(view_soldOut);


        tableLayout.addView(tableRow1, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

        int i;
        for(i=0; i<Dorm.size(); i++){

            i= 6*i;
            if(i>=Dorm.size()){
                break;
            }
            ArrayList<String>dormLastList = new ArrayList<String>();
            dormLastList.add(Dorm.get(i).toString());
            dormLastList.add(Dorm.get(i+1).toString());
            dormLastList.add(Dorm.get(i+2).toString());
            dormLastList.add(Dorm.get(i+3).toString());
            dormLastList.add(Dorm.get(i+4).toString());
            dormLastList.add(Dorm.get(i+5).toString());

            i=i/6;
            Log.d("correctDormList",dormLastList.toString());
            for(int j=1; j<2; j++){


                madeRow = new TableRow(getActivity());
                madeRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

                TextView dormTypeText = new TextView(getActivity());
                dormTypeText.setId(10+j);
                dormTypeText.setText(dormLastList.get(2).toString());
                dormTypeText.setTextColor(Color.parseColor("#616161"));
                dormTypeText.setGravity(Gravity.CENTER_HORIZONTAL);
                dormTypeText.setTextSize(17);
                madeRow.addView(dormTypeText);

                TextView dormMenuText = new TextView(getActivity());
                dormMenuText.setId(50+j);
                dormMenuText.setText(dormLastList.get(3).toString());
                dormMenuText.setTextColor(Color.parseColor("#616161"));
                dormMenuText.setGravity(Gravity.CENTER_HORIZONTAL);
                dormMenuText.setTextSize(17);
                madeRow.addView(dormMenuText);


                TextView dormPriceText = new TextView(getActivity());
                dormPriceText.setId(90+j);
                dormPriceText.setText(dormLastList.get(4).toString());
                dormPriceText.setTextColor(Color.parseColor("#616161"));
                dormPriceText.setGravity(Gravity.CENTER_HORIZONTAL);
                dormPriceText.setTextSize(17);
                madeRow.addView(dormPriceText);


                TextView dormSoldText = new TextView(getActivity());
                dormSoldText.setId(130+j);
                dormSoldText.setText(dormLastList.get(5).toString());
                dormSoldText.setTextColor(Color.parseColor("#616161"));
                dormSoldText.setGravity(Gravity.CENTER_HORIZONTAL);
                dormSoldText.setTextSize(17);
                madeRow.addView(dormSoldText);

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
