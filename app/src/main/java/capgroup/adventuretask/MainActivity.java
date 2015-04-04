package capgroup.adventuretask;

import android.app.PendingIntent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.LocationServices;

import java.util.LinkedList;
import java.util.List;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;


public class MainActivity extends BaseActivity implements ConnectionCallbacks, OnConnectionFailedListener {
    PendingIntent mGeofencePendingIntent;
    GoogleApiClient mClient;

    private PendingIntent getGeofencePendingIntent() {
        if (mGeofencePendingIntent != null)
            return mGeofencePendingIntent;
        Intent intent = new Intent(this, GeofenceTransitionsIntentService.class);
        return PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private List<Geofence> getGeofences() {
        List<Geofence> geofences = new LinkedList<Geofence>();
        for (Quest quest : Quest.quests()) {
            geofences.add(new Geofence.Builder()
                    .setRequestId("quest" + quest.id)
                    .setCircularRegion(quest.latitude, quest.longitude, quest.radius)
                    .setExpirationDuration(30 * 60000L)
                    .setLoiteringDelay(1000)
                    .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_DWELL)
                    .build()
            );
        }
        return geofences;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
        mClient.connect();

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

    @Override
    public void onConnected(Bundle connectionHint) {
        LocationServices.GeofencingApi.addGeofences(mClient, getGeofences(), getGeofencePendingIntent());
        Log.d("DEBUG", "Location services API connected!");
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.d("DEBUG", result.toString());
    }
}
