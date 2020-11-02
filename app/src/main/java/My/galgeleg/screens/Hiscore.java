package My.galgeleg.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Map;

import My.galgeleg.util.HiscoreRecycler;
import My.galgeleg.R;

public class Hiscore extends AppCompatActivity implements View.OnClickListener{

    RecyclerView hiscoreRecycler;
    ArrayList<String> spiller = new ArrayList<>();
    ArrayList<String> score = new ArrayList<>();
    SharedPreferences preferences;
    Button backButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiscore);

        hiscoreRecycler = findViewById(R.id.hiscoreRecycler);
        backButt = findViewById(R.id.backButt);
        backButt.setOnClickListener(this);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        // for taget fra https://stackoverflow.com/questions/22089411/how-to-get-all-keys-of-sharedpreferences-programmatically-in-android
        Map<String, ?> allEntries = preferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            spiller.add((entry.getKey()));
            score.add(entry.getValue().toString());
        }// vil senere hen finde ud af hvordan jeg sorter high score listen så de
        // viser bedste scorere først etc. og passer med de tilhørende navne

        // data fra sharedprefs bliver brugt til high score recycleren
        HiscoreRecycler adapter = new HiscoreRecycler(spiller, score);
        hiscoreRecycler.setAdapter(adapter);
        hiscoreRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {

        if (v == backButt) {
            Intent intent = new Intent(this, MainActivity.class);
            finish();
            startActivity(intent);
        }
    }
}