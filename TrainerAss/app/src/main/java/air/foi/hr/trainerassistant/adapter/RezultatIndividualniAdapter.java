package air.foi.hr.trainerassistant.adapter;

import android.support.v7.widget.RecyclerView;

import air.foi.hr.trainerassistant.viewholder.RezultatIndividualniViewHolder;
import air.foi.hr.trainerassistant.viewholder.RezultatViewHolder;

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

public class RezultatIndividualniAdapter extends RecyclerView.Adapter<RezultatIndividualniViewHolder> {
    private List<Disciplina> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public RezultatIndividualniAdapter(Context context, List<Disciplina> dataList){
        //konstruktor
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = new ArrayList<>(dataList);
    }

    @Override
    public RezultatIndividualniViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //definiras koji ce ti se layout prikazati u redku liste
        View view = inflater.inflate(R.layout.entry_individualni_rezultati, parent, false);
        return new RezultatIndividualniViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RezultatIndividualniViewHolder holder, int position) {
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