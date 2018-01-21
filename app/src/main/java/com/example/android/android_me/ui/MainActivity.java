package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.android.android_me.R;

/**
 * Created by Heron Sanches on 2018-01-18.
 */

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageCLickListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void onImageSelected(int idList) {
        Toast.makeText(this, "Image number "+idList+" was clicked!", Toast.LENGTH_SHORT).show();
    }


}
