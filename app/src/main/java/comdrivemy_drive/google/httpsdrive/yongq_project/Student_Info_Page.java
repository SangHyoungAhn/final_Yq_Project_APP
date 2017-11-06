package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Student_Info_Page.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Student_Info_Page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Student_Info_Page extends Fragment {


    TextView info_Stu_id;
    TextView info_Stu_name;
    TextView info_Stu_change;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //private OnFragmentInteractionListener mListener;

    public Student_Info_Page() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Student_Info_Page newInstance(String param1, String param2) {
        Student_Info_Page fragment = new Student_Info_Page();
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

    public void onBackPressed() {


    }


    /*
     FragmentManager fM = getActivity().getSupportFragmentManager();
            fM.beginTransaction();
            fM.addOnBackStackChangedListener(on);
            fM.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("학생 정보");
        View view = inflater.inflate(R.layout.fragment_student__info__page, container, false);


        info_Stu_id = (TextView) view.findViewById(R.id.info_stu_id);
        info_Stu_id.setText(getActivity().getIntent().getExtras().getString("stu_id"));


        // Log.d("1234ddd",Student_Login_Page.stu_name);

        info_Stu_name = (TextView) view.findViewById(R.id.info_stu_name);
        info_Stu_name.setText(getActivity().getIntent().getExtras().getString("stu_name"));


        info_Stu_change = (TextView) view.findViewById(R.id.info_stu_change);
        info_Stu_change.setText(getActivity().getIntent().getExtras().getString("stu_change")+"원");


        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null).commit();


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
