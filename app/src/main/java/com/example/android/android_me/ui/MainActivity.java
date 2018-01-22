package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by Heron Sanches on 2018-01-18.
 */
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageCLickListener{

    private int headId;
    private int bodyId;
    private int legId;
    private Button btnNext;

    //twoPane layout to tablets
    private boolean twoPane;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = findViewById(R.id.btn_next);

        if(findViewById(R.id.ll_android_me) != null){

            twoPane = true;
            btnNext.setVisibility(View.GONE);
            GridView gv_master = findViewById(R.id.gv_master);
            gv_master.setNumColumns(2);

            if(savedInstanceState == null){

                FragmentManager fm = getSupportFragmentManager();
                Bundle b = getIntent().getExtras();

                BodyPartFragment head = new BodyPartFragment();
                head.setImageIds(AndroidImageAssets.getHeads());

                BodyPartFragment body = new BodyPartFragment();
                body.setImageIds(AndroidImageAssets.getBodies());

                BodyPartFragment leg = new BodyPartFragment();
                leg.setImageIds(AndroidImageAssets.getLegs());

                fm.beginTransaction()
                        .add(R.id.fl_head, head, head.getClass().getCanonicalName())
                        .commit();

                fm.beginTransaction()
                        .add(R.id.fl_body, body, body.getClass().getCanonicalName())
                        .commit();

                fm.beginTransaction()
                        .add(R.id.fl_leg, leg, leg.getClass().getCanonicalName())
                        .commit();

            }

        }else{

            twoPane = false;

            btnNext.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {

                    Bundle b = new Bundle();
                    b.putInt("headId", headId);
                    b.putInt("bodyId", bodyId);
                    b.putInt("legId", legId);

                    startActivity(new Intent(MainActivity.this, AndroidMeActivity.class)
                            .putExtras(b));

                }


            });

        }



    }


    @Override
    public void onImageSelected(int idList) {

        Toast.makeText(this, "Image number "+idList+" was clicked!", Toast.LENGTH_SHORT).show();
        int bodyPartNumber = idList / 12;
        int indexPartBody = idList - 12*bodyPartNumber;

        if(twoPane){

            BodyPartFragment bpf = new BodyPartFragment();

            switch (bodyPartNumber){

                case 0: //head

                    bpf.setImageIds(AndroidImageAssets.getHeads());
                    bpf.setIndexIdResource(indexPartBody);
                    getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_head, bpf)
                        .commit();

                break;

                case 1: //body

                    bpf.setImageIds(AndroidImageAssets.getBodies());
                    bpf.setIndexIdResource(indexPartBody);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_body, bpf)
                            .commit();

                break;

                case 2: //leg

                    bpf.setImageIds(AndroidImageAssets.getLegs());
                    bpf.setIndexIdResource(indexPartBody);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_leg, bpf)
                            .commit();

                break;

            }

        }else{

            switch (bodyPartNumber){

                case 0: //head
                    headId = indexPartBody;
                    break;

                case 1: //body
                    bodyId = indexPartBody;
                    break;

                case 2: //leg
                    legId = indexPartBody;
                    break;

            }

        }

    }


}
