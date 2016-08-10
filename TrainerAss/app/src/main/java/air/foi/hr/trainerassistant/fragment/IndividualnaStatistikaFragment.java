package air.foi.hr.trainerassistant.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import air.foi.hr.trainerassistant.HttpManager;
import air.foi.hr.trainerassistant.Izbornik;
import air.foi.hr.trainerassistant.JSONParser;
import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.RequestPackage;
import air.foi.hr.trainerassistant.adapter.RezultatiAdapter;
import air.foi.hr.trainerassistant.api.NavigationItem;
import air.foi.hr.trainerassistant.base.BaseFragment;
import air.foi.hr.trainerassistant.model.Atleticar;
import air.foi.hr.trainerassistant.model.Disciplina;

public class IndividualnaStatistikaFragment extends BaseFragment implements NavigationItem {

    private int position;

    public IndividualnaStatistikaFragment(){
        //konstruktor
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_individualni;
    }

    @Override
    protected void init() {
        Log.d("Inicijalizacija", "Inicijalizacija");
        //inicijalizacija
    }

    @Override
    public String getItemName() {
        return "Individualna statistika";
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