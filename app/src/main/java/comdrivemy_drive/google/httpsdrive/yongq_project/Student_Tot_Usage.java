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
 * {@link Student_Tot_Usage.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Student_Tot_Usage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Student_Tot_Usage extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    Button totUseBtn;
    EditText totUseText;
    TextView totUse;
    ArrayList<String>totUseList = new ArrayList<String>();
    //private OnFragmentInteractionListener mListener;

    public Student_Tot_Usage() {
        // Required empty public constructor
    }

    public static void Init(ArrayList<String> list){
        list.clear();

        return ;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Student_Tot_Usage.
     */

    // TODO: Rename and change types and number of parameters
    public static Student_Tot_Usage newInstance(String param1, String param2) {
        Student_Tot_Usage fragment = new Student_Tot_Usage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("사용 정산");
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_student__tot__usage, container, false);


        totUseBtn=(Button)view.findViewById(R.id.totUseBtn);
        totUseText = (EditText)view.findViewById(R.id.totUseText);
        totUse = (TextView)view.findViewById(R.id.totUse);


        totUseBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Params params = new Params();
                params.add("stu_id",Student_Login_Page.stu_id);
                params.add("date",totUseText.getText().toString());


                new HttpNetwork("stuTotUse_Info.jsp", params.getParams(), new HttpNetwork.AsyncResponse() {
                    @Override
                    public void onSuccess(String response) {


                        try {
                            //필요없는 부분
                            JSONArray totUseArr = new JSONArray(response);
                            Init(totUseList);

                            for (int i = 0; i < totUseArr.length(); i++) {

                                JSONObject totOb = new JSONObject(totUseArr.get(i).toString());
                                ArrayList<String> totList = new ArrayList<String>();

                                totList.add(totOb.getString("sumTot"));

                                totUseList.add(totList.get(0).toString());

                            }

                            totUse.setText(totUseList.get(0).toString()+"원");

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
