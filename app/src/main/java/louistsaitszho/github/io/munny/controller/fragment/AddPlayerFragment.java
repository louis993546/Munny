package louistsaitszho.github.io.munny.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import louistsaitszho.github.io.munny.R;
import louistsaitszho.github.io.munny.constant.MonopolyRules;
import louistsaitszho.github.io.munny.controller.adapter.AddPlayerAdapter;
import louistsaitszho.github.io.munny.model.DataHolder;
import louistsaitszho.github.io.munny.model.OnDataReadyListener;
import louistsaitszho.github.io.munny.model.pojo.Player;

/**
 * TODO
 * - All bindView
 * - Adapter for name auto complete
 * - Adapter for players list
 *
 */
public class AddPlayerFragment extends BaseFragment {
    public static final String TAG = AddPlayerFragment.class.getSimpleName();

    @BindView(R.id.edit_text_player)        AutoCompleteTextView    autoCompleteTextViewPlayerInput;
    @BindView(R.id.image_view_plus_button)  ImageView               imageViewAddButton;
    @BindView(R.id.recycler_view_players)   RecyclerView            recyclerViewPlayers;

    AddPlayerAdapter adapter;
    LinearLayoutManager layoutManager;
    DataHolder dataHolder;

    @Override
    int getLayout() {
        return R.layout.fragment_add_player;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //TODO
        adapter = new AddPlayerAdapter();
        recyclerViewPlayers.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewPlayers.setLayoutManager(layoutManager);

        dataHolder = new DataHolder();
        dataHolder.getAllPlayers(new OnDataReadyListener<List<Player>>() {
            @Override
            public void callback(List<Player> results) {
                final List<String> names = new ArrayList<>(results.size());
                for (Player p : results) {
                    names.add(p.getName());
                }
                ArrayAdapter<String> playerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, names);
                autoCompleteTextViewPlayerInput.setAdapter(playerAdapter);
                autoCompleteTextViewPlayerInput.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Log.d(TAG, "onItemClick: " + position);
                        String selection = (String)parent.getItemAtPosition(position);
                        addPlayer(selection);
                        autoCompleteTextViewPlayerInput.setText("");
                    }
                });
            }
        });
    }

    /**
     * TODO
     *
     */
    @OnClick(R.id.image_view_plus_button)
    public void addPlayerButtonClick() {

    }

    /**
     *
     * @param name
     */
    private void addPlayer(String name) {
        if (adapter.getItemCount() < MonopolyRules.MAX_PLAYER)
        adapter.addPlayer(name);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        dataHolder.close();
    }
}
