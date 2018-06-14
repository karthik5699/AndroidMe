package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class Master_list_fragment extends Fragment {

    OnImageClickListener mCallback;

    public Master_list_fragment(){

    }

    // For Master_list_fragment and body_part_fragment to communicate, an interface is created which needs to be implemented by host
    // activity because fragments cannot talk to each other directly

    public interface OnImageClickListener{
        void onImageSelected(int position);

    }

    @Override
    public void onAttach(Context context){
        // this is the method where the fragment attaches to the host activity
        super.onAttach(context);


        // to make sure the host activity has implemented the callback interface
        try{
            mCallback = (OnImageClickListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+" OnImageClickListener not implemented");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.fragment_master_list);

        MasterListAdapter masterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(masterListAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallback.onImageSelected(position);
            }
        });


        return rootView;

    }
}
