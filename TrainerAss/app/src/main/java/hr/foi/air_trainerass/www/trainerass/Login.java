package hr.foi.air_trainerass.www.trainerass;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
public class Login extends AppCompatActivity implements View.OnClickListener {
    TextView tvRegisterLink;
    Button btnLogin;
    EditText etKorIme, etLozinka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etKorIme = (EditText) findViewById(R.id.email);
        etLozinka = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btn_prijava);

        tvRegisterLink = (TextView) findViewById(R.id.tv_registerLink);

        btnLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_prijava:
                startActivity(new Intent(this, RegisterActivity.class));

                break;

            case R.id.tv_registerLink:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }

    }

}

