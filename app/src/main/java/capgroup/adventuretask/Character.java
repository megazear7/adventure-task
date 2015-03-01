package capgroup.adventuretask;

/**
 * Created by alex-windows on 3/1/2015.
 */
public class Character {

    private String name;
    private int strength;
    private int intelligence;
    private int charisma;
    private int stamina;
    private int xp;
    private int currentLevel;

    /**
     * Expect the character object to be created on disc before making a character
     */
    public Character() {
        // TODO build character from the json object located on disc.
        name = "Sample Character";
        strength = 10;
        intelligence = 10;
        charisma = 10;
        stamina = 10;
        xp = 0;
        currentLevel = 1;
    }

    private int xpToLevel(int xp) {
        // TODO if someone would like to make a logarithmic level scale go ahead.
        // right now 100 xp equates to 1 level. Level 2 is gained at 100 xp.
        return (int)Math.ceil(xp/100);
    }

    /**
     * This is the level that should be shown to the user. This is based on the xp.
     * @return the characters actual level.
     */
    public int actualLevel() {
        return xpToLevel(xp);
    }

    public void addXP(int amount) {
        xp += amount;
    }

    public void increaseLevel(){
        // TODO make sure that currentLevel does not increase past what this.xp should allow based
        // on the xp/level table
        currentLevel++;
    }

    public int getXp() {
        return xp;
    }

    /**
     * This returns the current level of the character. That is, they might have enough xp to be
     * level 8, but if they have not yet leveled up then there current level will be 7 still. The
     * user should always be displayed there actualy level, not there current level. This is used
     * so that we can determine if the user has leveled up yet or not, and how many levels they
     * need to level up before they cathch back up with there xp.
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength(){
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }



}
