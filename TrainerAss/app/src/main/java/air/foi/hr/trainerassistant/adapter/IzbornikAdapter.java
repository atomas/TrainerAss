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
import air.foi.hr.trainerassistant.api.Click;
import air.foi.hr.trainerassistant.viewholder.IzbornikViewHolder;


public class IzbornikAdapter extends RecyclerView.Adapter<IzbornikViewHolder> {

    private List<String> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    private Click listener;

    public IzbornikAdapter(Context context, ArrayList<String> dataList){

        //konstruktor
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = new ArrayList<>(dataList);

    }

    public void setOnItemClickListener(Click listener){
        this.listener = listener;
    }

    @Override
    public IzbornikViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //definiras koji ce ti se layout prikazati u redku liste
        View view = inflater.inflate(R.layout.entry_izbornik, parent, false);
        return new IzbornikViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(IzbornikViewHolder holder, int position) {
        //hvatas vrijednosti iz list data i popunjavas listu sa metodom bind koja ti se nalazi u izbornikviewholderu
        String match = data.get(position);
        holder.bind(position, match);
    }

    @Override
    public int getItemCount() {
        //vracas velicinu liste
        return data.size();
    }
}
