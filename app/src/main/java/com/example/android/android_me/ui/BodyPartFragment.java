package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by Heron Sanches on 2018-01-16.
 */

public class BodyPartFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vr = inflater.inflate(R.layout.fragment_body_part, container, false);
        ((ImageView)vr.findViewById(R.id.iv1)).setImageResource(AndroidImageAssets.getHeads().get(0));

        return vr;

    }


}
