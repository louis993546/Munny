package louistsaitszho.github.io.munny.controller.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import butterknife.ButterKnife;

/**
 * Bases of all activities
 * roles:
 * 1) ButterKnife
 * 2) toolbar back button
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
    }

    /**
     * Enable back button if requested
     * Why not in onCreate: because I need to wait for each activity setSupportActionBar first
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (showBackButton() && getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    /**
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getMenu() != null) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(getMenu(), menu);
            return super.onCreateOptionsMenu(menu);
        } else
            return false;   //i.e. menu will not be display
    }

    /**
     * Tell BaseActivity how to inflate the view
     * @return R.layout.(something)
     */
    abstract int getLayout();

    /**
     * Tell BaseActivity does it need to inflate menu and how
     * @return R.menu.(something) or null(which is the default)
     */
    protected Integer getMenu(){
        return null;
    }

    /**
     * Tell BaseActivity do you want to show the back button on toolbar. Default is false
     * @return true if show, false if not
     */
    protected boolean showBackButton() {
        return false;
    }
}
