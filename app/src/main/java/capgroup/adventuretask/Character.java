package capgroup.adventuretask;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by alex on 3/1/2015.
 */
public class Character {

    private String name;
    private int strength;
    private int intelligence;
    private int charisma;
    private int stamina;
    private int xp;
    private int currentLevel;
    private int attributeBoostPoints;
    //private List<Discovery>
    private File characterFile;

    private static Context context;

    /**
     * Expect the character object to be created on disc before making a character
     */
    public Character(Context context) {
        // This creates the character json file if it doesn't exist
        File externalStorageDir = Environment.getExternalStorageDirectory();
        characterFile = new File(context.getApplicationInfo().dataDir , "character.txt");
        Character.context = context;

        if(characterFile.exists()) {
            try {
                FileInputStream fIn = new FileInputStream(characterFile);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fIn));

                name = reader.readLine();
                strength = Integer.parseInt(reader.readLine());
                intelligence = Integer.parseInt(reader.readLine());
                charisma = Integer.parseInt(reader.readLine());
                stamina = Integer.parseInt(reader.readLine());
                xp = Integer.parseInt(reader.readLine());
                currentLevel = Integer.parseInt(reader.readLine());
                attributeBoostPoints = Integer.parseInt(reader.readLine());

                reader.close();
                fIn.close();
            } catch(Exception e) {

            }
        }
        else {
            createNew(10, 10, 10, 10);
        }

        updateStats();
    }

    private int xpToLevel(int xp) {
        return ((int)Math.ceil(xp/100)) + 1;
    }

    public int xpToNextLevel() {
        return (100 - (this.xp % 100));
    }

    public int xpFromLastLevel() {
        return this.xp % 100;
    }

    /**
     * This is the level that should be shown to the user. This is based on the xp.
     * @return the characters actual level.
     */
    public int getActualLevel() {
        return xpToLevel(xp);
    }

    public void addXP(int amount) {
        xp += amount;
        updateFile();
    }

    public void increaseLevel(){
        // TODO make sure that currentLevel does not increase past what this.xp should allow based
        // on the xp/level table
        while(getActualLevel()>currentLevel)
        {
            currentLevel++;
            increaseAttributeBoostPoints(3);
        }
        updateFile();

    }

    public int getXp() {
        return xp;
    }

    /**
     * This returns the current level of the character. That is, they might have enough xp to be
     * level 8, but if they have not yet leveled up then there current level will be 7 still. The
     * user should always be displayed their actual level, not their current level. This is used
     * so that we can determine if the user has leveled up yet or not, and how many levels they
     * need to level up before they catch back up with their xp.
     *
     * After leveling up, the player is awarded 3 Attribute Boost Points. These points can be used
     * on the level up screen to permanently increase 3 points of their choosing.
     * Could be all 3 in STR, or 1 in STR and 2 in INT. Etc.
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getAttributeBoostPoints() {
        return attributeBoostPoints;
    }

    public void increaseAttributeBoostPoints(int attributeBoostPoints) {
        this.attributeBoostPoints += attributeBoostPoints;
        updateFile();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateFile();
    }

    public int getStrength(){
        return this.strength;
    }

    public void increaseStrength(int strength) {
        this.strength += strength;
        updateFile();
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void increaseIntelligence(int intelligence) {
        this.intelligence += intelligence;
        updateFile();
    }

    public int getCharisma() {
        return charisma;
    }

    public void increaseCharisma(int charisma) {
        this.charisma += charisma;
        updateFile();
    }

    public int getStamina() {
        return stamina;
    }

    public void increaseStamina(int stamina) {
        this.stamina += stamina;
        updateFile();
    }

    /**
     * This overrides the character json file with the stats given. Resetting the name, xp, current
     * level, and attribute boost points.
     * @param str   the new characters strength
     * @param intel the new character intelligence
     * @param cha   the new characters charisma
     * @param sta   the new characters stamina
     */
    public void createNew(int str, int intel, int cha, int sta) {
        this.name = "New Character";
        this.strength = str;
        this.intelligence = intel;
        this.charisma = cha;
        this.stamina = sta;
        this.xp = 1;
        this.currentLevel = 1;
        this.attributeBoostPoints = 0;

        updateFile();
    }

    /**
     * This will update this character objects stats based on what is in the character file.
     */
    private void updateStats() {
        try {
            FileInputStream fIn = new FileInputStream(characterFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fIn));

            /* Read from the file in the expected order. */
            name = reader.readLine();
            strength = Integer.parseInt(reader.readLine());
            intelligence = Integer.parseInt(reader.readLine());
            charisma = Integer.parseInt(reader.readLine());
            stamina = Integer.parseInt(reader.readLine());
            xp = Integer.parseInt(reader.readLine());
            currentLevel = Integer.parseInt(reader.readLine());
            attributeBoostPoints = Integer.parseInt(reader.readLine());

            reader.close();
            fIn.close();
        } catch(Exception e) {

        }
    }

    /**
     * This will update the character json file with this character objects current stats.
     */
    private void updateFile() {
        try {
            FileOutputStream fOut = new FileOutputStream(characterFile);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fOut));

            /* Write the stats in the expected order. */
            writer.write(this.name);
            writer.newLine();
            writer.write(Integer.toString(this.strength));
            writer.newLine();
            writer.write(Integer.toString(this.intelligence));
            writer.newLine();
            writer.write(Integer.toString(this.charisma));
            writer.newLine();
            writer.write(Integer.toString(this.stamina));
            writer.newLine();
            writer.write(Integer.toString(this.xp));
            writer.newLine();
            writer.write(Integer.toString(this.currentLevel));
            writer.newLine();
            writer.write(Integer.toString(this.attributeBoostPoints));

            writer.close();
            fOut.close();
        } catch (Exception e) {

        }
    }

    /**
     * This requires either that a character has already been made or the setContext method has been
     * used so that the apps data directory can be found.
     * @return
     */
    public static Character getCharacter() {
        return new Character(context);
    }

    public static void setContext(Context context) {
        Character.context = context;
    }

}
