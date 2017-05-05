package louistsaitszho.github.io.munny.controller;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Louis on 2/5/2017.
 */
public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.BaseViewHolder>{

    public SettingsAdapter() {
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game_history, parent, false));
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * The base one includes:
     * 1) Icon              -> so you can change it
     * 2) Title             -> so you can change it
     * 3) Subtitle          -> so you can change it
     * 4) The whole item    -> so you can set onclick for it
     */
    class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(View itemView) {
            super(itemView);
        }
    }

    /*
     * TODO for the future:
      * - VH with toggle
      * - VH with menu (3 dots)?
      * - VH with setting (gear)?
      * - and more?
     */
}
