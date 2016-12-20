package com.android.line.Fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import com.android.line.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class Shipping extends Fragment {




    public Shipping() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View view  =   inflater.inflate(R.layout.fragment_shipping, container, false);


        Fragment addNew=new AddNewShippnote();
        android.support.v4.app.FragmentManager fm=getChildFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.addFragment,addNew);
        ft.commit();








        return  view;
    }

}
