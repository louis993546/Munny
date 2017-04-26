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
     * Return
     * @return R.layout.(something)
     */
    abstract int getLayout();

    /**
     * Return a non-null value to initiate the menu
     * @return R.menu.(something)
     */
    abstract Integer getMenu();

    /**
     *
     * @return
     */
    abstract boolean showBackButton();
}
