package imac.supernova;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import imac.supernova.datamodel.Player;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link //PlayerCardFragment.//OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlayerCardFragment#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayerCardFragment extends Fragment {

    private View v;

    private TextView player_name;
    private TextView player_race_title;
    private TextView player_race_description;

    public Player currentPlayer;

    public PlayerCardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_player_card, container, false);

        // Get the current player's infos
        currentPlayer = ((MainActivity) getActivity()).currentPlayer;

        player_name = (TextView) v.findViewById(R.id.player_name);
        player_name.setText("Commandant "+currentPlayer.getName());

        player_race_title = (TextView) v.findViewById(R.id.player_race_title);
        player_race_title.setText(currentPlayer.getRace().toString());

        player_race_description = (TextView) v.findViewById(R.id.player_race_description);
        player_race_description.setText(currentPlayer.getRace().getDescription());

        return v;
    }

}
