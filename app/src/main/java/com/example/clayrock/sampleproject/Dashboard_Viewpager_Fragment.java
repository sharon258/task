package com.example.clayrock.sampleproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by root on 15/2/17.
 */

public class Dashboard_Viewpager_Fragment extends Fragment {

    private static ArrayList<Integer> list = new ArrayList<Integer>() {{
        add(R.drawable.download);
        add(R.drawable.music);
        add(R.drawable.download);
    }};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.view_pager_dashboard, container, false);
        ImageView image = (ImageView) rootView.findViewById(R.id.draw);
        Bundle bundle = this.getArguments();
        image.setImageResource(list.get(bundle.getInt("NUM", 0)));

        return rootView;
    }
}
