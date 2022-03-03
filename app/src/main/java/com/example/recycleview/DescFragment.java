package com.example.recycleview;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DescFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DescFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "name";
    private static final String ARG_PARAM2 = "desc";
    private static final int ARG_PARAM3 = -1;

    String itemName, itemDesc;
    int itemImg;

    TextView name, desc;
    ImageView img;


    public DescFragment() {
        // Required empty public constructor
    }

    public static DescFragment newInstance(String name, String desc, int img) {
        DescFragment fragment = new DescFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, name);
        args.putString(ARG_PARAM2, desc);
        args.putInt(String.valueOf(ARG_PARAM3), img);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemName = getArguments().getString(ARG_PARAM1);
        itemDesc = getArguments().getString(ARG_PARAM2);
        itemImg = getArguments().getInt(String.valueOf(ARG_PARAM3));


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_desc, container, false);
        desc = view.findViewById(R.id.itemDesc);
        name = view.findViewById(R.id.itemName);
        img = view.findViewById(R.id.itemImg);
        FloatingActionButton back = view.findViewById(R.id.floatingActionButton);
        desc.setText(itemDesc);
        name.setText(itemName);
        img.setImageResource(itemImg);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sourced from: https://stackoverflow.com/questions/14275627/how-to-go-back-to-previous-fragment-on-pressing-manually-back-button-of-individu
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();
            }
        });
        return view;
    }


}