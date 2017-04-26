package louistsaitszho.github.io.munny.controller.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import louistsaitszho.github.io.munny.R;
import louistsaitszho.github.io.munny.controller.GameHistoryAdapter;
import louistsaitszho.github.io.munny.model.DataHolder;

/**
 * A fragment that contains a list of games (i.e. all i need to do is initial the adapter)
 */
public class HistoryFragment extends BaseFragment {
    @BindView(R.id.recycler_view_games) RecyclerView gamesRV;

    @Override
    int getLayout() {
        return R.layout.fragment_history;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        gamesRV.setAdapter(new GameHistoryAdapter(new DataHolder().getAllGames()));
        gamesRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return view;
    }
}
