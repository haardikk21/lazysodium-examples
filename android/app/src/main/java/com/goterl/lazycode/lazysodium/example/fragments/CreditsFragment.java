package com.goterl.lazycode.lazysodium.example.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.goterl.lazycode.lazysodium.example.R;
import com.goterl.lazycode.lazysodium.example.activities.*;
import com.goterl.lazycode.lazysodium.example.adapters.MultiAdapter;
import com.goterl.lazycode.lazysodium.example.models.Operation;

import java.util.ArrayList;
import java.util.List;

public class CreditsFragment extends BaseFragment {

    private MultiAdapter adapter;

    public static CreditsFragment newInstance() {
        CreditsFragment fragment = new CreditsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_operations, container, false);
        overlay = v.findViewById(R.id.overlay);

        adapter = new MultiAdapter(getActivity(), getListOfCredits(), true);
        adapter.setClickListener(new MultiAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position == 0) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/terl/lazysodium-android"));
                    startActivity(browserIntent);
                }
                if (position == 1) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jedisct1/libsodium"));
                    startActivity(browserIntent);
                }
                if (position == 2) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https:/terl.co"));
                    startActivity(browserIntent);
                }
                if (position == 3) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://icons8.com/icon/set/about/material"));
                    startActivity(browserIntent);
                }
            }
        });
        createRecycler(v);

        return v;
    }

    private void createRecycler(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);
    }

    private List<Operation> getListOfCredits() {
        List<Operation> creditsList = new ArrayList<>();
        Operation credit0 = new Operation(
                "Lazysodium",
                "Visit the Lazysodium project page."
        );
        Operation credit1 = new Operation(
                "Libsodium",
                "Many thanks to the Libsodium project which provides a great C library for wrapping around."
        );
        Operation credit2 = new Operation(
                "Terl",
                "We're the creators of Lazysodium. You should check out our other apps and services!"
        );

        Operation credit3 = new Operation(
                "Icons8",
                "Various icons were used from Icons8."
        );

        creditsList.add(credit0);
        creditsList.add(credit1);
        creditsList.add(credit2);
        creditsList.add(credit3);
        return creditsList;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (overlay.getVisibility() == View.VISIBLE) {
            overlay.setVisibility(View.GONE);
        }
    }
}