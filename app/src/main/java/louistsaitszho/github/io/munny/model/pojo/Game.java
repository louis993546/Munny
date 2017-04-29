package louistsaitszho.github.io.munny.model.pojo;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Louis on 20/4/2017.
 */
public class Game extends RealmObject {
    @PrimaryKey private String id;
    private Date startTime;
    private int duration;                           //seconds
    private RealmList<Player> players;
    private int bankTotal;                          //0 -> infinite
    private RealmList<Photo> photos;
    private RealmList<Transaction> transactions;

    public Game() {
        this.id = UUID.randomUUID().toString();
        this.startTime = new Date();                //TODO does this return current time?
    }

    /**
     * The constructor for creating new Game instance
     * @param bankTotal
     * @param players
     */
    public Game(int bankTotal, Player... players) {
        this();
        this.bankTotal = bankTotal;
        this.players = new RealmList<>();
        Collections.addAll(this.players, players);
    }

    public RealmList<Photo> getPhotos() {
        return photos;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void addPhoto(Photo photo) {
        if (photos == null)
            this.photos = new RealmList<>();
        this.photos.add(photo);
    }

    /**
     * @return
     */
    public String getNamesForDisplay() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Player> iterator = players.iterator();
        if (iterator.hasNext()) {
            stringBuilder.append(iterator.next().getName());
        }
        while (iterator.hasNext()) {
            stringBuilder.append(", ").append(iterator.next().getName());
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", startTime=" + startTime +
                ", duration=" + duration +
                ", players=" + players +
                ", bankTotal=" + bankTotal +
                ", photos=" + photos +
                ", transactions=" + transactions +
                '}';
    }
}