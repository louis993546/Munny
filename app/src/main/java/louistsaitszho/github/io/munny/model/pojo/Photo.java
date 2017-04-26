package louistsaitszho.github.io.munny.model.pojo;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Louis on 22/4/2017.
 */
public class Photo extends RealmObject {
    @PrimaryKey private String id;
    @Required private String name;

    public Photo() {
        this.id = UUID.randomUUID().toString();
    }

    public Photo(String name) {
        this();
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
        return "Photo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
