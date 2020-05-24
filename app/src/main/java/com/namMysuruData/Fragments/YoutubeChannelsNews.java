package com.namMysuruData.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.namMysuruData.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class YoutubeChannelsNews extends Fragment {

    public YoutubeChannelsNews() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_youtube_channels_news, container, false);
    }
}
