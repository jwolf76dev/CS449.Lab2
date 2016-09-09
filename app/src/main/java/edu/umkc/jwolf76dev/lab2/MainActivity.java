package edu.umkc.jwolf76dev.lab2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final private String TAG = "Umpire Buddy v2.0";
    private static final String PREFS_NAME = "PrefsFile";
    private static final String TOTAL_OUTS = "totalOuts";

//    static final String EXTRA_DATA = "1";

    private int strike_count = 0;
    private int ball_count = 0;
    private int totalOuts_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Starting onCreate...");
        setContentView(R.layout.activity_main);

        View StrikeButton = findViewById(R.id.strike_button);
        StrikeButton.setOnClickListener(this);

        updateStrikeCount();

        View BallButton = findViewById(R.id.ball_button);
        BallButton.setOnClickListener(this);

        updateBallCount();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        totalOuts_count = settings.getInt(TOTAL_OUTS, totalOuts_count);
        updateTotalOutsCount();
    }

    private void updateStrikeCount() {
        TextView t = (TextView)findViewById(R.id.strike_count_value);
        t.setText(Integer.toString(strike_count));
    }

    private void updateBallCount() {
        TextView t = (TextView)findViewById(R.id.ball_count_value);
        t.setText(Integer.toString(ball_count));
    }

    private void updateTotalOutsCount() {
        TextView t = (TextView) findViewById(R.id.totalOuts_value);
        t.setText(Integer.toString(totalOuts_count));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.reset:
                strike_count = 0;
                ball_count = 0;
                updateStrikeCount();
                updateBallCount();
                return true;
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
//                intent.putExtra(EXTRA_DATA, "extra data or parameter you want to pass to activity");
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.strike_button:
                // Start count over if user tries to increment beyond 2.
                if (strike_count == 2) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Strike Out");
                    builder.setMessage("Batter is out!");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Next Batter", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            strike_count = 0;
                            updateStrikeCount();

                            ball_count = 0;
                            updateBallCount();

                            totalOuts_count++;
                            updateTotalOutsCount();

                            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                            SharedPreferences.Editor editor = settings.edit();
                            editor.putInt(TOTAL_OUTS, totalOuts_count);
                            // Commit the edits
                            editor.commit();
                        }
                    });
                    builder.show();
                } else {
                    strike_count++;
                }
                break;
            case R.id.ball_button:
                // Start count over if user tries to increment beyond 3.
                if (ball_count == 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Walk");
                    builder.setMessage("Batter walks!");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Next Batter", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            strike_count = 0;
                            updateStrikeCount();

                            ball_count = 0;
                            updateBallCount();
                        }
                    });
                    builder.show();
                } else {
                    ball_count++;
                }
                break;
        }

        updateStrikeCount();
        updateBallCount();
        updateTotalOutsCount();
    }
}