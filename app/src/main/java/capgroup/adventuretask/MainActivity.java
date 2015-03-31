package capgroup.adventuretask;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newGame = (Button) findViewById(R.id.new_game);
        newGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Character character = new Character(getApplicationContext());
                character.createNew();
                startActivity(new Intent(MainActivity.this, Stats.class));
            }
        });

        Button continueGame = (Button) findViewById(R.id.continue_quest);
        continueGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Stats.class));
            }
        });
    }
}
