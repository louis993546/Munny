package louistsaitszho.github.io.munny.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import louistsaitszho.github.io.munny.controller.fragment.AddPlayerFragment;
import louistsaitszho.github.io.munny.controller.fragment.CashPerPlayerFragment;
import louistsaitszho.github.io.munny.controller.fragment.TotalCashFlowFragment;

/**
 * Created by Louis on 22/4/2017.
 */
public class NewGamePagerAdapter extends FragmentPagerAdapter {

    public NewGamePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AddPlayerFragment();
            case 1:
                return new CashPerPlayerFragment();
            case 2:
            default:
                return new TotalCashFlowFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Players".toUpperCase();
            case 1:
                return "Cash/Player".toUpperCase();
            case 2:
                return "Total Cash Flow".toUpperCase();
            default:
                return "Other".toUpperCase();
        }
    }
}
