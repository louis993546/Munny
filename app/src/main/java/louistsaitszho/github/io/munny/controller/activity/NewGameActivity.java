package louistsaitszho.github.io.munny.controller.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;

import butterknife.BindView;
import butterknife.OnClick;
import louistsaitszho.github.io.munny.NewGamePageChangeListener;
import louistsaitszho.github.io.munny.NewGamePagerAdapter;
import louistsaitszho.github.io.munny.R;
import louistsaitszho.github.io.munny.SimpleIntegerListener;

public class NewGameActivity extends BaseActivity {
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.container) ViewPager viewPager;
    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.fab) FloatingActionButton fab;

    int[] iconIntArray = {R.drawable.ic_arrow_forward_white_24dp, R.drawable.ic_arrow_forward_white_24dp, R.drawable.ic_arrow_forward_white_24dp, R.drawable.ic_check_white_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        //TODO back button

        viewPager.setAdapter(new NewGamePagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new NewGamePageChangeListener(new SimpleIntegerListener() {
            @Override
            public void onResponse(int... results) {
                animateFab(results[0], results[1]);
            }
        }));
    }

    @Override
    int getLayout() {
        return R.layout.activity_new_game;
    }

    @Override
    Integer getMenu() {
        return R.menu.menu_new_game;
    }

    @Override
    boolean showBackButton() {
        return true;
    }

    /**
     * TODO dialog when press toolbar home button
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * TODO dialog when press
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        switch (viewPager.getCurrentItem()) {
            case 0:
            case 1:
            case 2:
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                break;
            case 3:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();
                break;
        }
    }

    /**
     * Animate fab if the icon changes
     * @param oldPosition
     * @param newPosition
     */
    protected void animateFab(int oldPosition, final int newPosition) {
        if (iconIntArray[oldPosition] != iconIntArray[newPosition]) {
            fab.clearAnimation();
            ScaleAnimation shrink = new ScaleAnimation(1f, 0.2f, 1f, 0.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            shrink.setDuration(150);
            shrink.setInterpolator(new DecelerateInterpolator());
            shrink.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    //empty
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    fab.setImageResource(iconIntArray[newPosition]);

                    ScaleAnimation expand =  new ScaleAnimation(0.2f, 1f, 0.2f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    expand.setDuration(100);
                    expand.setInterpolator(new AccelerateInterpolator());
                    fab.startAnimation(expand);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    //empty
                }
            });
            fab.startAnimation(shrink);
        }
    }
}