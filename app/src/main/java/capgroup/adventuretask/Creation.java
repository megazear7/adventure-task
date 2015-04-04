package capgroup.adventuretask;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class Creation extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        final Character character = new Character(getApplicationContext());

        final ArrayList<Integer> answers = new ArrayList<Integer>(2);
        answers.add(0, 0);
        answers.add(1, 0);

        final Button q1a = (Button) findViewById(R.id.q1_a);
        final Button q1b = (Button) findViewById(R.id.q1_b);
        final Button q2a = (Button) findViewById(R.id.q2_a);
        final Button q2b = (Button) findViewById(R.id.q2_b);

        q1a.setBackgroundColor(Color.GRAY);
        q1b.setBackgroundColor(Color.GRAY);
        q2a.setBackgroundColor(Color.GRAY);
        q2b.setBackgroundColor(Color.GRAY);

        q1a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answers.set(0, 0);
                q1a.setBackgroundColor(Color.BLUE);
                q1b.setBackgroundColor(Color.GRAY);
            }
        });

        q1b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answers.set(0, 1);
                q1a.setBackgroundColor(Color.GRAY);
                q1b.setBackgroundColor(Color.BLUE);
            }
        });

        q2a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answers.set(1, 0);
                q2a.setBackgroundColor(Color.BLUE);
                q2b.setBackgroundColor(Color.GRAY);
            }
        });

        q2b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answers.set(1, 1);
                q2a.setBackgroundColor(Color.GRAY);
                q2b.setBackgroundColor(Color.BLUE);
            }
        });

        final Button submit = (Button) findViewById(R.id.creation_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int str = 10;
                int intel = 10;
                int cha = 10;
                int sta = 10;

                if (answers.get(0) == 0) {
                    str += 5;
                } else if (answers.get(0) == 1) {
                    intel += 5;
                }
                if (answers.get(1) == 0) {
                    cha += 5;
                } else if (answers.get(1) == 1) {
                    sta += 5;
                }

                character.createNew(str, intel, cha, sta);
                startActivity(new Intent(Creation.this, Stats.class));
            }
        });
    }
}
