package air.foi.hr.trainerassistant.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import air.foi.hr.trainerassistant.Izbornik;
import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.RequestPackage;
import air.foi.hr.trainerassistant.adapter.KandidatiAdapter;
import air.foi.hr.trainerassistant.api.NavigationItem;
import air.foi.hr.trainerassistant.base.BaseFragment;


public class KandidatiFragment extends BaseFragment implements View.OnClickListener, NavigationItem{

    private RecyclerView recyclerView;
    private KandidatiAdapter adapter;
    //private FloatingActionButton fab;
    private Button novi;
    private int position;

    public KandidatiFragment(){

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_kandidati;
    }

    @Override
    protected void init() {

        //inicijalizacija
        //fab = (FloatingActionButton) view.findViewById(R.id.fab);
        //fab.setOnClickListener(this);

        novi = (Button) view.findViewById(R.id.noviButton);
        novi.setOnClickListener(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.kandidati_recyclerView);
        adapter = new KandidatiAdapter(getActivity(), ((Izbornik) getActivity()).getAtleticarList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        swapFragment(new NoviKandidatFragment());
    }

    @Override
    public String getItemName() {
        return "Lista kandidata";
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
