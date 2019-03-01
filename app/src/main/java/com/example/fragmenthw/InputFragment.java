package com.example.fragmenthw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



public class InputFragment extends Fragment implements View.OnClickListener{

    EditText etName;
    EditText etEmail;
    EditText etPassword;
    Button btnSendEntry;

    private OnInputFragmentInteractionListener mListener;

    public InputFragment() {

    }


    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etName = view.findViewById(R.id.etUserName);
        etEmail = view.findViewById(R.id.etUserEmail);
        etPassword = view.findViewById(R.id.etUserPassword);
        btnSendEntry = view.findViewById(R.id.btnSendToActivity);
        btnSendEntry.setOnClickListener(this);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnInputFragmentInteractionListener) {
            mListener = (OnInputFragmentInteractionListener) context;
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

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();


            User infoPassed = new User(name,email,password);
            mListener.onInputSendToMain(infoPassed);

        }
    }

    public interface OnInputFragmentInteractionListener {

        void onInputSendToMain(User infoPassed);
    }
}
