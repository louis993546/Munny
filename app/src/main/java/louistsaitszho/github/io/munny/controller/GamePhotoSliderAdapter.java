package louistsaitszho.github.io.munny.controller;

import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

import louistsaitszho.github.io.munny.model.pojo.Photo;

/**
 * Created by Louis on 22/4/2017.
 */

public class GamePhotoSliderAdapter extends PagerAdapter {
    List<Photo> photos;

    public GamePhotoSliderAdapter(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
