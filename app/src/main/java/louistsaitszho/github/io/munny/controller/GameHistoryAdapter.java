package louistsaitszho.github.io.munny.controller;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import louistsaitszho.github.io.munny.R;
import louistsaitszho.github.io.munny.model.pojo.Game;

/**
 * Created by Louis on 20/4/2017.
 */
public class GameHistoryAdapter extends RecyclerView.Adapter<GameHistoryAdapter.GamesViewHolder> {
    List<Game> games;

    public GameHistoryAdapter(List<Game> games) {
        this.games = games;
    }

    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GamesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game_history, parent, false));
    }

    @Override
    public void onBindViewHolder(GamesViewHolder holder, int position) {
        Game thisGame = games.get(holder.getAdapterPosition());
        holder.viewPager.setAdapter(new GamePhotoSliderAdapter(thisGame.getPhotos()));
        holder.title.setText(thisGame.getStartTime().toString());
        holder.subtitle.setText(thisGame.getNamesForDisplay());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    class GamesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.photos_viewpager)    ViewPager viewPager;
        @BindView(R.id.title_textview)      TextView title;
        @BindView(R.id.subtitle_textview)   TextView subtitle;

        public GamesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
