/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if(savedInstanceState == null) {

            // Create a body_part_fragment for the head of the android
            Body_part_fragment head_fragment = new Body_part_fragment();
            // Assign the imageIDs to the list of image ids created in the AndroidImageAssets class
            head_fragment.setmImageIds(AndroidImageAssets.getHeads());
            int head_index = getIntent().getIntExtra("headIndex", 0);
            head_fragment.setmListIndex(head_index);

            Body_part_fragment body_fragment = new Body_part_fragment();
            body_fragment.setmImageIds(AndroidImageAssets.getBodies());
            int body_index = getIntent().getIntExtra("bodyIndex", 0);
            body_fragment.setmListIndex(body_index);

            Body_part_fragment leg_fragment = new Body_part_fragment();
            leg_fragment.setmImageIds(AndroidImageAssets.getLegs());
            int leg_index = getIntent().getIntExtra("legIndex", 0);
            leg_fragment.setmListIndex(leg_index);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, head_fragment)
                    .add(R.id.body_container, body_fragment)
                    .add(R.id.leg_container, leg_fragment)
                    .commit();
        }


    }
}
