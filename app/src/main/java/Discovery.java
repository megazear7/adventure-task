import java.util.Date;

import capgroup.adventuretask.Quest;

/**
 * Created by Sam on 4/1/2015.
 */
public class Discovery {
    Date createdAt;
    int questId;

    public Discovery(Date date, int questId) {
        this.createdAt = date;
        this.questId = questId;
    }

    public Quest getQuest() {
        return Quest.quests().get(this.questId);
    }
}
