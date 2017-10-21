package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Admin_Usage_Page.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Admin_Usage_Page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Admin_Usage_Page extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private Button adminUseWeekBtn;
    private Button adminUseMonthBtn;
    private Button adminUseThMonthBtn;

   // private OnFragmentInteractionListener mListener;

    public static Admin_Usage_Page newInstance() {
        // Required empty public constructor

        return new Admin_Usage_Page();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Admin_Usage_Page.
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

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("사용 내역");

        View view=  inflater.inflate(R.layout.fragment_admin__usage__page, container, false);


        adminUseWeekBtn = (Button)view.findViewById(R.id.admin_UseWeekBtn);
        adminUseWeekBtn.setOnClickListener(this);


        adminUseMonthBtn = (Button)view.findViewById(R.id.admin_UseMonthBtn);
        adminUseMonthBtn.setOnClickListener(this);


        adminUseThMonthBtn = (Button)view.findViewById(R.id.admin_UseThMonthBtn);
        adminUseThMonthBtn.setOnClickListener(this);


        return view;

    }


    public void onClick(View view){

        Fragment fragment;
        switch(view.getId()){

            case R.id.admin_UseWeekBtn:
                fragment= Admin_Usage_Week.newInstance();
                setChildFragment(fragment);
                break;

            case R.id.admin_UseMonthBtn:
                fragment = Admin_Usage_Month.newInstance();
                setChildFragment(fragment);
                break;

            case R.id.admin_UseThMonthBtn:
                fragment = Admin_Usage_ThMonth.newInstance();
                setChildFragment(fragment);
                break;
        }

    }


    private void setChildFragment(Fragment child)
    {
        FragmentTransaction fT = getChildFragmentManager().beginTransaction();

        if(!child.isAdded()){
            fT.replace(R.id.admin_Usage_contents,child);
            fT.addToBackStack(null);
            fT.commit();
        }


    }

    /*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    /*
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
