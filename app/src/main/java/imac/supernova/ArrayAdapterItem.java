package imac.supernova;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import imac.supernova.datamodel.Player;
import imac.supernova.datamodel.ship.Ship;

/**
 * Created by Audrey on 26/03/2015.
 */
public class ArrayAdapterItem extends ArrayAdapter<Ship> {

    Context mContext;
    int layoutResourceId;
    Ship[] data = null;

    public ArrayAdapterItem(Context mContext, int layoutResourceId, Ship[] data) {
        super(mContext, layoutResourceId, data);

        this.mContext = mContext;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        // object item based on the position
        Ship ship = data[position];

        // get the TextView and then set the text (item name) and tag (item ID) values
        TextView textViewItem = (TextView) convertView.findViewById(R.id.textViewItem);
        textViewItem.setText(ship.getClass().getSimpleName().toString()+" #"+ship.getId());
        textViewItem.setTag(ship.getId());

        return convertView;
    }

}
