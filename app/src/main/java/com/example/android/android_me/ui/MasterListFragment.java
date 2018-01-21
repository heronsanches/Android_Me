package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by Heron Sanches on 2018-01-18.
 */
public class MasterListFragment extends Fragment {

    private OnImageCLickListener onImageCLickListener;


    public interface OnImageCLickListener{
        void onImageSelected(int idList);
    }


    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        try{
            onImageCLickListener = (OnImageCLickListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException("You have to implement the interface OnImageCLickListener.");
        }

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vr = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gv_master = vr.findViewById(R.id.gv_master);
        gv_master.setAdapter(new MasterListAdapter(getActivity(), AndroidImageAssets.getAll()));

        gv_master.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onImageCLickListener.onImageSelected(i);
            }


        });

        return vr;

    }


}
