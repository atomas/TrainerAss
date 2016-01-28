package air.foi.hr.trainerassistant.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import air.foi.hr.trainerassistant.NavigationManager;
import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.adapter.IzbornikAdapter;
import air.foi.hr.trainerassistant.api.Click;
import air.foi.hr.trainerassistant.base.BaseFragment;


public class IzbornikFragment extends BaseFragment {

    private NavigationManager nm;
    private RezultatFragment rf;
    private KandidatiFragment kf;
    private DisciplineFragment df;

    @Override
    protected int getLayout() {
        return R.layout.fragment_izbornik;
    }

    @Override
    protected void init() {
        //inicijalizacija i ovaj fragment je modularan
        rf = new RezultatFragment("Pregled statistike");
        kf = new KandidatiFragment("Lista kandidata");
        df = new DisciplineFragment("Novi trening");
        nm = NavigationManager.getInstance();
        nm.setDependencies(getActivity(), (RecyclerView) view.findViewById(R.id.izbornik_recycler));
        if (nm.isEmpty()){
            nm.addItem(rf);
            nm.addItem(kf);
            nm.addItem(df);
        }
        nm.setup();

    }
}
