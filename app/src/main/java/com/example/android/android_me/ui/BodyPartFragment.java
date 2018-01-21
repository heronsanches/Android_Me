package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Heron Sanches on 2018-01-16.
 */

public class BodyPartFragment extends Fragment {

    private List<Integer> imageIdResources;
    private int indexIdResource;
    private static final String IMAGE_ID_RESOURCES = "IMAGE_ID_RESOURCES";
    private static final String INDEX_ID_RESOURCE = "INDEX_ID_RESOURCE";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d("tag_me", getClass().getCanonicalName()+" onCreateView");

        View vr = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView iv = (ImageView)vr.findViewById(R.id.iv1);

        if(savedInstanceState != null){

            imageIdResources = savedInstanceState.getIntegerArrayList(BodyPartFragment.IMAGE_ID_RESOURCES);
            indexIdResource = savedInstanceState.getInt(BodyPartFragment.INDEX_ID_RESOURCE);

        }

        if(imageIdResources != null){

            iv.setImageResource(imageIdResources.get(indexIdResource));
            iv.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                    indexIdResource++;

                    if(indexIdResource == imageIdResources.size())
                        indexIdResource = 0;

                    iv.setImageResource(imageIdResources.get(indexIdResource));

                }


            });

        }

        return vr;

    }


    @Override
    public void onSaveInstanceState(Bundle state) {

        state.putIntegerArrayList(BodyPartFragment.IMAGE_ID_RESOURCES, (ArrayList<Integer>)imageIdResources);
        state.putInt(BodyPartFragment.INDEX_ID_RESOURCE, indexIdResource);

    }


    public void setImageIds(List<Integer> imageIdResources) {
        this.imageIdResources = imageIdResources;
    }

    public void setIndexIdResource(int indexIdResource) {
        this.indexIdResource = indexIdResource;
    }

    
}
