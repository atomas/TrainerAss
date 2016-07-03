package fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import air.foi.hr.trainerassistant.HttpManager;
import air.foi.hr.trainerassistant.Izbornik;
import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.RequestPackage;
import air.foi.hr.trainerassistant.base.BaseFragment;
import air.foi.hr.trainerassistant.model.Atleticar;


public class NoviKandidatFragment extends BaseFragment implements View.OnClickListener{

    private EditText ime, prezime, datum, visina, tezina;
    private Button dalje;
    private ProgressDialog pDialog;

    @Override
    protected int getLayout() {
        return R.layout.activity_novi_kandidat;
    }

    @Override
    protected void init() {
        //inicijalizacija varijabli
        ime = (EditText) view.findViewById(R.id.input_ime);
        prezime = (EditText) view.findViewById(R.id.input_prezime);
        datum = (EditText) view.findViewById(R.id.input_datum);
        visina = (EditText) view.findViewById(R.id.input_visina);
        tezina = (EditText) view.findViewById(R.id.input_tezina);
        dalje = (Button) view.findViewById(R.id.dalje_novi_kandidat_button);
        dalje.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //provjeri da li su sva polja popunjena
        //ako su popunjena, posalji podatke na server
        //u protivnom ispisi da nisu sva polja popunjena
        if (!ime.getText().toString().equals("") || !prezime.getText().toString().equals("") || !visina.getText().toString().equals("") || !datum.getText().toString().equals("") || !tezina.getText().toString().equals("")) {
            RequestPackage p = new RequestPackage();
            p.setUri("http://izavrski.netau.net/rest/dodaj.php");
            p.setMethod("POST");
            p.setParam("ime", ime.getText().toString());
            p.setParam("prezime", prezime.getText().toString());
            p.setParam("datum", datum.getText().toString());
            p.setParam("visina", visina.getText().toString());
            p.setParam("tezina", tezina.getText().toString());
            NoviUser task = new NoviUser();
            task.execute(p);
        } else
            toastIt("Niste ispunili sva polja");
    }

    private class NoviUser extends AsyncTask<RequestPackage, String, String>{

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(getActivity());
            pDialog.setCanceledOnTouchOutside(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(RequestPackage... params) {
            //slanjem podataka, dobivamo odgovor sa servera
            String content = HttpManager.getData(params[0]);
            return content;
        }

        @Override
        protected void onPostExecute(String s) {
            pDialog.dismiss();
            if (s.substring(0,1).equals("1")) {
                //ako sam uspio unijeti sve podatke dobro, ispise se uspjesno dodavanje novog korisnika
                //u protivnom se desila greska na serveru
                Atleticar a = new Atleticar();
                a.setIme(ime.getText().toString());
                a.setPrezime(prezime.getText().toString());
                ((Izbornik) getActivity()).getAtleticarList().add(a);
                swapFragment(new IzbornikFragment());
                getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                toastIt("Uspješno dodan korisnik");
            }
            else
                toastIt("Greška na serveru");
        }
    }

}
