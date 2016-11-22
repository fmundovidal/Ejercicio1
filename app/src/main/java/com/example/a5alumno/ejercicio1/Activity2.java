package com.example.a5alumno.ejercicio1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity implements View.OnClickListener{

    private EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        this.mEdit = (EditText) this.findViewById(R.id.textWritten);
        final Button button_ok = (Button) this.findViewById(R.id.ok_button);
            button_ok.setOnClickListener(this);

    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.ok_button) {
            if (this.mEdit != null) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("returnString", this.mEdit.getText().toString());
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        }
    }
}
