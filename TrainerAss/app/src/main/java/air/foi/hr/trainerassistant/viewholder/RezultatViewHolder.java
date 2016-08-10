package air.foi.hr.trainerassistant.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.model.Disciplina;
import air.foi.hr.trainerassistant.model.Rezultat;


public class RezultatViewHolder extends RecyclerView.ViewHolder {

    private TextView disciplina, prvi, drugi, treci;

    public RezultatViewHolder(View itemView) {
        //konstruktor
        super(itemView);
        disciplina = (TextView) itemView.findViewById(R.id.disciplina_textView);
        prvi = (TextView) itemView.findViewById(R.id.prvi_kandidat_textView);
        drugi = (TextView) itemView.findViewById(R.id.drugi_kandidat_textView);
        treci = (TextView) itemView.findViewById(R.id.treci_kandidat_textView);
    }

    public void bind(Disciplina disciplinae){
        //buduci da je na mokapima prikazano samo tri atleticara iz svake discipline
        //sprema se disciplina i najbolja tri iz svake discipline
        disciplina.setText(disciplinae.getNaziv());
        
        for(int i = 0; i < disciplinae.getAtleticarList().size(); i++){
            if (i == 0){prvi.setText(disciplinae.getAtleticarList().get(i).getPrezime() + " " + disciplinae.getAtleticarList().get(i).getIme() + ": " + disciplinae.getAtleticarList().get(i).getVrijeme() + " sec");}
            else if (i == 1){drugi.setText(disciplinae.getAtleticarList().get(i).getPrezime() + " " + disciplinae.getAtleticarList().get(i).getIme() + ": " + disciplinae.getAtleticarList().get(i).getVrijeme() + " sec");}
            else if (i == 2){treci.setText(disciplinae.getAtleticarList().get(i).getPrezime() + " " + disciplinae.getAtleticarList().get(i).getIme() + ": " + disciplinae.getAtleticarList().get(i).getVrijeme() + " sec");}
        }
    }

}
