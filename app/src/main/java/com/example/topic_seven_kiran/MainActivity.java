package com.example.topic_seven_kiran;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {
    EditText etWord,etMeaning;
    Button btnAddWord;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etWord=findViewById(R.id.etWord);
        etMeaning=findViewById(R.id.etMeaning);
        btnAddWord=findViewById(R.id.btnAddWord);
        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }
    private void save(){
        try {
            PrintStream printStream = new PrintStream(openFileOutput("Words.txt",MODE_PRIVATE|MODE_APPEND));
            printStream.println(etWord.getText().toString()+"->"+etMeaning.getText().toString());
            Toast.makeText(this,"Saved to"+getFilesDir(),Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Log.d("Dictionary app","Error"+e.toString());
            e.printStackTrace();}}}
