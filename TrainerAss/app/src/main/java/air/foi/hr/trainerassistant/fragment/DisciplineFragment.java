package air.foi.hr.trainerassistant.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import air.foi.hr.trainerassistant.Izbornik;
import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.adapter.DisciplineAdapter;
import air.foi.hr.trainerassistant.api.Click;
import air.foi.hr.trainerassistant.api.NavigationItem;
import air.foi.hr.trainerassistant.base.BaseFragment;
import air.foi.hr.trainerassistant.model.Disciplina;


public class DisciplineFragment extends BaseFragment implements View.OnClickListener, NavigationItem{

    private RecyclerView recyclerView;
    private DisciplineAdapter adapter;
    private Button dalje;
    private int position;
    private String name;

    public DisciplineFragment(){

    }

    public DisciplineFragment(String name){
        this.name = name;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_disciplina;
    }

    @Override
    protected void init() {

        //inicijalizacija
        recyclerView = (RecyclerView) view.findViewById(R.id.discipline_recyclerView);
        adapter = new DisciplineAdapter(getActivity(), ((Izbornik) getActivity()).getDisciplinaList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        dalje = (Button) view.findViewById(R.id.daljeDiscipline);
        dalje.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //za sve disciplije koje su oznacene, dodaj ih u listu nazocne koja se nalazi u izborniku
        for (Disciplina d : ((Izbornik) getActivity()).getDisciplinaList()){
            if (d.isNazocan())
                ((Izbornik) getActivity()).getNazocneDiscipline().add(d);
        }
        swapFragment(new VrijemeFragment());

    }

    @Override
    public String getItemName() {
        return name;
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
