package com.e.sharepreferences;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class InputFragment extends Fragment {

    private EditText tbx_name,tbx_address,tbx_email;
    private Button btn_submit;

    private OnFragmentInteractionListener mListener;

    public InputFragment() {
        // Required empty public constructor
    }
    public static InputFragment newInstance(String param1, String param2) {
        InputFragment fragment = new InputFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_input, container, false);
        tbx_name = rootView.findViewById(R.id.tbx_name);
        tbx_address = rootView.findViewById(R.id.tbx_address);
        tbx_email = rootView.findViewById(R.id.tbx_email);
        btn_submit = rootView.findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getBaseContext(),
                        MainActivity.class);
                intent.putExtra("name", tbx_name.getText().toString());
                intent.putExtra("address", tbx_address.getText().toString());
                intent.putExtra("email", tbx_email.getText().toString());
                getActivity().startActivity(intent);
            }
        });
        return rootView;
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
