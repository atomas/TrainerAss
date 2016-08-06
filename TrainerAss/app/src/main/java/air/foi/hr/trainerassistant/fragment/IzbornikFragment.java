package air.foi.hr.trainerassistant.fragment;

import android.support.v7.widget.RecyclerView;

import air.foi.hr.trainerassistant.NavigationManager;
import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.base.BaseFragment;


public class IzbornikFragment extends BaseFragment {

    private NavigationManager nm;

    @Override
    protected int getLayout() {
        return R.layout.fragment_izbornik;
    }

    @Override
    protected void init() {
        //inicijalizacija i ovaj fragment je modularan

        nm = NavigationManager.getInstance();
        nm.setDependencies(getActivity(), (RecyclerView) view.findViewById(R.id.izbornik_recycler));
        if (nm.isEmpty()){
            nm.addItem(new KandidatiFragment());
            nm.addItem(new PrisutnostFragment());
            nm.addItem(new RezultatFragment());
            nm.addItem(new IndividualnaStatistikaFragment());
        }
        nm.setup();

    }
}
