package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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
 * {@link Admin_Insert_Menu_Page.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Admin_Insert_Menu_Page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Admin_Insert_Menu_Page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    EditText InsertMn_id;
    EditText InsertMn_date;
    EditText InsertMn_name;
    EditText InsertMn_price;
    EditText InsertChain;
    EditText InsertMn_type;


    Button InsertMnBtn;



    //private OnFragmentInteractionListener mListener;

    public Admin_Insert_Menu_Page() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Admin_Insert_Menu_Page.
     */
    // TODO: Rename and change types and number of parameters
    public static Admin_Insert_Menu_Page newInstance(String param1, String param2) {
        Admin_Insert_Menu_Page fragment = new Admin_Insert_Menu_Page();
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
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("메뉴 등록");
        View view=  inflater.inflate(R.layout.fragment_admin__insert__menu__page, container, false);

        InsertMn_id = (EditText)view.findViewById(R.id.InsertMn_id);
        InsertMn_date = (EditText)view.findViewById(R.id.InsertMn_date);
        InsertMn_name = (EditText)view.findViewById(R.id.InsertMn_name);
        InsertMn_price = (EditText)view.findViewById(R.id.InsertMn_price);
        InsertChain = (EditText)view.findViewById(R.id.InsertChain);
        InsertMn_type = (EditText)view.findViewById(R.id.InsertMn_type);

        InsertMnBtn = (Button)view.findViewById(R.id.InsertMnBtn);

        InsertMnBtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                Params params = new Params();
                params.add("mn_id",InsertMn_id.getText().toString());
                params.add("mn_date",InsertMn_date.getText().toString());
                params.add("mn_name",InsertMn_name.getText().toString());
                params.add("mn_price",InsertMn_price.getText().toString());
                params.add("chain",InsertChain.getText().toString());
                params.add("mn_type",InsertMn_type.getText().toString());

                if(InsertMn_id.getText().toString().length()==0 || InsertMn_date.getText().toString().length()==0
                        ||InsertMn_name.getText().toString().length()==0 ||InsertMn_price.getText().toString().length()==0
                        ||InsertChain.getText().toString().length()==0 || InsertMn_type.getText().toString().length()==0 )
                {
                    Toast.makeText(getActivity(), "올바르게 입력해주시기 바랍니다.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "메뉴가 등록되었습니다.", Toast.LENGTH_SHORT).show();
                    InsertMn_id.getText().clear();
                    InsertMn_date.getText().clear();
                    InsertMn_name.getText().clear();
                    InsertMn_price.getText().clear();
                    InsertChain.getText().clear();
                    InsertMn_type.getText().clear();




                }





                new HttpNetwork("insertMenu_Info.jsp", params.getParams(), new HttpNetwork.AsyncResponse() {
                    @Override
                    public void onSuccess(String response) {


                        try {
                            //필요없는 부분
                            JSONArray totUseArr = new JSONArray(response);
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
