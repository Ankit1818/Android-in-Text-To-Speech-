package com.example.speech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

import static android.speech.tts.TextToSpeech.*;

public class MainActivity extends AppCompatActivity {

    EditText edt1;
    Button btn1;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    edt1=findViewById(R.id.edt1);
    btn1=findViewById(R.id.btn1);
    tts=new TextToSpeech(getApplicationContext(),new OnInitListener() {
        @Override
        public void onInit(int status) {
            if (status!=TextToSpeech.ERROR)
            {
                tts.setLanguage(Locale.ENGLISH);
            }
           

        }
    });
    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tts.speak(edt1.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
        }
    });


    }
}
