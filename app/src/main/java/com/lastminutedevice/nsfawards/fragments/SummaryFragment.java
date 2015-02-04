package com.lastminutedevice.nsfawards.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lastminutedevice.nsfawards.R;

public class SummaryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        return inflater.inflate(R.layout.fragment_summary, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // todo: request
        ((TextView) view.findViewById(R.id.summary_year)).setText("to date in 2015");
        ((TextView) view.findViewById(R.id.summary_description)).setText("the National Science Foundation has awarded");
        ((TextView) view.findViewById(R.id.summary_total)).setText("$2,306,248");
    }
}
