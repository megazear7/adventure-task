package capgroup.adventuretask;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Admin extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // Create the character object from the saved data
        final Character character = new Character(getApplicationContext());

        final Button add1 = (Button) findViewById(R.id.add_1_xp);
        add1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                character.addXP(1);
            }
        });

        final Button add10 = (Button) findViewById(R.id.add_10_xp);
        add10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                character.addXP(10);
            }
        });

    }
}
