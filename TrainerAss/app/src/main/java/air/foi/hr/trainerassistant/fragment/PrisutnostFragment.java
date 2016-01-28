package air.foi.hr.trainerassistant.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
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
import air.foi.hr.trainerassistant.base.BaseFragment;
import air.foi.hr.trainerassistant.model.Atleticar;


public class PrisutnostFragment extends BaseFragment implements View.OnClickListener{

    Button dalje;
    private RecyclerView recyclerView;
    private NazocniAdapter adapter;
    private ProgressDialog pDialog;

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
        //definiranje arraya kako bi mogao poslati podatke na server
        JSONArray json = new JSONArray();
        for (Atleticar a : ((Izbornik) getActivity()).getAtleticarList()){
            if (((Izbornik) getActivity()).getNazocniList().contains(a)){
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("id_clan", String.valueOf(a.getId()));
                    jsonObject.put("prisutan", a.isNazocan());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                json.put(jsonObject);
            }
        }
        Log.d("Ovo je json", json.toString());
        //slanje podataka na server
        UpdatePrisutnost update = new UpdatePrisutnost();
        RequestPackage r = new RequestPackage();
        r.setMethod("POST");
        r.setUri("http://izavrski.netau.net/rest/prisutnost.php");
        r.setParam("prisutnost", json.toString());
        update.execute(r);
    }

    private class UpdatePrisutnost extends AsyncTask<RequestPackage, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setCancelable(false);
            pDialog.setCanceledOnTouchOutside(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(RequestPackage... params) {
            //vracam odgovor u varijablu string sa servera
            String content = HttpManager.getData(params[0]);
            return content;
        }

        @Override
        protected void onPostExecute(String s) {
            pDialog.dismiss();
            //nakon sto se unese na server, pristupam izbornik fragmentu
            swapFragment(new IzbornikFragment());
        }
    }

}
