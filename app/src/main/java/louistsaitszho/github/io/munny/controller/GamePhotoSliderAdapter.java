package louistsaitszho.github.io.munny.controller;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import louistsaitszho.github.io.munny.R;
import louistsaitszho.github.io.munny.model.pojo.Photo;

/**
 * Created by Louis on 22/4/2017.
 */
public class GamePhotoSliderAdapter extends PagerAdapter {
    List<Photo> photos;
    LayoutInflater layoutInflater;

    @BindView(R.id.a_photo_iv) ImageView aPhoto;

    public GamePhotoSliderAdapter(Context context, List<Photo> photos) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.item_a_photo, container, false);
        ButterKnife.bind(this, itemView);
        //TODO aPhoto.set something
        container.addView(itemView);
        return itemView;
    }
}
