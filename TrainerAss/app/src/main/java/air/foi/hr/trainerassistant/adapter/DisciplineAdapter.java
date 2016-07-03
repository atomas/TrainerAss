package air.foi.hr.trainerassistant.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.api.Click;
import air.foi.hr.trainerassistant.model.Disciplina;
import air.foi.hr.trainerassistant.viewholder.DisciplinaViewHolder;

public class DisciplineAdapter extends RecyclerView.Adapter<DisciplinaViewHolder> {

    private List<Disciplina> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public DisciplineAdapter(Context context, List<Disciplina> dataList){

        //konstruktor
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = new ArrayList<>(dataList);

    }

    @Override
    public DisciplinaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //definiras koji ce ti se layout prikazati u redku liste
        View view = inflater.inflate(R.layout.entry_disciplina, parent, false);
        return new DisciplinaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DisciplinaViewHolder holder, int position) {
        //hvatas vrijednosti iz list data i popunjavas listu sa metodom bind koja ti se nalazi u disciplinaviewholderu
        Disciplina disciplina = data.get(position);
        holder.bind(disciplina);
    }

    @Override
    public int getItemCount() {
        //velicina liste
        return data.size();
    }
}
