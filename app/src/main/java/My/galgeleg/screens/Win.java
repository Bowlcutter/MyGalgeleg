package My.galgeleg.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import My.galgeleg.R;
import pl.droidsonroids.gif.GifImageView;

public class Win extends AppCompatActivity implements View.OnClickListener{

    TextView winText;
    GifImageView winGif;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        winText = findViewById(R.id.winnerText);
        winGif = findViewById(R.id.winGif);
        winGif.setOnClickListener(this);

        // får spillerens navn og forsøg fra game klassen
        String spillerNavn = getIntent().getStringExtra("navn");
        int spillerScore = getIntent().getIntExtra("tries", 0);

        // gemmer spilleren navn og tilhørende score i shared prefs
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putInt(spillerNavn, spillerScore).apply();

        winText.append(": " + spillerNavn + "\nForsøg: " + spillerScore +
                "\n\nTryk på den saftige brød robot!");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}