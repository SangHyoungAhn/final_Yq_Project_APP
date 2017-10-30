package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Student_Recharge_Page.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Student_Recharge_Page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Student_Recharge_Page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button stu_recharge_Button;
    Button stu_recharge_gift;
   // private OnFragmentInteractionListener mListener;

    public Student_Recharge_Page() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Student_Recharge_Page.
     */
    // TODO: Rename and change types and number of parameters
    public static Student_Recharge_Page newInstance(String param1, String param2) {
        Student_Recharge_Page fragment = new Student_Recharge_Page();
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

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("충 전");
        View view =inflater.inflate(R.layout.fragment_student__recharge__page, container, false);


        final EditText recharge_Price = (EditText)view.findViewById(R.id.recharge_price);


        stu_recharge_Button = (Button)view.findViewById(R.id.stu_recharge_Button);
        stu_recharge_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new AlertDialog.Builder(getActivity())
                        .setTitle("충전")
                        .setMessage("충전하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {


                                Params mparams = new Params();
                                mparams.add("stu_id", Student_Login_Page.stu_id);
                                mparams.add("mn_price",recharge_Price.getText().toString());

                                new HttpNetwork("stuRecharge_Info.jsp",mparams.getParams(), new HttpNetwork.AsyncResponse()
                                {
                                    @Override
                                    public void onSuccess (String response){

                                        try {
                                            //필요없는 부분
                                            JSONArray useMthArr = new JSONArray(response);

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

                                Toast.makeText(getActivity(), "충전하였습니다.", Toast.LENGTH_SHORT).show();

                            }})
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // 취소시 처리 로직
                                Toast.makeText(getActivity(), "취소하였습니다.", Toast.LENGTH_SHORT).show();
                            }})
                        .show();

            }
        });



        stu_recharge_gift= (Button)view.findViewById(R.id.stu_recharge_gift);
        stu_recharge_gift.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {


                new AlertDialog.Builder(getActivity())
                        .setTitle("선물")
                        .setMessage("QR로 진행하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // 확인시 처리 로직

                                Intent intent = new Intent(getActivity(), YQ_Gift_Barcode.class);
                                getActivity().startActivity(intent);

                            }})
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // 취소시 처리 로직
                                Toast.makeText(getActivity(), "취소하였습니다.", Toast.LENGTH_SHORT).show();
                            }})
                        .show();



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
