package capgroup.adventuretask;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class LevelUp extends BaseActivity {

    private Character character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_up);

        character = new Character(getApplicationContext());

        final Button STRInc = (Button) findViewById(R.id.STRInc);
        STRInc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                character.increaseStrength(1);
                character.updateStats();
            }
        });

        TextView textView = (TextView) findViewById(R.id.STRDisp);
        textView.setText(Integer.toString(character.getStrength()));

        final Button incInt = (Button) findViewById(R.id.INTInc);
        incInt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                character.increaseIntelligence(1);
                character.updateStats();
            }
        });

        textView = (TextView) findViewById(R.id.INTDisp);
        textView.setText(Integer.toString(character.getIntelligence()));

        final Button incCha = (Button) findViewById(R.id.CHAInc);
        incCha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                character.increaseCharisma(1);
                character.updateStats();
            }
        });

        textView = (TextView) findViewById(R.id.CHADisp);
        textView.setText(Integer.toString(character.getCharisma()));

        final Button incSta = (Button) findViewById(R.id.STAInc);
        incSta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                character.increaseStamina(1);
                character.updateStats();
            }
        });

        textView = (TextView) findViewById(R.id.STADisp);
        textView.setText(Integer.toString(character.getStamina()));
    }





}
