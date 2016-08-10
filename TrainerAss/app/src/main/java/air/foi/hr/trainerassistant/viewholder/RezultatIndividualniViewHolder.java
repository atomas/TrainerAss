package air.foi.hr.trainerassistant.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.model.Disciplina;
import air.foi.hr.trainerassistant.model.Rezultat;

public class RezultatIndividualniViewHolder extends RecyclerView.ViewHolder {

    private TextView clan, podaci, disciplina, prvi, drugi, treci;

    public RezultatIndividualniViewHolder(View itemView) {
        //konstruktor
        super(itemView);

        disciplina = (TextView) itemView.findViewById(R.id.individualni_disciplina_textView);
        prvi = (TextView) itemView.findViewById(R.id.prvi_rezultat_textView);
        drugi = (TextView) itemView.findViewById(R.id.drugi_rezultat_textView);
        treci = (TextView) itemView.findViewById(R.id.treci_rezultat_textView);
    }

    public void bind(Disciplina disciplinae){
        disciplina.setText(disciplinae.getNaziv());

        for(int i = 0; i < disciplinae.getAtleticarList().size(); i++){
            if (i == 0){prvi.setText(disciplinae.getAtleticarList().get(i).getVrijeme() + " sekundi");}
            else if (i == 1){drugi.setText(disciplinae.getAtleticarList().get(i).getVrijeme() + " sekundi");}
            else if (i == 2){treci.setText(disciplinae.getAtleticarList().get(i).getVrijeme() + " sekundi");}
        }
    }
}
