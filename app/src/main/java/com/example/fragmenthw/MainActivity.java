package com.example.fragmenthw;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity implements
        InputFragment.OnInputFragmentInteractionListener{


    DisplayFragment displayFragment;
    FragmentManager fragmentManager;

    private static final String INPUT_FRAG_ONE_TAG = "input_frag_one";
    private static final String OUTPUT_FRAG_ONE_TAG = "output_frag_one";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayFragment = DisplayFragment.newInstance();

        fragmentManager = getSupportFragmentManager();

        fragmentManager
                .beginTransaction()
                .replace(R.id.frgUserInput, InputFragment.newInstance())
                .addToBackStack(INPUT_FRAG_ONE_TAG)
                .commit();

        fragmentManager
                .beginTransaction()
                .replace(R.id.frgDisplayFragment, displayFragment)
                .addToBackStack(OUTPUT_FRAG_ONE_TAG)
                .commit();
    }

    @Override
    public void onInputSendToMain(User infoPassed) {
        displayFragment.setInputOutput(infoPassed);
    }


}
