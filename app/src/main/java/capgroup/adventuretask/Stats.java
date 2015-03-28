package capgroup.adventuretask;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Stats extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Character character = new Character(getApplicationContext());

        TextView textView = (TextView) findViewById(R.id.character_name);
        textView.setText("Name: " + character.getName());

        textView = (TextView) findViewById(R.id.character_level);
        textView.setText("LVL: " + Integer.toString(character.getCurrentLevel()));

        textView = (TextView) findViewById(R.id.character_strength);
        textView.setText("Strength: " + Integer.toString(character.getStrength()));

        textView = (TextView) findViewById(R.id.character_intelligence);
        textView.setText("Intelligence: " + Integer.toString(character.getIntelligence()));

        textView = (TextView) findViewById(R.id.character_charisma);
        textView.setText("Charisma: " + Integer.toString(character.getCharisma()));

        textView = (TextView) findViewById(R.id.character_stamina);
        textView.setText("Stamina: " + Integer.toString(character.getStamina()));

        ProgressBar xpProgress = (ProgressBar) findViewById(R.id.xp_progress);
        xpProgress.setMax(character.xpFromLastLevel() + character.xpToNextLevel());
        xpProgress.setProgress(character.xpToNextLevel());
        Log.d("DEBUG", "character.getCurrentLevel() = " + character.getCurrentLevel());
        Log.d("DEBUG", "character.getActualLevel() = " + character.getActualLevel());
        Log.d("DEBUG", "character.getXp() = " + character.getXp());
        Log.d("DEBUG", "character.xpToNextLevel() = " + character.xpToNextLevel());
        Log.d("DEBUG", "character.xpFromLastLevel() = " + character.xpFromLastLevel());
    }
}
