package louistsaitszho.github.io.munny.model.pojo;

import android.support.annotation.NonNull;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * What is a player
 * Usage:
 * - auto-complete names
 * - [Future] statics/player across games
 * Created by Louis on 22/4/2017.
 */
public class Player extends RealmObject {
    @PrimaryKey private String id;
    @Required private String name;

    public Player() {
    }

    /**
     * Constructor when creating new player
     * @param name  must not be null
     */
    public Player(@NonNull String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
