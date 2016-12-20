package com.android.line.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.line.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewShippnote extends Fragment {


    public AddNewShippnote() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
   View view =inflater.inflate(R.layout.fragment_add_new_shippnote, container, false);
        return  view;
    }

}
