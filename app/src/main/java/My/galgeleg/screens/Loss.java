package My.galgeleg.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import My.galgeleg.R;


public class Loss extends AppCompatActivity implements View.OnClickListener{

    TextView lossText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loss);

        lossText = findViewById(R.id.lossText);
        lossText.setOnClickListener(this);

        lossText.append("\nOrdet var: " + getIntent().getStringExtra("Ordet") +
                "\n\nTryk på teksten for at gå tilbage");

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}