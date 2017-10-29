package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Usage_Week.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Usage_Week#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Usage_Week extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //private OnFragmentInteractionListener mListener;

    public static Usage_Week newInstance() {

        return new Usage_Week();
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Usage_Week.
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
        View view= inflater.inflate(R.layout.fragment_usage__week, container, false);


        Bundle bundle = this.getArguments();
        bundle.getStringArrayList("useWeekList");
        ArrayList<String> useWeekStu = new ArrayList<String>();
        useWeekStu =bundle.getStringArrayList("useWeekList");

        Log.d("bung",useWeekStu.toString());
/*

        new AsyncTask<Void, Void, Void>() {

            protected void onPostExecute(Void aVoid) {

                super.onPostExecute(aVoid);
                Params params = new Params();
                params.add("stu_id",Student_Login_Page.stu_id);

                new HttpNetwork("stuViewUse_Info.jsp", params.getParams(), new HttpNetwork.AsyncResponse()
                {
                    @Override
                    public void onSuccess(String response) {


                        JSONObject json = null;

                        try {
                            Log.d("useKk","hello");

                            JSONArray useWeekArr = new JSONArray(response);


                            Log.d("kk245",useWeekArr.toString());

                            for (int i = 0; i < useWeekArr.length(); i++) {


                                JSONObject jOb = new JSONObject(useWeekArr.get(i).toString());


                                ArrayList<String> useWeekList = new ArrayList<String>();

                                useWeekList.add(jOb.getString("date"));
                                useWeekList.add(jOb.getString("stu_id"));
                                useWeekList.add(jOb.getString("chain"));
                                useWeekList.add(jOb.getString("mn_price"));
                                useWeekList.add(jOb.getString("mn_name"));


                                useWeekList.add(jOb.getString("f_use"));


                                Log.d("use123",useWeekList.toString());
                            }


                             Log.d("123235555d","bye");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(String response) {

                    }

                    @Override
                    public void onPreExcute() {
                    }
                });
            }
            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }


        }.execute();


*/
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
