package com.lastminutedevice.nsfawards.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.lastminutedevice.nsfawards.NSFAwardsApplication;
import com.lastminutedevice.nsfawards.R;
import com.lastminutedevice.nsfawards.adapters.SearchResultsAdapter;
import com.lastminutedevice.nsfawards.models.Award;
import com.lastminutedevice.nsfawards.models.AwardsResponse;

import java.util.List;

/**
 * Displays a list of search results.
 */
public class SearchFragment extends Fragment {
    private final SearchResultsAdapter adapter = new SearchResultsAdapter();
    private final String searchUrl = "http://api.nsf.gov/services/v1/awards.json?keyword=";
    private View emptyView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.results_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        emptyView = view.findViewById(R.id.empty_message);
    }

    /**
     * Run a search.
     *
     * @param query the keyword to search by
     */
    public void runSearch(String query) {
        StringRequest request = new StringRequest(searchUrl + query, listener, errorListener);
        NSFAwardsApplication.getInstance().getRequestQueue().add(request);
    }

    private Response.Listener<String> listener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            if (getView() != null) {
                AwardsResponse awardsResponse = new Gson().fromJson(response, AwardsResponse.class);
                List<Award> awards = awardsResponse.getResponse().getAward();
                if (awards.size() > 0) {
                    emptyView.setVisibility(View.GONE);
                    adapter.setResults(awards);
                    getView().findViewById(R.id.results_list).invalidate();
                } else {
                   emptyView.setVisibility(View.VISIBLE);
                }
            }
        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getActivity(), "API ERROR", Toast.LENGTH_SHORT).show(); // opportunity for snackbar?
        }
    };
}
