package louistsaitszho.github.io.munny.controller.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import louistsaitszho.github.io.munny.controller.fragment.AddPlayerFragment;
import louistsaitszho.github.io.munny.controller.fragment.CashPerPlayerFragment;
import louistsaitszho.github.io.munny.controller.fragment.TotalCashFlowFragment;
import louistsaitszho.github.io.munny.controller.listener.SimpleIntRequest;

/**
 * TODO a constructor that receives a list of things that is required to initiate each fragment
 * TODO a series of listeners/callbacks to get values from each fragment
 * Created by Louis on 22/4/2017.
 */
public class NewGamePagerAdapter extends FragmentPagerAdapter {
    public static final String TAG = NewGamePagerAdapter.class.getSimpleName();
    SimpleIntRequest cashPerPlayerRequest;

    /**
     *
     * @param fm
     */
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
                return "Players";
            case 1:
                return "Cash/Player";
            case 2:
                return "Total Cash Flow";
            default:
                return "Other";
        }
    }
}
