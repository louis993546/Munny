package louistsaitszho.github.io.munny.controller.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Every fragment should extend this
 * Roles:
 * - ButterKnife.bind
 *
 * Where should i put all the codes?
 * > onViewCreated
 */
public abstract class BaseFragment extends Fragment {

    /**
     * ButterKnife bind views
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    /**
     * Override this to set the layout of a fragment
     * @return
     */
    abstract int getLayout();
}
