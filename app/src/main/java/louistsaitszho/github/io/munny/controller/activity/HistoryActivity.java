package louistsaitszho.github.io.munny.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import louistsaitszho.github.io.munny.R;

public class HistoryActivity extends BaseActivity {
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    int getLayout() {
        return R.layout.activity_history;
    }

    @Override
    Integer getMenu() {
        return R.menu.menu_history;
    }

    @Override
    boolean showBackButton() {
        return false;
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
}
