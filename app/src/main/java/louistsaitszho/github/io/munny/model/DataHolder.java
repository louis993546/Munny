package louistsaitszho.github.io.munny.model;

import io.realm.Realm;
import io.realm.RealmResults;
import louistsaitszho.github.io.munny.model.pojo.Game;

/**
 * A singleton class that handles all data storage
 * Right now they will be completely Realm-base
 * Created by Louis on 20/4/2017.
 */
public class DataHolder {
    Realm realm;

    public DataHolder() {
        realm = Realm.getDefaultInstance();
    }

    /**
     * TODO sorting
     */
    public RealmResults<Game> getAllGames() {
        return realm.where(Game.class).findAllSorted("startTime");
    }
}
