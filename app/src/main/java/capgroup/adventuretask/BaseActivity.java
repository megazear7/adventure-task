package capgroup.adventuretask;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class BaseActivity extends ActionBarActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_stats) {
            startActivity(new Intent(BaseActivity.this, Stats.class));
        } else if (id == R.id.action_discoveries) {
            startActivity(new Intent(BaseActivity.this, Discoveries.class));
        } else if (id == R.id.action_quests) {
            startActivity(new Intent(BaseActivity.this, Quests.class));
        } else if (id == R.id.action_level_up) {
            startActivity(new Intent(BaseActivity.this, LevelUp.class));
        } else if (id == R.id.admin) {
            startActivity(new Intent(BaseActivity.this, Admin.class));
        } else if (id == R.id.main) {
        startActivity(new Intent(BaseActivity.this, MainActivity.class));
    }

        return super.onOptionsItemSelected(item);
    }
}
