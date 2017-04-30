package louistsaitszho.github.io.munny.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import louistsaitszho.github.io.munny.FABReactionListener;
import louistsaitszho.github.io.munny.R;
import louistsaitszho.github.io.munny.controller.GameHistoryAdapter;
import louistsaitszho.github.io.munny.model.DataHolder;
import louistsaitszho.github.io.munny.model.pojo.Game;
import louistsaitszho.github.io.munny.model.pojo.Player;

/**
 * A fragment that contains a list of games (i.e. all i need to do is initial the adapter)
 */
public class HistoryFragment extends BaseFragment {
    @BindView(R.id.recycler_view_games) RecyclerView gamesRV;
    DataHolder dataHolder;

    @Override
    int getLayout() {
        return R.layout.fragment_history;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataHolder = new DataHolder();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TODO Test data
        dataHolder.newGame(new Game(12345, new Player("Louis"), new Player("KC")));

        gamesRV.setAdapter(new GameHistoryAdapter(dataHolder.getAllGames()));
        gamesRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        gamesRV.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                if (getActivity() instanceof FABReactionListener) {
                    if (dy > 0)
                        ((FABReactionListener)getActivity()).hideFAB();
                    else if (dy < 0)
                        ((FABReactionListener)getActivity()).showFAB();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dataHolder.close();
    }
}
