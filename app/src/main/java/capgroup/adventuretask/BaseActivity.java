package capgroup.adventuretask;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import android.location.Location;


public class BaseActivity extends ActionBarActivity implements
        ConnectionCallbacks, OnConnectionFailedListener {
    GoogleApiClient mClient;
    Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Character.setContext(getApplicationContext());
        mClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();

    }

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

    public void onConnectionSuspended(int status) {

    }

    public void onConnected(Bundle bundle) {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mClient);
        if (mLastLocation != null) {

        }
    }

    public void onConnectionFailed(ConnectionResult result) {

    }
}
