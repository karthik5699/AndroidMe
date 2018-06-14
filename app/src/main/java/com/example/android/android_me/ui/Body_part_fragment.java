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

public class Body_part_fragment extends Fragment {
    private List<Integer> mImageIds;
    private int mListIndex;
    public static final String IMAGE_IDS = "image_ids";
    public static final String LIST_INDEX = "list_index";


    public Body_part_fragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // If the activity is restarted when phone rotates, it maintains its state
        if(savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_IDS);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }


        View rootview = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = (ImageView) rootview.findViewById(R.id.body_part_image_view);

        if(mImageIds != null){
            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListIndex < mImageIds.size()-1){
                        mListIndex++;
                    }
                    else{
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        }
        else{
            Log.d("TAG", "No imageIDs");
        }




        return rootview;

    }

    public void setmImageIds(List<Integer> imageIds){
        mImageIds = imageIds;
    }

    public void setmListIndex(int index){
        mListIndex = index;
    }
    // To save the state of the app when the screen is rotated, put the variables in the bundle
    @Override
    public void onSaveInstanceState(Bundle currentState){
        currentState.putIntegerArrayList(IMAGE_IDS,(ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);

    }

}
