package louistsaitszho.github.io.groupphotoplaceholder;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;

/**
 * TODO
 * Created by Louis on 6/5/2017.
 */
public class GroupPhotoPlaceholder extends ShapeDrawable{

    public class Builder {

        public Builder() {

        }

        public Builder width() {
            return this;
        }

        public Builder height() {
            return this;
        }

        public Builder figures(int amount) {
            return this;
        }

        public Builder backgroundColor(String colorCode) {
            return this;
        }

        public Builder figuresColor(String colorCode) {
            return this;
        }

        public Builder figuresColor(Color color) {
            return this;
        }

        public GroupPhotoPlaceholder build() {
            return null;
        }
    }

}
