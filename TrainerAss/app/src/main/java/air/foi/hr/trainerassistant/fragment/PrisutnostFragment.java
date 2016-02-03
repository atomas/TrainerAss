package air.foi.hr.trainerassistant.fragment;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import air.foi.hr.trainerassistant.HttpManager;
import air.foi.hr.trainerassistant.Izbornik;
import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.RequestPackage;
import air.foi.hr.trainerassistant.adapter.KandidatiAdapter;
import air.foi.hr.trainerassistant.adapter.NazocniAdapter;
import air.foi.hr.trainerassistant.api.NavigationItem;
import air.foi.hr.trainerassistant.base.BaseFragment;
import air.foi.hr.trainerassistant.model.Atleticar;


public class PrisutnostFragment extends BaseFragment implements View.OnClickListener, NavigationItem{

    Button dalje;
    private RecyclerView recyclerView;
    private NazocniAdapter adapter;
    private int position;

    @Override
    protected int getLayout() {
        return R.layout.activity_prisutnost;
    }

    @Override
    protected void init() {

        //inicijalizacija
        dalje = (Button) view.findViewById(R.id.dalje_prisutnost_button);
        dalje.setOnClickListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.prisutnost_recyclerView);
        adapter = new NazocniAdapter(getActivity(), ((Izbornik) getActivity()).getAtleticarList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        //pritiskom na tipku, pregleda se koji su checkboxovi kliknuti
        //svi kandidati koji su kliknuti se dodavaju u listu NazocniList koja se nalazi u activity izbornik
        for (Atleticar a : ((Izbornik) getActivity()).getAtleticarList()){
            if (a.isNazocan()){
                ((Izbornik) getActivity()).getNazocniList().add(a);
            }
        }
        swapFragment(new DisciplineFragment());
    }

    @Override
    public String getItemName() {
        return "Novi trening";
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public Fragment getFragment() {
        return this;
    }
}
