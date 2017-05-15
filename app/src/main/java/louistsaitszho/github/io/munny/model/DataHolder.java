package louistsaitszho.github.io.munny.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmResults;
import louistsaitszho.github.io.munny.controller.listener.ErrorListener;
import louistsaitszho.github.io.munny.controller.listener.SimpleListener;
import louistsaitszho.github.io.munny.model.pojo.Game;
import louistsaitszho.github.io.munny.model.pojo.Player;

/**
 * A class that handles all data storage. Right now they will be completely Realm-base
 *
 * Why not singleton?
 * > 1) realm can work on multiple thread
 * > 2) just gonna cause more trouble
 *
 * Why async? Everything is local anyway.
 * > Just best practice (i.e. in case this needs to move away from local realm storage)
 *
 * Created by Louis on 20/4/2017.
 */
public class DataHolder {
    private Realm realm;
    /**
     * This object is to make sure even when GC the object will not be destroy, by holding on to each of them as a reference
     */
    private List references = new ArrayList();

    public DataHolder() {
        realm = Realm.getDefaultInstance();
    }

    /**
     * Get the whole list of Games, sorted by startTime
     * TODO check if should be ascending or defending
     * @param callback is what it is. Just listen to it and react accordingly
     */
    public void getAllGames(@NonNull final OnDataReadyListener<List<Game>> callback) {
        RealmResults<Game> reference = realm.where(Game.class).findAllSortedAsync("startTime");
        reference.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<Game>>() {
            @Override
            public void onChange(RealmResults<Game> collection, OrderedCollectionChangeSet changeSet) {
                callback.callback(collection);
            }
        });
        references.add(reference);
    }

    /**
     * Get the list of players for
     * - EditText suggestions
     * - [Future] Statistics

     * @param callback
     */
    public void getAllPlayers(@NonNull final OnDataReadyListener<List<Player>> callback) {
        RealmResults<Player> reference = realm.where(Player.class).findAllSortedAsync("name");
        reference.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<Player>>() {
            @Override
            public void onChange(RealmResults<Player> collection, OrderedCollectionChangeSet changeSet) {
                callback.callback(collection);
            }
        });
        references.add(reference);
    }

    /**
     * Create new game
     * @param newGame   is the game object
     * @param onSuccess is a nullable callback when insert is successful
     * @param onError   is a nullable callback when something goes wrong
     */
    public void newGame(@NonNull final Game newGame, @Nullable final SimpleListener onSuccess, @Nullable final ErrorListener onError) {
        references.add(realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insert(newGame);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                if (onSuccess != null)
                    onSuccess.callback();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                if (onError != null)
                    onError.error(error);
            }
        }));
    }

    /**
     * 1) close realm
     * 2) clear all references -> make them available for GC
     *
     * This needs a must for every DataHolder object
     *
     * @return true if nothing goes wrong
     */
    public boolean close() {
        realm.close();
        references.clear();
        references = null;
        return true;
    }
}
