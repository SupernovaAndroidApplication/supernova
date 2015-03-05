package imac.supernova;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link //FleetDashboardFragment.//OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FleetDashboardFragment#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class FleetDashboardFragment extends Fragment implements View.OnClickListener {

    private View v;

    private TextView ship_name;

    private TextView energy_units;
    private TextView power_units;
    private TextView move_units;

    private RelativeLayout.LayoutParams params_energy;
    private RelativeLayout.LayoutParams params_power;
    private RelativeLayout.LayoutParams params_move;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;

    //private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param //param1 Parameter 1.
     * @param //param2 Parameter 2.
     * @return A new instance of fragment FleetDashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    /*public static FleetDashboardFragment newInstance(String param1, String param2) {
        FleetDashboardFragment fragment = new FleetDashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    public FleetDashboardFragment() {
        // Required empty public constructor
    }

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fleet_dashboard, container, false);
        // Get textview to insert data
        ship_name = (TextView) v.findViewById(R.id.ship_name);
        energy_units = (TextView) v.findViewById(R.id.energy_units);
        power_units = (TextView) v.findViewById(R.id.power_units);
        move_units = (TextView) v.findViewById(R.id.move_units);

        // Button #1
        Button button_cruiser = (Button) v.findViewById(R.id.button_cruiser);
        button_cruiser.setOnClickListener(this);

        // Button #2
        Button button_bomber_1 = (Button) v.findViewById(R.id.button_bomber_1);
        button_bomber_1.setOnClickListener(this);
        // Button #3
        Button button_bomber_2 = (Button) v.findViewById(R.id.button_bomber_2);
        button_bomber_2.setOnClickListener(this);

        // Button #4
        Button button_fighter_1 = (Button) v.findViewById(R.id.button_fighter_1);
        button_fighter_1.setOnClickListener(this);
        // Button #5
        Button button_fighter_2 = (Button) v.findViewById(R.id.button_fighter_2);
        button_fighter_2.setOnClickListener(this);
        // Button #6
        Button button_fighter_3 = (Button) v.findViewById(R.id.button_fighter_3);
        button_fighter_3.setOnClickListener(this);

        return v;
        /*Button button = (Button) findViewById(R.id.button_test);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
            }
        });
        return inflater.inflate(R.layout.fragment_fleet_dashboard, container, false);*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_cruiser:
                ship_name.setText("Cruiser");
                params_energy = new RelativeLayout.LayoutParams(80, RelativeLayout.LayoutParams.MATCH_PARENT);
                energy_units.setLayoutParams(params_energy);
                params_power = new RelativeLayout.LayoutParams(80, RelativeLayout.LayoutParams.MATCH_PARENT);
                power_units.setLayoutParams(params_power);
                params_move = new RelativeLayout.LayoutParams(80, RelativeLayout.LayoutParams.MATCH_PARENT);
                move_units.setLayoutParams(params_move);
                break;
            case R.id.button_bomber_1:
                ship_name.setText("Bomber #1");
                params_energy = new RelativeLayout.LayoutParams(100, RelativeLayout.LayoutParams.MATCH_PARENT);
                energy_units.setLayoutParams(params_energy);
                params_power = new RelativeLayout.LayoutParams(200, RelativeLayout.LayoutParams.MATCH_PARENT);
                power_units.setLayoutParams(params_power);
                params_move = new RelativeLayout.LayoutParams(80, RelativeLayout.LayoutParams.MATCH_PARENT);
                move_units.setLayoutParams(params_move);
                break;
            case R.id.button_bomber_2:
                ship_name.setText("Bomber #2");
                params_energy = new RelativeLayout.LayoutParams(50, RelativeLayout.LayoutParams.MATCH_PARENT);
                energy_units.setLayoutParams(params_energy);
                params_power = new RelativeLayout.LayoutParams(200, RelativeLayout.LayoutParams.MATCH_PARENT);
                power_units.setLayoutParams(params_power);
                params_move = new RelativeLayout.LayoutParams(150, RelativeLayout.LayoutParams.MATCH_PARENT);
                move_units.setLayoutParams(params_move);
                break;
            case R.id.button_fighter_1:
                ship_name.setText("Fighter #1");
                params_energy = new RelativeLayout.LayoutParams(50, RelativeLayout.LayoutParams.MATCH_PARENT);
                energy_units.setLayoutParams(params_energy);
                params_power = new RelativeLayout.LayoutParams(20, RelativeLayout.LayoutParams.MATCH_PARENT);
                power_units.setLayoutParams(params_power);
                params_move = new RelativeLayout.LayoutParams(80, RelativeLayout.LayoutParams.MATCH_PARENT);
                move_units.setLayoutParams(params_move);
                break;
            case R.id.button_fighter_2:
                ship_name.setText("Fighter #2");
                params_energy = new RelativeLayout.LayoutParams(20, RelativeLayout.LayoutParams.MATCH_PARENT);
                energy_units.setLayoutParams(params_energy);
                params_power = new RelativeLayout.LayoutParams(100, RelativeLayout.LayoutParams.MATCH_PARENT);
                power_units.setLayoutParams(params_power);
                params_move = new RelativeLayout.LayoutParams(200, RelativeLayout.LayoutParams.MATCH_PARENT);
                move_units.setLayoutParams(params_move);
                break;
            case R.id.button_fighter_3:
                ship_name.setText("Fighter #3");
                params_energy = new RelativeLayout.LayoutParams(90, RelativeLayout.LayoutParams.MATCH_PARENT);
                energy_units.setLayoutParams(params_energy);
                params_power = new RelativeLayout.LayoutParams(50, RelativeLayout.LayoutParams.MATCH_PARENT);
                power_units.setLayoutParams(params_power);
                params_move = new RelativeLayout.LayoutParams(80, RelativeLayout.LayoutParams.MATCH_PARENT);
                move_units.setLayoutParams(params_move);
                break;
            default:
                break;
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    /*@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    /*@Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }*/

}
