package air.foi.hr.trainerassistant.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.base.ViewHolder;
import air.foi.hr.trainerassistant.model.Atleticar;


//atleticarViewholder i naocniViewgolder su dosta slicni pa sam koristio abstraktnu klasu
public class AtleticarViewHolder extends ViewHolder {

    public AtleticarViewHolder(View itemView) {
        //konstruktor
        super(itemView);
    }

    @Override
    protected int getId() {
        return R.id.idClanTextView;
    }

    @Override
    protected int getIme() {
        return R.id.ime_textview;
    }

    @Override
    protected int getPrezime() {
        return R.id.prezime_textview;
    }

    @Override
    protected void getChecked(Atleticar a) {
//buduci da ova klasa ne checkboxa, onda ova metoda ostaje prazna
    }
}