package louistsaitszho.github.io.munny.model.pojo;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Louis on 22/4/2017.
 */
public class Transaction extends RealmObject {
    @PrimaryKey private String id;
    private String fromId;
    private String toId;
    private int amount;

    public Transaction() {
        this.id = UUID.randomUUID().toString();
    }

    public Transaction(String fromId, String toId, int amount) {
        this();
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", fromId='" + fromId + '\'' +
                ", toId='" + toId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
