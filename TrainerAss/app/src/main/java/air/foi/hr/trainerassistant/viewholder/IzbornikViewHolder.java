package air.foi.hr.trainerassistant.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.api.Click;


public class IzbornikViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView id, izbornik;
    private Click listener;

    public IzbornikViewHolder(View itemView, Click listeners) {
        //konstruktor
        super(itemView);
        itemView.setOnClickListener(this);
        id = (TextView) itemView.findViewById(R.id.id_izbornik_textView);
        izbornik = (TextView) itemView.findViewById(R.id.izbornik_textView);
        this.listener = listeners;
    }

    public void bind(int ide, String izbornike){
        //postavljanje vrijednosti u textviewove
        id.setText(String.valueOf(ide));
        izbornik.setText(izbornike);
    }

    @Override
    public void onClick(View v) {

        listener.clickListener(Integer.parseInt(id.getText().toString()));

    }
}
