package My.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity implements View.OnClickListener {

    Galgelogik logik = new Galgelogik();
    Button bopIt;
    EditText inLetter;
    TextView infoText;
    ImageView galge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        bopIt = findViewById(R.id.bopIt);
        inLetter = findViewById(R.id.inLetter);
        infoText = findViewById(R.id.infoText);
        galge = findViewById(R.id.galge);

        infoText.setText("Hej, her er mit galgeleg" +
                "\n\nGæt ordet: " + logik.getSynligtOrd());

    }
    @Override
    public void onClick(View v) {

        String bogstav = inLetter.getText().toString();
        if (bogstav.length() != 1) {
            inLetter.setError("Skriv præcis ét bogstav");
            return;
        }
        logik.gætBogstav(bogstav);
        inLetter.setText("");
        inLetter.setError(null);
        updateScreen();
    }

    public void updateScreen() {

        infoText.setText("Gæt: " + logik.getSynligtOrd() +
                "\nAntal forkerte: " + logik.getAntalForkerteBogstaver() +
                "\n\nDu har gættet på: " + logik.getBrugteBogstaver());

        if (logik.getAntalForkerteBogstaver() == 1)
        galge.setImageResource(R.drawable.forkert1);
        else if (logik.getAntalForkerteBogstaver() == 2)
            galge.setImageResource(R.drawable.forkert2);
        else if (logik.getAntalForkerteBogstaver() == 3)
            galge.setImageResource(R.drawable.forkert3);
        else if (logik.getAntalForkerteBogstaver() == 4)
            galge.setImageResource(R.drawable.forkert4);
        else if (logik.getAntalForkerteBogstaver() == 5)
            galge.setImageResource(R.drawable.forkert5);
        else if (logik.getAntalForkerteBogstaver() == 6)
            galge.setImageResource(R.drawable.forkert6);

        if (logik.erSpilletVundet()) {

            infoText.setTextColor(Color.GREEN);
            infoText.setTextSize(33);
            infoText.setBackgroundColor(Color.BLACK);
            infoText.setText("Winner Winner\nChicken Dinner");
        }
        else if (logik.erSpilletTabt()) {
            infoText.setTextColor(Color.GREEN);
            infoText.setTextSize(33);
            infoText.setBackgroundColor(Color.BLACK);
            infoText.setText("Ooga booga\nDu tabte\n\nOrdet var: " + logik.getOrdet());
        }

    }
}