package air.foi.hr.trainerassistant;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import air.foi.hr.trainerassistant.base.BaseActivity;
import air.foi.hr.trainerassistant.fragment.PrisutnostFragment;
import air.foi.hr.trainerassistant.model.Atleticar;
import air.foi.hr.trainerassistant.model.Disciplina;

public class Izbornik extends BaseActivity {

    private List<Atleticar> atleticarList, nazocniList;
    private List<Disciplina> disciplinaList, nazocneDiscipline;
    private ProgressDialog pDialog;

    @Override
    protected int getLayout() {
        return R.layout.activity_izbornik;
    }

    @Override
    protected void init() {
        //inicijalizacija
        atleticarList = new ArrayList<>();
        disciplinaList = new ArrayList<>();
        nazocniList = new ArrayList<>();
        nazocneDiscipline = new ArrayList<>();
        pDialog = new ProgressDialog(this);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.setCancelable(false);
        PreuzmiAtleticara a = new PreuzmiAtleticara();
        a.execute("http://izavrski.netau.net/rest/clan.php");
        pDialog.show();

    }

    public List<Atleticar> getAtleticarList() {
        return atleticarList;
    }

    public void setAtleticarList(List<Atleticar> atleticarList) {
        this.atleticarList = atleticarList;
    }

    public List<Disciplina> getDisciplinaList() {
        return disciplinaList;
    }

    public void setDisciplinaList(List<Disciplina> disciplinaList) {
        this.disciplinaList = disciplinaList;
    }

    public List<Disciplina> getNazocneDiscipline() {
        return nazocneDiscipline;
    }

    public void setNazocneDiscipline(List<Disciplina> nazocneDiscipline) {
        this.nazocneDiscipline = nazocneDiscipline;
    }

    public List<Atleticar> getNazocniList() {
        return nazocniList;
    }

    public void setNazocniList(List<Atleticar> nazocniList) {
        this.nazocniList = nazocniList;
    }

    private class PreuzmiAtleticara extends AsyncTask<String, String, List<Atleticar>>{

        @Override
        protected List<Atleticar> doInBackground(String... params) {
            //preuzimanje atleticara i njihovo parsiranje
            String content = HttpManager.getData(params[0]);
            atleticarList = JSONParser.parseAtleticar(content);
            return atleticarList;
        }

        @Override
        protected void onPostExecute(List<Atleticar> atleticars) {
            PreuzmiDiscipline d = new PreuzmiDiscipline();
            d.execute("http://izavrski.netau.net/rest/disciplina.php");
        }
    }

    private class PreuzmiDiscipline extends AsyncTask<String, String, List<Disciplina>>{

        @Override
        protected List<Disciplina> doInBackground(String... params) {
            //preuzimanje disciplina i njihovo parsiranje
            String content = HttpManager.getData(params[0]);
            disciplinaList = JSONParser.parseDisciplina(content);
            return disciplinaList;
        }

        @Override
        protected void onPostExecute(List<Disciplina> disciplinas) {
            pDialog.dismiss();
            getSupportFragmentManager().beginTransaction().replace(R.id.izbornik_frame, new PrisutnostFragment()).commit();
        }
    }

}