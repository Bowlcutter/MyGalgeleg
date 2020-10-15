package My.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Win extends AppCompatActivity implements View.OnClickListener{

    TextView winText;
    GifImageView winGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        winText = findViewById(R.id.winText);
        winGif = findViewById(R.id.winGif);
        winGif.setOnClickListener(this);

        winText.append("\nForsøg: " + getIntent().getIntExtra("tries", 0) +
                "\n\nTryk på den saftige brød robot!");

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}