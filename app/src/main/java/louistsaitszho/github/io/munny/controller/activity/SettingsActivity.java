package louistsaitszho.github.io.munny.controller.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import louistsaitszho.github.io.munny.R;

public class SettingsActivity extends BaseActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    int getLayout() {
        return R.layout.activity_settings;
    }

    @Override
    protected boolean showBackButton() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
    }
}