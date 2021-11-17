package com.example.android_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int mode = 0;
    public void OMG(View view){
        EditText editText = findViewById(R.id.editTextTextPersonName);
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);

        try {
            float temperature = Float.parseFloat(editText.getText().toString());
            if(!editText.getText().toString().contains("f")&&!editText.getText().toString().contains("F")){
                if (mode == 0){
                    textView.setText("華氏溫度:");
                    textView2.setText("°F");
                    temperature = temperature*9/5+32;
                    editText.setText(""+(float)(Math.round(temperature*100))/100);
                    mode = 1;
                }
                else{
                    textView.setText("攝氏溫度:");
                    textView2.setText("°C");
                    temperature = (temperature-32)/9*5;
                    editText.setText(""+(float)(Math.round(temperature*100))/100);
                    mode = 0;
                }
            }
            else {
                Toast.makeText(this, "請輸入數字", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e){
            Toast.makeText(this, "請輸入數字", Toast.LENGTH_LONG).show();
        }
    }

}