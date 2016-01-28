package air.foi.hr.trainerassistant;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import air.foi.hr.trainerassistant.base.BaseActivity;

public class RegisterActivity extends BaseActivity implements View.OnClickListener{

    private EditText ime, prezime, username, password;
    private Button dalje;
    private ProgressDialog pDialog;

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        //inicijalizacija
        ime = (EditText) findViewById(R.id.input_trener_ime);
        prezime = (EditText) findViewById(R.id.input_trener_prezime);
        username = (EditText) findViewById(R.id.input_trener_username);
        password = (EditText) findViewById(R.id.input_trener_password);
        dalje = (Button) findViewById(R.id.dalje_novi_trener_button);
        dalje.setOnClickListener(this);
        pDialog = new ProgressDialog(this);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.setCancelable(false);
    }

    @Override
    public void onClick(View v) {
        if (!ime.getText().toString().equals("") || !prezime.getText().toString().equals("") || !username.getText().toString().equals("") || !password.getText().toString().equals("")) {
            RequestPackage p = new RequestPackage();
            p.setUri("http://izavrski.netau.net/rest/register.php");
            p.setMethod("POST");
            p.setParam("ime", ime.getText().toString());
            p.setParam("prezime", prezime.getText().toString());
            p.setParam("username", username.getText().toString());
            p.setParam("password", password.getText().toString());
            NoviTrener task = new NoviTrener();
            task.execute(p);
        } else
            toastIt("Niste ispunili sva polja");
    }

    private class NoviTrener extends AsyncTask<RequestPackage, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog.show();
        }

        @Override
        protected String doInBackground(RequestPackage... params) {
            String content = HttpManager.getData(params[0]);
            Log.d("content", content);
            return content;
        }

        @Override
        protected void onPostExecute(String s) {
            pDialog.dismiss();
            if (s.substring(0,1).equals("1")) {
                toastIt("Uspješno dodan korisnik");
                finish();
            }
            else
                toastIt("Greška na serveru");
        }
    }

}
