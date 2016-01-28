package air.foi.hr.trainerassistant.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import air.foi.hr.trainerassistant.R;

public abstract class BaseFragment extends Fragment{

    protected abstract int getLayout();
    protected abstract void init();
    protected View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(), container, false);
        init();
        return view;
    }

    protected void swapFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.izbornik_frame, fragment).commit();
    }

    protected void toastIt(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

}
