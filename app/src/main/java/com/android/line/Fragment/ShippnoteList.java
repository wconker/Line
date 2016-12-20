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
public class ShippnoteList extends Fragment {


    public ShippnoteList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.fragment_shippnote_list, container, false);
        return view;
    }

}
