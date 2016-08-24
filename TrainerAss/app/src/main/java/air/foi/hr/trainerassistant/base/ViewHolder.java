package air.foi.hr.trainerassistant.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.model.Atleticar;

public abstract class ViewHolder extends RecyclerView.ViewHolder{

    protected TextView ime, prezime, id;
    protected abstract int getId();
    protected abstract int getIme();
    protected abstract int getPrezime();
    protected abstract void getChecked(Atleticar a);

    public ViewHolder(View itemView) {
        super(itemView);
        id = (TextView) itemView.findViewById(getId());
        ime = (TextView) itemView.findViewById(getIme());
        prezime = (TextView) itemView.findViewById(getPrezime());
    }

    public void bind(Atleticar atleticar){
        String di = String.valueOf(atleticar.getId());
        id.setText(di);
        ime.setText(atleticar.getIme());
        prezime.setText(atleticar.getPrezime());
        getChecked(atleticar);
    }

}
