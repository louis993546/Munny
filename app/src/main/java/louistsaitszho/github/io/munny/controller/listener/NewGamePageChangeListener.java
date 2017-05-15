package louistsaitszho.github.io.munny.controller.listener;

import android.support.v4.view.ViewPager;
import android.util.Log;

import louistsaitszho.github.io.munny.controller.listener.SimpleIntegerListener;

/**
 * Listen to page change so that i can animate the fab accordingly
 * Created by Louis on 25/4/2017.
 */
public class NewGamePageChangeListener implements ViewPager.OnPageChangeListener {
    int oldPosition = 0;    //viewpager originally starts at position 0
    int newPosition = -1;
    SimpleIntegerListener listener;

    public NewGamePageChangeListener(SimpleIntegerListener listener) {
        this.listener = listener;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //empty
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("qqq", "onPageSelected: " + position);
        newPosition = position;
        listener.callback(oldPosition, newPosition);
        oldPosition = newPosition;
        newPosition = -1;       //reset back to unknown
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //empty
    }
}
