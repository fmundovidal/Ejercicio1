package com.example.a5alumno.ejercicio1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName(); //Se crea para debugear, devuelve un nombre sencillo

    private TextView dispInfo_TextView;
    private String retInfoString;

    public static final int ACTIVITY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button startAct_Btn = (Button) this.findViewById(R.id.button_btm);
            startAct_Btn.setOnClickListener(this);

        this.dispInfo_TextView = (TextView) this.findViewById(R.id.textField);

        final Button info_btn = (Button) this.findViewById(R.id.button_top);
            info_btn.setOnClickListener(this);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        //Toast.makeText(this, "Main Act onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        //Toast.makeText(this, "Main Act onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        //Toast.makeText(this, "Main Act onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        //Toast.makeText(this, "Main Act onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        //Toast.makeText(this, "Main Act onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        //Toast.makeText(this, "Main Act onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.button_btm) {
            Intent myIntent = new Intent(getApplicationContext(), Activity2.class);

            this.startActivityForResult(myIntent,MainActivity.ACTIVITY_REQUEST_CODE);
        }

        else if(view.getId()==R.id.button_top){
            if(retInfoString!=null && !retInfoString.isEmpty())
                dispInfo_TextView.setText(retInfoString);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == MainActivity.ACTIVITY_REQUEST_CODE){
            if(data!=null)
                this.retInfoString = data.getStringExtra("returnString");
        }

    }
}
