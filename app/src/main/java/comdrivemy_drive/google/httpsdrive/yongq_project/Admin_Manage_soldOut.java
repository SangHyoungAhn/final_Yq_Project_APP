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
 * {@link Admin_Manage_soldOut.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Admin_Manage_soldOut#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Admin_Manage_soldOut extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    EditText soldmn;
    EditText soldchain;
    EditText soldout;

    Button soldBtn;

    //private OnFragmentInteractionListener mListener;

    public Admin_Manage_soldOut() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Admin_Manage_soldOut.
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


        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("매진 관리");
        View view= inflater.inflate(R.layout.fragment_admin__manage_sold_out, container, false);


        soldmn= (EditText)view.findViewById(R.id.soldmn);
        soldchain = (EditText)view.findViewById(R.id.soldchain);
        soldout = (EditText)view.findViewById(R.id.soldout);
        soldBtn = (Button)view.findViewById(R.id.soldBtn);


        soldBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Params params = new Params();
                params.add("mn_name",soldmn.getText().toString());
                params.add("chain",soldchain.getText().toString());
                params.add("mn_sold",soldout.getText().toString());

                if(soldmn.getText().toString().length()==0 || soldchain.getText().toString().length()==0
                        ||soldout.getText().toString().length()==0)
                {
                    Toast.makeText(getActivity(), " 정보를 올바르게 입력해주시기 바랍니다.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), " 매진이 등록되었습니다.", Toast.LENGTH_SHORT).show();

                    soldmn.getText().clear();
                    soldchain.getText().clear();
                    soldout.getText().clear();

                }

                new HttpNetwork("adSold_Info.jsp", params.getParams(), new HttpNetwork.AsyncResponse() {
                    @Override
                    public void onSuccess(String response) {

                        JSONObject json = null;


                        try {
                            //필요없는 부분
                            JSONArray findPwArr = new JSONArray(response);



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
