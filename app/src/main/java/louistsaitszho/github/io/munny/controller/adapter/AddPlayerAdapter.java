package louistsaitszho.github.io.munny.controller.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import louistsaitszho.github.io.munny.R;
import louistsaitszho.github.io.munny.constant.MonopolyRules;

/**
 * Created by Louis on 14/5/2017.
 */
public class AddPlayerAdapter extends RecyclerView.Adapter<AddPlayerAdapter.PlayerViewHolder>{
    List<String> players;

    public AddPlayerAdapter() {
        players = new ArrayList<>(MonopolyRules.MAX_PLAYER);   //max 8 players
    }

    @Override
    public PlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlayerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_a_player, parent, false));
    }

    @Override
    public void onBindViewHolder(PlayerViewHolder holder, int position) {
        holder.textViewCount.setText(String.valueOf(holder.getAdapterPosition() + 1));              //position starts at 0, but the display needs to start at 1
        holder.textViewName.setText(players.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    /**
     *
     * @param player
     * @return
     */
    public void addPlayer(String player) {
        players.add(player);
        this.notifyItemInserted(players.size()-1);
    }

    class PlayerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_view_counter)       TextView textViewCount;
        @BindView(R.id.text_view_player_name)   TextView textViewName;

        PlayerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
