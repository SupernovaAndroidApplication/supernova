package imac.supernova;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import imac.supernova.datamodel.Player;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link //AlienTechnologiesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link //AlienTechnologiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlienTechnologiesFragment extends Fragment {

    private View v;

    public Player currentPlayer;

    public AlienTechnologiesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_alien_technologies, container, false);

        // Get the current player's techno
        currentPlayer = ((MainActivity) getActivity()).currentPlayer;

        return v;
    }

}
