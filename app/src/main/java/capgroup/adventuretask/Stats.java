package capgroup.adventuretask;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

        textView = (TextView) findViewById(R.id.character_xp);
        textView.setText("XP: " + Integer.toString(character.getXp()));

        textView = (TextView) findViewById(R.id.character_strength);
        textView.setText("Strength: " + Integer.toString(character.getStrength()));

        textView = (TextView) findViewById(R.id.character_intelligence);
        textView.setText("Intelligence: " + Integer.toString(character.getIntelligence()));

        textView = (TextView) findViewById(R.id.character_charisma);
        textView.setText("Charisma: " + Integer.toString(character.getCharisma()));

        textView = (TextView) findViewById(R.id.character_stamina);
        textView.setText("Stamina: " + Integer.toString(character.getStamina()));
    }
}
