package com.lastminutedevice.nsfawards.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lastminutedevice.nsfawards.R;
import com.lastminutedevice.nsfawards.models.Award;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Adapter for search results.
 */
public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.ResultsHolder> {
    private final static NumberFormat dollarFormat = DecimalFormat.getCurrencyInstance(Locale.US);
    private List<Award> awards;

    public SearchResultsAdapter(List<Award> awards) {
        this.awards = awards;
    }

    @Override
    public void onBindViewHolder(SearchResultsAdapter.ResultsHolder viewHolder, int position) {
        Award award = awards.get(position);
        viewHolder.textAmount.setText(dollarFormat.format(award.getFundsObligatedAmt()));
        viewHolder.textAwardee.setText(award.getAwardeeName());
        viewHolder.textDate.setText(award.getDate());
        viewHolder.textDescription.setText(award.getTitle());
    }

    @Override
    public int getItemCount() {
        return awards == null ? 0 : awards.size();
    }

    @Override
    public SearchResultsAdapter.ResultsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_search_results, viewGroup, false);
        ResultsHolder resultsHolder = new ResultsHolder(view);
        resultsHolder.textAmount = (TextView) view.findViewById(R.id.text_amount);
        resultsHolder.textAwardee = (TextView) view.findViewById(R.id.text_awardee);
        resultsHolder.textDate = (TextView) view.findViewById(R.id.text_date);
        resultsHolder.textDescription = (TextView) view.findViewById(R.id.text_description);
        return resultsHolder;
    }

    public class ResultsHolder extends RecyclerView.ViewHolder {
        public TextView textAmount;
        public TextView textDate;
        public TextView textAwardee;
        public TextView textDescription;

        public ResultsHolder(View view) {
            super(view);
        }
    }
}
