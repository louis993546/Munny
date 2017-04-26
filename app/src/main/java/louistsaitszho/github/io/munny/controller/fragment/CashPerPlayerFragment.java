package louistsaitszho.github.io.munny.controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import louistsaitszho.github.io.munny.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CashPerPlayerFragment extends BaseFragment {

    public CashPerPlayerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    int getLayout() {
        return R.layout.fragment_cash_per_player;
    }

}
