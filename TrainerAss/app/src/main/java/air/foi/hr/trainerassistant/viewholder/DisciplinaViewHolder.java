package air.foi.hr.trainerassistant.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.api.Click;
import air.foi.hr.trainerassistant.model.Disciplina;


public class DisciplinaViewHolder extends RecyclerView.ViewHolder{

    private TextView id, disciplina;
    private CheckBox checkBox;

    public DisciplinaViewHolder(View itemView) {
        //konstruktor
        super(itemView);
        id = (TextView) itemView.findViewById(R.id.id_disciplina_entry_textView);
        disciplina = (TextView) itemView.findViewById(R.id.disciplina_entry_textView);
        checkBox = (CheckBox) itemView.findViewById(R.id.checkBoxDisciplina);
    }

    public void bind(final Disciplina disciplinae){
        //popstavljanje vrijednosti u textview
        //ukoliko je neki checkbox promjeio stanje, pohrani njegoov stanje
        id.setText(String.valueOf(disciplinae.getId()));
        disciplina.setText(disciplinae.getNaziv());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    disciplinae.setNazocan(true);
                } else {
                    disciplinae.setNazocan(false);
                }
            }
        });
    }

}
