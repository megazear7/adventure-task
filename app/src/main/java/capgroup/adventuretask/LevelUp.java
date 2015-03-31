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

        character = new Character(getApplicationContext());

        if (character.getCurrentLevel() < character.getActualLevel()) {

            setContentView(R.layout.activity_level_up);

            final TextView STRView = (TextView) findViewById(R.id.STRDisp);
            STRView.setText(Integer.toString(character.getStrength()));

            final Button STRInc = (Button) findViewById(R.id.STRInc);
            STRInc.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (character.getActualLevel() > character.getCurrentLevel()) {
                        character.increaseStrength(1);
                        character.increaseLevel();
                        STRView.setText(Integer.toString(character.getStrength()));
                    }
                }
            });

            final TextView INTView = (TextView) findViewById(R.id.INTDisp);
            INTView.setText(Integer.toString(character.getIntelligence()));

            final Button incInt = (Button) findViewById(R.id.INTInc);
            incInt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (character.getActualLevel() > character.getCurrentLevel()) {
                        character.increaseIntelligence(1);
                        character.increaseLevel();
                        INTView.setText(Integer.toString(character.getIntelligence()));
                    }
                }
            });

            final TextView CHAView = (TextView) findViewById(R.id.CHADisp);
            CHAView.setText(Integer.toString(character.getCharisma()));

            final Button incCha = (Button) findViewById(R.id.CHAInc);
            incCha.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (character.getActualLevel() > character.getCurrentLevel()) {
                        character.increaseCharisma(1);
                        character.increaseLevel();
                        CHAView.setText(Integer.toString(character.getCharisma()));
                    }
                }
            });


            final TextView STAView = (TextView) findViewById(R.id.STADisp);
            STAView.setText(Integer.toString(character.getStamina()));

            final Button incSta = (Button) findViewById(R.id.STAInc);
            incSta.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (character.getActualLevel() > character.getCurrentLevel()) {
                        character.increaseStamina(1);
                        character.increaseLevel();
                        STAView.setText(Integer.toString(character.getStamina()));
                    }
                }
            });

        } else {
            setContentView(R.layout.activity_cant_level_up);
        }
    }





}
