package air.foi.hr.mjerenja;


import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;



public class Stoperica extends Activity {

    private TextView textTimer;
    private Button startButton;
    private Button pauseButton;
    private long startTime = 0L;
    private Handler myHandler = new Handler();
    long vrijemeMili = 0L;
    long vrijemePauziraj = 0L;
    long vrijemeKonacno = 0L;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoperica);

        textTimer = (TextView) findViewById(R.id.textTimer);

        startButton = (Button) findViewById(R.id.btnStart);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();
                myHandler.postDelayed(updateTimerMethod, 0);

            }
        });

        pauseButton = (Button) findViewById(R.id.btnPause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                vrijemePauziraj += vrijemeMili;
                myHandler.removeCallbacks(updateTimerMethod);

            }
        });

    }

    private Runnable updateTimerMethod = new Runnable() {

        public void run() {
            vrijemeMili = SystemClock.uptimeMillis() - startTime;
            vrijemeKonacno = vrijemePauziraj + vrijemeMili;

            int sekunde = (int) (vrijemeKonacno / 1000);
            int minute = sekunde / 60;
            sekunde = sekunde % 60;
            int millisekunde = (int) (vrijemeKonacno % 1000);
            textTimer.setText("" + minute + ":"
            + String.format("%02d", sekunde) + ":"
            + String.format("%03d", millisekunde));
            myHandler.postDelayed(this, 0);
        }

    };
}
