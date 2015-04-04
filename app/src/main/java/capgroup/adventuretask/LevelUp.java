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
    private int maxPoints;//This ensures that the remaining Att Points never go above the number it started at.
    private int initStr;//These ensure that the player can't make values go lower than the value they started from.
    private int initInt;
    private int initCha;
    private int initSta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        character = new Character(getApplicationContext());
        character.increaseLevel();

        if (character.getAttributeBoostPoints()>0) {

            setContentView(R.layout.activity_level_up);

            maxPoints = character.getAttributeBoostPoints();

            initStr = character.getStrength();
            initInt = character.getIntelligence();
            initCha = character.getCharisma();
            initSta = character.getStamina();

            final TextView ATTView= (TextView) findViewById(R.id.ATTDisp);
            ATTView.setText("Remaining Attribute Points: " + Integer.toString(character.getAttributeBoostPoints()));


            final TextView STRView = (TextView) findViewById(R.id.STRDisp);
            STRView.setText(Integer.toString(character.getStrength()));

            final Button STRInc = (Button) findViewById(R.id.STRInc);
            STRInc.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (character.getAttributeBoostPoints()>0) {
                        character.increaseStrength(1);
                       // character.increaseLevel();
                        character.increaseAttributeBoostPoints(-1);
                        STRView.setText(Integer.toString(character.getStrength()));
                        ATTView.setText("Remaining Attribute Points: " + Integer.toString(character.getAttributeBoostPoints()));
                    }
                }
            });

            final Button STRDec = (Button) findViewById(R.id.STRDec);
            STRDec.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (character.getAttributeBoostPoints()<maxPoints) {
                        if(initStr<character.getStrength()) {//If it goes below the value it started at, it won't work
                            character.increaseStrength(-1);
                            //   character.increaseLevel();
                            character.increaseAttributeBoostPoints(1);
                            STRView.setText(Integer.toString(character.getStrength()));
                            ATTView.setText("Remaining Attribute Points: " + Integer.toString(character.getAttributeBoostPoints()));
                        }
                    }
                }
            });

            final TextView INTView = (TextView) findViewById(R.id.INTDisp);
            INTView.setText(Integer.toString(character.getIntelligence()));

            final Button incInt = (Button) findViewById(R.id.INTInc);
            incInt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (character.getAttributeBoostPoints()>0) {
                        character.increaseIntelligence(1);
                        //character.increaseLevel();
                        character.increaseAttributeBoostPoints(-1);
                        INTView.setText(Integer.toString(character.getIntelligence()));
                        ATTView.setText("Remaining Attribute Points: " + Integer.toString(character.getAttributeBoostPoints()));

                    }
                }
            });

            final Button decInt = (Button) findViewById(R.id.INTDec);
            decInt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (character.getAttributeBoostPoints()<maxPoints) {
                        if(initInt<character.getIntelligence()) {//If it goes below the value it started at, it won't work
                            character.increaseIntelligence(-1);
                            // character.increaseLevel();
                            character.increaseAttributeBoostPoints(1);
                            INTView.setText(Integer.toString(character.getIntelligence()));
                            ATTView.setText("Remaining Attribute Points: " + Integer.toString(character.getAttributeBoostPoints()));
                        }
                    }
                }
            });

            final TextView CHAView = (TextView) findViewById(R.id.CHADisp);
            CHAView.setText(Integer.toString(character.getCharisma()));

            final Button CHAInc = (Button) findViewById(R.id.CHAInc);
            CHAInc.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (character.getAttributeBoostPoints()>0) {
                        character.increaseCharisma(1);
                        // character.increaseLevel();
                        character.increaseAttributeBoostPoints(-1);
                        CHAView.setText(Integer.toString(character.getCharisma()));
                        ATTView.setText("Remaining Attribute Points: " + Integer.toString(character.getAttributeBoostPoints()));
                    }
                }
            });

            final Button CHADec = (Button) findViewById(R.id.CHADec);
            CHADec.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (character.getAttributeBoostPoints()<maxPoints) {
                        if(initCha<character.getCharisma()) {//If it goes below the value it started at, it won't work
                            character.increaseCharisma(-1);
                            //   character.increaseLevel();
                            character.increaseAttributeBoostPoints(1);
                            CHAView.setText(Integer.toString(character.getCharisma()));
                            ATTView.setText("Remaining Attribute Points: " + Integer.toString(character.getAttributeBoostPoints()));
                        }
                    }
                }
            });


            final TextView STAView = (TextView) findViewById(R.id.STADisp);
            STAView.setText(Integer.toString(character.getStamina()));

            final Button STAInc = (Button) findViewById(R.id.STAInc);
            STAInc.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (character.getAttributeBoostPoints()>0) {
                        character.increaseStamina(1);
                        // character.increaseLevel();
                        character.increaseAttributeBoostPoints(-1);
                        STAView.setText(Integer.toString(character.getStamina()));
                        ATTView.setText("Remaining Attribute Points: " + Integer.toString(character.getAttributeBoostPoints()));
                    }
                }
            });

            final Button STADec = (Button) findViewById(R.id.STADec);
            STADec.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (character.getAttributeBoostPoints()<maxPoints) {
                        if(initSta<character.getStamina()) {//If it goes below the value it started at, it won't work
                            character.increaseStamina(-1);
                            //   character.increaseLevel();
                            character.increaseAttributeBoostPoints(1);
                            STAView.setText(Integer.toString(character.getStamina()));
                            ATTView.setText("Remaining Attribute Points: " + Integer.toString(character.getAttributeBoostPoints()));
                        }
                    }
                }
            });
        } else {
            setContentView(R.layout.activity_cant_level_up);
        }
    }





}
