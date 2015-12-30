package hr.foi.air_trainerass.www.trainerass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

import air.foi.hr.db.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActiveAndroid.initialize(this);
        setContentView(R.layout.activity_main);

        Button btnClanovi = (Button)findViewById(R.id.btn_clanovi);
        btnClanovi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Clanovi.class);
                startActivity(i);
            }
        });
        Button btnStatistika = (Button)findViewById(R.id.btn_statistika);
        btnStatistika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Statistika.class);
                startActivity(i);
            }
        });
        Button btnTrening = (Button)findViewById(R.id.btn_trening);
        btnTrening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Trening.class);
                startActivity(i);
            }
        });
    }

    /**
     * Overides extended method and inflates menu. After adding this method, user will be able to show menu.
     * @param menu The reference to the object that should be inflated according to menu definition in resources.
     * @return True if everything is OK.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handles menu item clicks by overriding extended method.
     * @param item Contains reference to the item that user clicked on.
     * @return True if event is handled correctly.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Switch on item id.
        //Currently there are no actions to perform.
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_search:
                break;
            case R.id.action_settings:
                break;
            case R.id.action_logout:
                startActivity(new Intent(this, Login.class));
                break;
        }
hhhh
        //Temporary shows message that click is handled.
        Toast.makeText(this, "Menu item " + item.getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
        return true;
    }
}
