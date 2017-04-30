package louistsaitszho.github.io.munny.model;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmResults;
import louistsaitszho.github.io.munny.model.pojo.Game;
import louistsaitszho.github.io.munny.model.pojo.Player;

/**
 * TODO check if singleton is a good thing on android
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
     *
     * @return
     */
    public RealmResults<Game> getAllGames() {
        return realm.where(Game.class).findAllSorted("startTime");
    }

    /**
     * Get the list of players for
     * - EditText suggestions
     * - [Future] Statistics
     * @return
     */
    public RealmResults<Player> getAllPlayers() {
        return realm.where(Player.class).findAllSorted("name");
    }

    /**
     * Create new game
     * @param newGame: make sure it contains
     */
    public RealmAsyncTask newGame(final Game newGame) {
        return realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insert(newGame);
            }
        });
    }

    /**
     * To close realm
     */
    public void close() {
        realm.close();
    }
}
