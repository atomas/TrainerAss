package air.foi.hr.trainerassistant.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import air.foi.hr.trainerassistant.HttpManager;
import air.foi.hr.trainerassistant.Izbornik;
import air.foi.hr.trainerassistant.R;
import air.foi.hr.trainerassistant.RequestPackage;
import air.foi.hr.trainerassistant.base.BaseFragment;
import air.foi.hr.trainerassistant.model.Atleticar;
import air.foi.hr.trainerassistant.model.Disciplina;

public class VrijemeFragment extends BaseFragment implements View.OnClickListener{

    private TextView vrijeme, kandidat;
    private List<Atleticar> atleticarList;
    private ProgressDialog pDialog;
    private int s = 0, d=1;
    private long startTime;
    private long elapsedTime;
    private final int REFRESH_RATE = 100;
    private String seconds, miliseconds;
    private long secs, mecs;
    private Button start, pause, reset, dalje;
    private boolean stoped;
    private Handler mHandler = new Handler();
    private Runnable startTimer = new Runnable() {
        public void run() {
            //mjerac vremena
            elapsedTime = System.currentTimeMillis() - startTime;
            updateTimer(elapsedTime);
            mHandler.postDelayed(this, REFRESH_RATE);
        }
    };

    @Override
    protected int getLayout() {
        return R.layout.activity_pojedinacna_disciplina;
    }

    @Override
    protected void init() {
        //inicijalizacija
        vrijeme = (TextView) view.findViewById(R.id.vrijeme_textview);
        kandidat = (TextView) view.findViewById(R.id.ime_kandidat_textview);
        getkandidat(s);
        start = (Button) view.findViewById(R.id.startTimer);
        pause = (Button) view.findViewById(R.id.pauseTimer);
        reset = (Button) view.findViewById(R.id.resetTimer);
        dalje = (Button) view.findViewById(R.id.dalje_pojedinacna_disciplina_button);
        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        reset.setOnClickListener(this);
        dalje.setOnClickListener(this);
        atleticarList = new ArrayList<>();

    }

    private void updateTimer (float time) {
        //kako dobiti sekunde i milisekunde, te pogledati njihov format i pravilno ih ispisati
        secs = (long)(time/1000);
        secs = secs%60;
        seconds = String.valueOf(secs);
        if (secs == 0) {
            seconds = "00";
        }
        if (secs <10 && secs >0){
            seconds = "0"+seconds;
        }


        miliseconds = String.valueOf((long)time);
        if (miliseconds.length() == 2){
            miliseconds = "0" + miliseconds;
        }
        if (miliseconds.length()<=1){
            miliseconds = "00";
        }
        vrijeme.setText(seconds + "," + miliseconds);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.startTimer:
                //pokreni timer
                if(stoped){
                    startTime = System.currentTimeMillis() - elapsedTime;
                } else{
                    startTime = System.currentTimeMillis();
                }
                mHandler.removeCallbacks(startTimer);
                mHandler.postDelayed(startTimer, 0);
                break;
            case R.id.pauseTimer:
                //zaustavi timer
                mHandler.removeCallbacks(startTimer);
                stoped = true;
                break;
            case R.id.resetTimer:
                //restartaj timer
                vrijeme.setText("00:00:00,0");
                stoped = false;
                break;
            case R.id.dalje_pojedinacna_disciplina_button:
                if (s == ((Izbornik) getActivity()).getNazocniList().size() && d == ((Izbornik) getActivity()).getNazocneDiscipline().size()) {
                    addKorisnik(s-1, d-1);
                    swapFragment(new IzbornikFragment());
                } else if (s == ((Izbornik) getActivity()).getNazocniList().size() && d != ((Izbornik) getActivity()).getNazocneDiscipline().size()) {
                    addKorisnik(s - 1, d - 1);
                    s=0;
                    getkandidat(s);
                    d++;
                } else {
                    addKorisnik(s-1,d-1);
                    getkandidat(s);
                }
                break;
        }
    }

    private void getkandidat(int id){
        //ispisvanje imena i prezime za kandidata za kojeg se trenutno mjeri vrijeme
        kandidat.setText(((Izbornik) getActivity()).getNazocniList().get(id).getPrezime() + " " + ((Izbornik) getActivity()).getNazocniList().get(id).getIme());
        s++;
    }

    private void addKorisnik(int c, int b){
        //dodavanje korisnika u listu i spremanje na server
        Log.d("Ovo je s i d", String.valueOf(c) + " " + String.valueOf(b));
        Atleticar a = new Atleticar();
        a.setId((((Izbornik) getActivity()).getNazocniList().get(c).getId()));
        a.setPrezime(((Izbornik) getActivity()).getNazocniList().get(c).getPrezime() + " " + ((Izbornik) getActivity()).getNazocniList().get(c).getIme());
        a.setVrijeme(vrijeme.getText().toString());
        a.setDisciplina(((Izbornik) getActivity()).getNazocneDiscipline().get(b).getNaziv());
        Updateuser up = new Updateuser();
        RequestPackage r = new RequestPackage();
        r.setUri("http://izavrski.netau.net/rest/dodaj_rezultat.php");
        r.setMethod("POST");
        r.setParam("id_clan", String.valueOf(a.getId()));
        r.setParam("id_disciplina", String.valueOf(((Izbornik) getActivity()).getNazocneDiscipline().get(b).getId()));
        r.setParam("rezultat", a.getVrijeme());
        up.execute(r);
        atleticarList.add(a);
    }

    private class Updateuser extends AsyncTask<RequestPackage, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setCanceledOnTouchOutside(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(RequestPackage... params) {
            //odgoovr sa servera
            String content = HttpManager.getData(params[0]);
            Log.d("Ovo je content", content);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            pDialog.dismiss();
        }
    }

}
