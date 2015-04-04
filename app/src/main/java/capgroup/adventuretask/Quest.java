package capgroup.adventuretask;

import android.location.Location;

import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 4/1/2015.
 */
public class Quest {
    int experience;
    int strength;
    int endurance;
    int intelligence;
    int charisma;
    int id;
    double latitude, longitude;
    float radius;
    String name;

    public Quest(String name, int experience, int strength, int endurance, int intelligence,
                 int charisma, double latitude, double longitude, float radius) {
        this.name = name;
        this.experience = experience;
        this.strength = strength;
        this.endurance = endurance;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public String toString() {
        return name + "\n XP+" + experience + "STR+" + strength + " END+" + endurance + " INT+" + intelligence + " CHA+"
                + charisma;
    }

    private static List<Quest> quests;

    public static List<Quest> quests() {
        if (quests == null)
            initializeQuests();
        return quests;
    }

    private static void initializeQuests() {
        quests = new ArrayList<Quest>(10);
        quests.add(new Quest(new String("Dreese Labs"), 5, 0, 0, 2, 0, 40.002322, -83.016016, 20));
        quests.add(new Quest(new String("Caldwell Labs"), 3, 0, 3, 0, 0, 40.002405, -83.015003, 25));
        quests.add(new Quest(new String("Ohio Union"), 10, 1, 0, 0, 5, 39.998192, -83.008644, 40));
        quests.add(new Quest(new String("RPAC"), 6, 7, 3, 0, 1, 39.999702, -83.017881, 45));
        quests.add(new Quest(new String("Thompson Library"), 8, 0, 2, 9, 0, 39.999305, -83.014845, 30));
        quests.add(new Quest(new String("Library Formerly Known As SEL"), 5, 0, 0, 7, 2, 40.001666, -83.013364, 20));

        for (int i = 0; i < quests.size(); i++) {
            quests.get(i).id = i;
        }
    }

    public static Quest findQuestByLocation(double latitude, double longitude) {
        for (Quest quest : quests) {
            if (quest.latitude == latitude && quest.longitude == longitude) {
                return quest;
            }
        }
        return null;
    }

    public static String getPrintableQuests() {
        StringBuilder result = new StringBuilder("");
        for (Quest quest : quests()) {
            result.append(quest.toString() + "\n\n");
        }
        return result.toString();
    }
}
