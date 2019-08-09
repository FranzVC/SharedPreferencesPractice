package com.e.sharepreferences;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowDataFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowDataFragment extends Fragment {
    private TextView showReceivedData;

    private OnFragmentInteractionListener mListener;

    public ShowDataFragment() {
    }
    public static ShowDataFragment newInstance(String param1, String param2) {
        ShowDataFragment fragment = new ShowDataFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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
        View rootView = inflater.inflate(R.layout.fragment_show_data, container, false);
        showReceivedData = rootView.findViewById(R.id.tv_data);
        String name = getArguments().getString("name");
        String address = getArguments().getString("address");
        String email = getArguments().getString("email");

        Toast.makeText(getActivity(),name +" "+address+" "+email,Toast.LENGTH_LONG).show();
        String finalString = name +" "+address+" "+email;
        showReceivedData.setText(finalString);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
