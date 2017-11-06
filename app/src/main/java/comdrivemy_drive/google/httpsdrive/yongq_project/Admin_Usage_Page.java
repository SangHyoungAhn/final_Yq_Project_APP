package comdrivemy_drive.google.httpsdrive.yongq_project;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Admin_Usage_Page.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Admin_Usage_Page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Admin_Usage_Page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button adfindUseBtn;
    EditText adfindid;

    TableLayout tableLayout;

    TableRow tableRow1;
    TableRow madeRow;
    ArrayList<String> findUseLastList = new ArrayList<String>();

    public void Init(ArrayList<String> list) {
        list.clear();
        return;
    }


    private void cleanTable(TableLayout table) {

        int childCount = table.getChildCount();

        // Remove all rows except the first one
        if (childCount > 1) {
            table.removeViews(2, childCount - 1);
        }
    }

    // private OnFragmentInteractionListener mListener;

    public static Admin_Usage_Page newInstance(String param1, String param2) {
        // Required empty public constructor


        Bundle args = new Bundle();
        Admin_Usage_Page fragment = new Admin_Usage_Page();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    /*
        FragmentTransaction tr = getFragmentManager().beginTransaction();
        tr.replace(R.id.your_fragment_container, yourFragmentInstance);
        tr.commit(

     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("사용 내역");
        final View view = inflater.inflate(R.layout.fragment_admin__usage__page, container, false);

        tableLayout = (TableLayout) view.findViewById(R.id.awardTable);

        final TableRow remove_row = (TableRow)view.findViewById(R.id.usageRow);
        adfindUseBtn = (Button) view.findViewById(R.id.adfindUseBtn);
        adfindid = (EditText) view.findViewById(R.id.adfindid);


        adfindUseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableLayout.removeView(remove_row);

                Params params = new Params();
                params.add("stu_id", adfindid.getText().toString());


                if (madeRow != null) {
                    tableLayout.removeAllViews();
                }

                tableRow1 = new TableRow(getActivity());
                tableRow1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
                tableRow1.setBackgroundColor(Color.parseColor("#0091EA"));


                TextView view_menu_sort = new TextView(getActivity());
                view_menu_sort.setGravity(Gravity.CENTER_HORIZONTAL);
                view_menu_sort.setTextSize(20);
                view_menu_sort.setText("일자");
                view_menu_sort.setTextColor(Color.WHITE);

                tableRow1.addView(view_menu_sort);


                TextView view_menu_place = new TextView(getActivity());
                view_menu_place.setGravity(Gravity.CENTER_HORIZONTAL);
                view_menu_place.setTextSize(20);
                view_menu_place.setText("장소");
                view_menu_place.setTextColor(Color.WHITE);
                tableRow1.addView(view_menu_place);

                TextView view_menu_name = new TextView(getActivity());
                view_menu_name.setGravity(Gravity.CENTER_HORIZONTAL);
                view_menu_name.setTextSize(20);
                view_menu_name.setText("메뉴명");
                view_menu_name.setTextColor(Color.WHITE);
                tableRow1.addView(view_menu_name);


                TextView view_menu_money = new TextView(getActivity());
                view_menu_money.setGravity(Gravity.CENTER_HORIZONTAL);
                view_menu_money.setTextSize(20);
                view_menu_money.setText("사용 금액");
                view_menu_money.setTextColor(Color.WHITE);
                tableRow1.addView(view_menu_money);

                tableLayout.addView(tableRow1);


                new HttpNetwork("adfindUse_Info.jsp", params.getParams(), new HttpNetwork.AsyncResponse() {
                    @Override
                    public void onSuccess(String response) {

                        JSONObject json = null;


                        try {

                            //필요없는 부분
                            JSONArray findUseArr = new JSONArray(response);
                            Init(findUseLastList);

                            for (int i = 0; i < findUseArr.length(); i++) {

                                JSONObject findPwOb = new JSONObject(findUseArr.get(i).toString());
                                ArrayList<String> findList = new ArrayList<String>();


                                findList.add(findPwOb.getString("date"));
                                findList.add(findPwOb.getString("chain"));
                                findList.add(findPwOb.getString("mn_name"));
                                findList.add(findPwOb.getString("mn_price"));
                                findList.add(findPwOb.getString("f_use"));


                                findUseLastList.add(findList.get(0).toString());
                                findUseLastList.add(findList.get(1).toString());
                                findUseLastList.add(findList.get(2).toString());
                                findUseLastList.add(findList.get(3).toString());
                                findUseLastList.add(findList.get(4).toString());

                            }
                            Log.d("zxcxcvxv", findUseLastList.toString());


                            //when create table automatically , tableRow1 is fixed row.


                            int i;
                            for (i = 0; i < findUseLastList.size(); i++) {


                                i = 5 * i;
                                if (i >= findUseLastList.size()) {
                                    break;
                                }
                                ArrayList<String> findLastList = new ArrayList<String>();
                                findLastList.add(findUseLastList.get(i).toString());
                                findLastList.add(findUseLastList.get(i + 1).toString());
                                findLastList.add(findUseLastList.get(i + 2).toString());
                                findLastList.add(findUseLastList.get(i + 3).toString());
                                findLastList.add(findUseLastList.get(i + 4).toString());
                                i = i / 5;

                                Log.d("asavav", findUseLastList.toString());
                                for (int j = 1; j < 2; j++) {


                                    madeRow = new TableRow(getActivity());
                                    madeRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));


                                    TextView findDateText = new TextView(getActivity());
                                    findDateText.setId(j + 0);
                                    findDateText.setText(findLastList.get(0).toString());
                                    findDateText.setGravity(Gravity.CENTER_HORIZONTAL);
                                    findDateText.setTextColor(Color.parseColor("#616161"));
                                    findDateText.setTextSize(17);
                                    madeRow.addView(findDateText);


                                    TextView findChainText = new TextView(getActivity());
                                    findChainText.setId(j + 1);
                                    findChainText.setText(findLastList.get(1).toString());
                                    findChainText.setTextColor(Color.parseColor("#616161"));
                                    findChainText.setGravity(Gravity.CENTER_HORIZONTAL);
                                    findChainText.setTextSize(17);
                                    madeRow.addView(findChainText);


                                    TextView findMenuText = new TextView(getActivity());
                                    findMenuText.setId(j + 2);
                                    findMenuText.setText(findLastList.get(2).toString());
                                    findMenuText.setTextColor(Color.parseColor("#616161"));
                                    findMenuText.setGravity(Gravity.CENTER_HORIZONTAL);
                                    findMenuText.setTextSize(17);
                                    madeRow.addView(findMenuText);


                                    TextView findPriceText = new TextView(getActivity());
                                    findPriceText.setId(j + 3);
                                    findPriceText.setText(findLastList.get(3).toString());
                                    findPriceText.setTextColor(Color.parseColor("#616161"));
                                    findPriceText.setGravity(Gravity.CENTER_HORIZONTAL);
                                    findPriceText.setTextSize(17);
                                    madeRow.addView(findPriceText);


                                    tableLayout.addView(madeRow, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));


                                }


                            }


                            adfindid.getText().clear();


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



    /*


        알림
     */
      /*
                if (madeRow != null) {

                    AlertDialog.Builder  aB= new AlertDialog.Builder(getActivity());
                    aB.setTitle("알림");
                    aB.setMessage("테이블을 초기화하시겠습니까?");
                    aB.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.detach(Admin_Usage_Page.this).attach(Admin_Usage_Page.this).commit();
                        }

                    });
                    aB.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            return;
                        }
                    })
                    .show();

                }
                */
