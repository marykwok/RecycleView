package com.example.recycleview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RcycFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RcycFragment extends Fragment implements MyAdapter.ItemClickListener{

    public RcycFragment() {
        // Required empty public constructor
    }

    public static RcycFragment newInstance() {
        RcycFragment rcycf = new RcycFragment();
        return rcycf;
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rcyc, container, false);
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view){
        String[] items = getResources().getStringArray(R.array.items);
        String[] desc = getResources().getStringArray(R.array.desc);
        int[] img = {R.drawable.bigmac_combo,  R.drawable.nuggets_combo, R.drawable.mcmuffine_combo};
        RecyclerView rcycv = view.findViewById(R.id.rcycv);
        rcycv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcycv.setAdapter(new MyAdapter(items, desc, img, this));
    }

    @Override
    public void onItemClick (String name, String desc, int img){
        Fragment descf = DescFragment.newInstance(name, desc, img);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("rcyc_fragment"));
        transaction.add(R.id.frame_container, descf);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}