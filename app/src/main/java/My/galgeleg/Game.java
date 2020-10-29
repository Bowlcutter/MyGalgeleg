package My.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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
    int forsøg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        bopIt = findViewById(R.id.bopIt);
        inLetter = findViewById(R.id.inLetter);
        infoText = findViewById(R.id.infoText);
        galge = findViewById(R.id.galge);

        infoText.setText("Velkommen til galgelegen :)" +
                "\nKun små bogstaver!" +
                "\n\nGæt ordet: " + logik.getSynligtOrd());

        bopIt.setOnClickListener(this);
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

        forsøg++;
        updateScreen();
    }

    public void updateScreen() {

        infoText.setText("Gæt: " + logik.getSynligtOrd());
        infoText.append("\nAntal forkerte: " + logik.getAntalForkerteBogstaver() +
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

            Intent intent = new Intent(this, Win.class);
            intent.putExtra("tries", forsøg);
            startActivity(intent);
        }
        else if (logik.erSpilletTabt()) {

            /*getParentFragmentManager().beginTransaction()
                    .replace(R.id. , new  ())
                    .addToBackStack(null)
                    .commit();*/
            //can i extend both fragment and appcompatactivity somehow?

            Intent intent = new Intent(this, Loss.class);
            intent.putExtra("Ordet", logik.getOrdet());
            startActivity(intent);
        }
    }
}