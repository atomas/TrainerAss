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
import air.foi.hr.trainerassistant.model.Atleticar;
import air.foi.hr.trainerassistant.viewholder.NazocniViewHolder;


public class NazocniAdapter extends RecyclerView.Adapter<NazocniViewHolder> {

    private List<Atleticar> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NazocniAdapter(Context context, List<Atleticar> dataList){

        //konstruktor
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = new ArrayList<>(dataList);

    }

    @Override
    public NazocniViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //definiras koji ce ti se layout prikazati u redku liste
        View view = inflater.inflate(R.layout.entry_prisutnost, parent, false);
        return new NazocniViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NazocniViewHolder holder, int position) {
        //hvatas vrijednosti iz list data i popunjavas listu sa metodom bind koja ti se nalazi u nazocniviewholder
        Atleticar atleticar = data.get(position);
        holder.bind(atleticar);
    }

    @Override
    public int getItemCount() {
        //vracas velicinu liste
        return data.size();
    }
}
