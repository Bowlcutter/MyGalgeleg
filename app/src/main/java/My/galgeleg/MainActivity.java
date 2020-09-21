package My.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button game, settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = findViewById(R.id.gameButt);
        settings = findViewById(R.id.settingButt);

        game.setOnClickListener(this);
        settings.setOnClickListener(this);

    }

    public void onClick(View click) {

        if (click == game) {
            Intent intent = new Intent(this, Game.class);
            startActivity(intent);
        }
        else if (click == settings) {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
        }

    }


}