package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.model.Disciplina;
import air.foi.hr.trainerassistant.viewholder.RezultatViewHolder;


public class RezultatiAdapter extends RecyclerView.Adapter<RezultatViewHolder> {

    private List<Disciplina> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public RezultatiAdapter(Context context, List<Disciplina> dataList){

        //konstruktor
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = new ArrayList<>(dataList);

    }

    @Override
    public RezultatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //definiras koji ce ti se layout prikazati u redku liste
        View view = inflater.inflate(R.layout.entry_rezultati, parent, false);
        return new RezultatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RezultatViewHolder holder, int position) {
        //hvatas vrijednosti iz list data i popunjavas listu sa metodom bind koja ti se nalazi u rezultatiViewholderu
        Disciplina disciplina = data.get(position);
        holder.bind(disciplina);
    }

    @Override
    public int getItemCount() {
        //vraca velicinu liste
        return data.size();
    }
}
