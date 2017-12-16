package com.example.ansh.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText2;
    private KeyListener originalKeyListener;
    private ImageButton buttonShowIme;
    private boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find out our editable field.
        editText2 = (EditText) findViewById(R.id.edit_text_2);
        // Save its key listener which makes it editable.
        originalKeyListener = editText2.getKeyListener();
        // Set it to null - this will make the field non-editable
        editText2.setKeyListener(null);

        // Find the button which will start editing process.
        buttonShowIme = (ImageButton) findViewById(R.id.button_show_ime);
        // Attach an on-click listener.
        buttonShowIme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(status == true) {
                    // Restore key listener - this will make the field editable again.
                    editText2.setKeyListener(originalKeyListener);
                    // Focus the field.
                    editText2.requestFocus();
                    // Show soft keyboard for the user to enter the value.
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(editText2, InputMethodManager.SHOW_IMPLICIT);

                    status = false;
                }
                else
                {
                    // Hide soft keyboard.
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
                    // Make it non-editable again.
                    editText2.setKeyListener(null);
                    status = true;
                }

            }
        });


    }
}