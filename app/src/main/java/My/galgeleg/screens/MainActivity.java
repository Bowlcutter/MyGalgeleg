package My.galgeleg.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import My.galgeleg.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button game, hiscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = findViewById(R.id.gameButt);
        hiscore = findViewById(R.id.hiscoreButt);

        game.setOnClickListener(this);
        hiscore.setOnClickListener(this);

    }

    public void onClick(View click) {

        if (click == game) {
            Intent intent = new Intent(this, Game.class);
            startActivity(intent);
        }
        else if (click == hiscore) {
            Intent intent = new Intent(this, Hiscore.class);
            startActivity(intent);
        }

    }

}