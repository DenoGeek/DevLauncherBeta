package com.makinduempire.devlauncher.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.makinduempire.devlauncher.R;
import com.makinduempire.devlauncher.utils.BasicControls;
import com.makinduempire.devlauncher.utils.CommandInterpreter;

/**
 * Created by Makindu ExpressC on 12/04/2017.
 */

public class CliFragment extends Fragment {

    private TextView console;
    private EditText input;

    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cli_fragment, container, false);

        console=(TextView)view.findViewById(R.id.console);
        input=(EditText)view.findViewById(R.id.input);

        //set some basic shit
        console.setText(BasicControls.basicCommandFormat("initializing..."));
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    console.append(BasicControls.basicCommandFormat(input.getText().toString()));
                    CommandInterpreter interpreter=new CommandInterpreter(input.getText().toString(),console,getActivity());
                    input.setText("");
                    return true;
                }
                return false;
            }
        });




        return view;

    }




}
