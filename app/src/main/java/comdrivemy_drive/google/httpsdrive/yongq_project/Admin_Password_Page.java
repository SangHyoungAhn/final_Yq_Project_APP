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
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Admin_Password_Page.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Admin_Password_Page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Admin_Password_Page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText inputId;
    Button pwBtn;
    TextView findName;
    TextView findPw;
    ArrayList<String> findPwlist = new ArrayList<>();



    public void Init(ArrayList<String>list){
        list.clear();
        return;
    }
    // private OnFragmentInteractionListener mListener;

    public Admin_Password_Page() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Admin_Password_Page.
     */
    // TODO: Rename and change types and number of parameters
    public static Admin_Password_Page newInstance(String param1, String param2) {
        Admin_Password_Page fragment = new Admin_Password_Page();
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
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("비밀번호 찾기");

        View view = inflater.inflate(R.layout.fragment_admin__password__page, container, false);
        inputId = (EditText) view.findViewById(R.id.inputId);
        pwBtn = (Button) view.findViewById(R.id.pwBtn);
        findName = (TextView) view.findViewById(R.id.findNm);
        findPw = (TextView) view.findViewById(R.id.findPw);


        pwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Params params = new Params();
                params.add("stu_id", inputId.getText().toString());





                new HttpNetwork("adpw_Info.jsp", params.getParams(), new HttpNetwork.AsyncResponse() {
                    @Override
                    public void onSuccess(String response) {

                        JSONObject json = null;


                        try {
                            //필요없는 부분
                            JSONArray findPwArr = new JSONArray(response);
                            Init(findPwlist);

                            for (int i = 0; i < findPwArr.length(); i++) {

                                JSONObject findPwOb = new JSONObject(findPwArr.get(i).toString());
                                ArrayList<String> pwList = new ArrayList<String>();


                                pwList.add(findPwOb.getString("stu_pw"));
                                pwList.add(findPwOb.getString("stu_name"));


                                findPwlist.add(pwList.get(0).toString());
                                findPwlist.add(pwList.get(1).toString());

                            }
                            findPw.setText(findPwlist.get(0).toString());
                            findName.setText(findPwlist.get(1).toString());

                            inputId.getText().clear();
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
