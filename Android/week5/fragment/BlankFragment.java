package com.example.zan.fragment;

import android.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class BlankFragment extends Fragment {

    ImageView image;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        return inflater.inflate(

                R.layout.fragment_blank2, container, false);

    }
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        // TODO Auto-generated method stub
//        //here you can initialise your variables,listeners,e.t.c ;
//        super.onActivityCreated(savedInstanceState);
//
//        ImageView imageview = (ImageView)findViewById(R.id.imageView);
//        addListenerOnButton();
//    }
//
//    /**
//     * You can use this method in order to access the child views of the fragment parent view;
//     * @param id
//     * @return
//     */
//    protected View findViewById(int id)
//    {
//        return getView().findViewById(id);
//    }
//
//    public void addListenerOnButton() {
//
//
//        Button button = (Button) findViewById(R.id.button1);
//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                image.setImageResource(R.drawable.swan8);
//            }
//
//        });
//
//    }
}
