package louistsaitszho.github.io.munny.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import louistsaitszho.github.io.munny.R;

/**
 * That fragment that contains a recycler view that shows all the settings stuff
 */
public class SettingsFragment extends BaseFragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    int getLayout() {
        return R.layout.fragment_settings;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //TODO everything
    }
}
