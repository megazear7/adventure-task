package capgroup.adventuretask;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingEvent;

import java.util.List;

/**
 * Created by Sam on 4/1/2015.
 */
public class GeofenceTransitionsIntentService extends IntentService {

    public GeofenceTransitionsIntentService() {
        super("GeofenceTransitionsIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        if (geofencingEvent.hasError()) {
            Log.e("ERROR", "Geofence event has error.");
            return;
        }

        int geoFenceTransition = geofencingEvent.getGeofenceTransition();

        if (geoFenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER || geoFenceTransition == Geofence.GEOFENCE_TRANSITION_DWELL) {
            List<Geofence> triggeringGeofences = geofencingEvent.getTriggeringGeofences();

            for (Geofence geofence : triggeringGeofences) {
                // Send notification and log the transition details.
                Quest quest = Quest.quests().get(Integer.parseInt(geofence.getRequestId().replaceAll("\\D+", "")));
                sendNotification("Quest Complete!", "Completed quest \"" + quest.name + "\"");

                // TODO Check date
                if (true) {
                    Character character = Character.getCharacter();
                    character.increaseStrength(quest.strength);
                    character.increaseStamina(quest.endurance);
                    character.increaseIntelligence(quest.intelligence);
                    character.increaseCharisma(quest.charisma);
                    character.addXP(quest.experience);
                }
            }
        }
        else {
            Log.e("ERROR", "Geofence transition error.");
        }
    }

    protected void sendNotification(String s, String details) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.abc_spinner_mtrl_am_alpha)
                .setContentTitle(s)
                .setContentText(details)
                .setAutoCancel(true);
        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        builder.setContentIntent(resultPendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(77, builder.build());
    }
}
