package air.foi.hr.trainerassistant.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.base.ViewHolder;
import air.foi.hr.trainerassistant.model.Atleticar;


public class NazocniViewHolder extends ViewHolder {

    private CheckBox checkBox;

    public NazocniViewHolder(View itemView) {
        //konstruktor
        super(itemView);
        checkBox = (CheckBox) itemView.findViewById(R.id.pristunost_kanddiat_entry_checkbox);
    }

    @Override
    protected int getIme() {
        return R.id.ime_kandidat_entry_textView;
    }

    @Override
    protected int getPrezime() {
        return R.id.prezime_kandidat_entry_textView;
    }

    @Override
    protected void getChecked(final Atleticar a) {
        //spremi vrijednost checkboxova kada neko klikne na nejga
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Log.d("Ovaj kliknut", a.getIme());
                    a.setNazocan(true);
                } else {
                    a.setNazocan(false);
                }
            }
        });
    }
}
