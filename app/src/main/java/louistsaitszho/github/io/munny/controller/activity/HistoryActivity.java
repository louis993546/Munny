package louistsaitszho.github.io.munny.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;

import butterknife.BindView;
import butterknife.OnClick;
import louistsaitszho.github.io.munny.controller.listener.FABReactionListener;
import louistsaitszho.github.io.munny.R;

public class HistoryActivity extends BaseActivity implements FABReactionListener{
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;

    @Override
    int getLayout() {
        return R.layout.activity_history;
    }

    @Override
    protected Integer getMenu() {
        return R.menu.menu_history;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        Intent intent = new Intent(this, NewGameActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(HistoryActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.action_about:
                new LibsBuilder()
                        .withActivityStyle(Libs.ActivityStyle.LIGHT)
                        .withAboutIconShown(true)
                        .withVersionShown(true)
                        .withAboutAppName(getString(R.string.app_name))
                        .withAboutVersionShownCode(true)
                        .withAboutVersionShownName(true)
                        .withActivityTitle(getString(R.string.action_about))
                        .start(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Trigger the fab to hide (e.g. when scrolling)
     */
    @Override
    public void hideFAB() {
        fab.hide();
    }

    /**
     *
     */
    @Override
    public void showFAB() {
        fab.show();
    }
}
