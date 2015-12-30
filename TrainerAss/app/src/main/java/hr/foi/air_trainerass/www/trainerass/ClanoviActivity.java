package hr.foi.air_trainerass.www.trainerass;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class ClanoviActivity extends AppCompatActivity implements View.OnClickListener{

    //Defining views
    private EditText editTextName;
    private EditText editTextDat;
    private EditText editTextTrener;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clanovi);

        //Initializing views
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDat = (EditText) findViewById(R.id.editTextDat);
        editTextTrener = (EditText) findViewById(R.id.editTextTrener);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    //Adding an employee
    private void addSportas(){

        final String name = editTextName.getText().toString().trim();
        final String dat = editTextDat.getText().toString().trim();
        final String trener = editTextTrener.getText().toString().trim();

        class AddSportas extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ClanoviActivity.this,"Adding...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(ClanoviActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(ConfigClass.KEY_EMP_NAME,name);
                params.put(ConfigClass.KEY_EMP_DAT,dat);
                params.put(ConfigClass.KEY_EMP_TRENER,trener);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(ConfigClass.URL_ADD, params);
                return res;
            }
        }

        AddSportas as = new AddSportas();
        as.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addSportas();
        }

        if(v == buttonView){
            startActivity(new Intent(this,SviSportasiActivity.class));
        }
    }
}