package ubiquitouscomputing.pat2math_app.controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import ubiquitouscomputing.pat2math_app.R;
import ubiquitouscomputing.pat2math_app.model.Score;

/**
 * Created by Rafael Galuschka on 6/11/2017.
 */

public class AdapterResultado  extends ArrayAdapter<Score> {

    private int layoutResourceId;

    private static final String LOG_TAG = "ResultadoAdapter";

    public AdapterResultado(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        layoutResourceId = textViewResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            Score item = getItem(position);
            View v = null;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                v = inflater.inflate(layoutResourceId, null);

            } else {
                v = convertView;
            }


            TextView posicao = (TextView) v.findViewById(R.id.txPosicao);
            TextView nome = (TextView) v.findViewById(R.id.txNome);
            TextView score = (TextView) v.findViewById(R.id.txScore);

            posicao.setText(position + "");
            nome.setText(item.getPlayer());
            score.setText(item.getPoints() + "");

            return v;
        } catch (Exception ex) {
            Log.e(LOG_TAG, "error", ex);
            return null;
        }
    }
}
