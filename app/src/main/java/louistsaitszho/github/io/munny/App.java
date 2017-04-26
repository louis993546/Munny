package louistsaitszho.github.io.munny;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Just for initializing stuff:
 * - Realm
 * - Crash report?
 * - Others?
 *
 * Created by Louis on 20/4/2017.
 */
public class App extends Application {
    private final static String realmFileName = "munny.realm";

    @Override
    public void onCreate() {
        super.onCreate();
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .name(realmFileName)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
