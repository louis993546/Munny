package louistsaitszho.github.io.munny.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.List;

import butterknife.BindView;
import louistsaitszho.github.io.munny.R;
import louistsaitszho.github.io.munny.controller.adapter.GameHistoryAdapter;
import louistsaitszho.github.io.munny.controller.listener.FABReactionListener;
import louistsaitszho.github.io.munny.controller.listener.SimpleListener;
import louistsaitszho.github.io.munny.model.DataHolder;
import louistsaitszho.github.io.munny.model.OnDataReadyListener;
import louistsaitszho.github.io.munny.model.pojo.Game;
import louistsaitszho.github.io.munny.model.pojo.Player;

/**
 * A fragment that contains a list of games (i.e. all i need to do is initial the adapter)
 *
 * TODO progress bar when loading the data
 */
public class HistoryFragment extends BaseFragment {
    public final static String TAG = HistoryFragment.class.getSimpleName();

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

        //TODO Test data insert
        Lorem lorem = LoremIpsum.getInstance();
        dataHolder.newGame(new Game(
                12345,
                new Player(lorem.getNameMale()),
                new Player(lorem.getNameMale()),
                new Player(lorem.getName()),
                new Player(lorem.getName()),
                new Player(lorem.getNameFemale()),
                new Player(lorem.getNameFemale())
        ), new SimpleListener() {
            @Override
            public void callback() {                                                                //onSuccess
                dataHolder.getAllGames(new OnDataReadyListener<List<Game>>() {
                    @Override
                    public void callback(List<Game> games) {
                        gamesRV.setAdapter(new GameHistoryAdapter(getActivity(), games));
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                        gamesRV.setLayoutManager(layoutManager);
                        DividerItemDecoration decoration = new DividerItemDecoration(gamesRV.getContext(), layoutManager.getOrientation());
                        //TODO figure out how to make a 8dp divider instead of the line divider
                        gamesRV.addItemDecoration(decoration);
                    }
                });

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
        }, null);                                                                                   //onFailure is null
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dataHolder.close();
    }
}
