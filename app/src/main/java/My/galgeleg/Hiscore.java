package My.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class Hiscore extends AppCompatActivity implements View.OnClickListener{

    RecyclerView hiscoreRecycler;
    String spiller[], score[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiscore);

        hiscoreRecycler = findViewById(R.id.hiscoreRecycler);

        spiller = getResources().getStringArray(R.array.spillere);
        score = getResources().getStringArray(R.array.spillerscore);

        HiscoreRecycler adapter = new HiscoreRecycler(spiller, score);

        hiscoreRecycler.setAdapter(adapter);
        hiscoreRecycler.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onClick(View v) {

    }
}