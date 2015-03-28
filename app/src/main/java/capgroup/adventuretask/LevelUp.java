package capgroup.adventuretask;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class LevelUp extends BaseActivity {

    private Character character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_up);

        character = new Character(getApplicationContext());

        final Button incStr = (Button) findViewById(R.id.increase_strength);
        incStr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (character.getActualLevel() > character.getCurrentLevel()) {
                    character.increaseStrength(1);
                    character.increaseLevel();
                }
            }
        });

        final Button incInt = (Button) findViewById(R.id.increase_intelligence);
        incInt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (character.getActualLevel() > character.getCurrentLevel()) {
                    character.increaseIntelligence(1);
                    character.increaseLevel();
                }
            }
        });

        final Button incCha = (Button) findViewById(R.id.increase_charisma);
        incCha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (character.getActualLevel() > character.getCurrentLevel()) {
                    character.increaseCharisma(1);
                    character.increaseLevel();
                }

            }
        });

        final Button incSta = (Button) findViewById(R.id.increase_stamina);
        incSta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (character.getActualLevel() > character.getCurrentLevel()) {
                    character.increaseStamina(1);
                    character.increaseLevel();
                }

            }
        });
    }
}
