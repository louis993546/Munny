package louistsaitszho.github.io.munny.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.NumberPicker;

import butterknife.BindView;
import louistsaitszho.github.io.munny.R;
import louistsaitszho.github.io.munny.controller.listener.SimpleIntRequest;
import louistsaitszho.github.io.munny.controller.listener.SimpleIntegerListener;

/**
 * A simple fragment that contains a picker
 */
public class SinglePickerFragment extends BaseFragment implements SimpleIntRequest{
    public static final String TAG = SinglePickerFragment.class.getSimpleName();
    public static final String KEY_DEFAULT = "default";
    private static final String KEY_STRING_LIST = "string list";

    @BindView(R.id.numberPicker) NumberPicker numberPicker;

    String[] options;
    SimpleIntegerListener listener;

    public SinglePickerFragment() {

    }

    /**
     *
     * @param defaultPosition
     * @param options
     * @return
     */
    public SinglePickerFragment newInstance(int defaultPosition, String... options) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_DEFAULT, defaultPosition);
        bundle.putStringArray(KEY_STRING_LIST, options);
        SinglePickerFragment fragment = new SinglePickerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    int getLayout() {
        return R.layout.fragment_single_picker;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (SimpleIntegerListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement SimpleIntegerListener to get the results back");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //TODO saveInstanceState
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            options = bundle.getStringArray(KEY_STRING_LIST);
            int startingPosition = bundle.getInt(KEY_DEFAULT, 0);
            numberPicker.setDisplayedValues(options);
            numberPicker.setValue(startingPosition);
        }
    }

    /**
     *
     * @return selected position. Whoever create this should already know what is in the list, and
     * they should be able to generate the data they need accordingly.
     */
    @Override
    public int request() {
        return numberPicker.getValue();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
