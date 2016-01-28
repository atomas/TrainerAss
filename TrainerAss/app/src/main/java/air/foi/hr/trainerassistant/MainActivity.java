package air.foi.hr.trainerassistant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import air.foi.hr.trainerassistant.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private EditText korisnicko_ime, lozinka;
    private Button prijava, register;
    private ProgressDialog pDialog;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        //inicijlaizacija
        korisnicko_ime = (EditText) findViewById(R.id.input_username);
        lozinka = (EditText) findViewById(R.id.input_password);
        prijava = (Button) findViewById(R.id.prijavaButton);
        register = (Button) findViewById(R.id.registerButton);
        register.setOnClickListener(this);
        prijava.setOnClickListener(this);
        pDialog = new ProgressDialog(this);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.setCancelable(false);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.prijavaButton:
                RequestPackage p = new RequestPackage();
                p.setUri("http://izavrski.netau.net/rest/login.php");
                p.setMethod("POST");
                p.setParam("user", korisnicko_ime.getText().toString());
                p.setParam("pass", lozinka.getText().toString());
                LoginTask task = new LoginTask();
                task.execute(p);
                break;
            case R.id.registerButton:
                //pokretanje aktivnosti registracije
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }

    }

    private class LoginTask extends AsyncTask<RequestPackage, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog.show();
        }

        @Override
        protected String doInBackground(RequestPackage... params) {
            String content = HttpManager.getData(params[0]);
            Log.d("Ovo je content", content);
            return "anto tomas";
        }

        @Override
        protected void onPostExecute(String s) {
            pDialog.dismiss();
            Log.d("Ovo je s", "kako si +" + s.substring(0, 1) + "+");
            if (s.substring(0,1).equals("1")){
                Intent intent = new Intent(getApplicationContext(), Izbornik.class);
                startActivity(intent);
                finish();
            } else
                toastIt("Niste unijeli prave informacije");
        }
    }

}
