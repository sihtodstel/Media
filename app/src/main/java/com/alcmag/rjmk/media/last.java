package com.alcmag.rjmk.media;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class last extends AppCompatActivity {
            private EditText mltext;
            private Button mbutt;
   // private String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        mltext = (EditText) findViewById(R.id.emlText);
        mbutt = (Button) findViewById(R.id.sbutton);
        mbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mltext.getText().toString().equals("")) {
                    String message = mltext.getText().toString();
                    writeToFile(message);
                }
                else{

                }
            }
        });
        if (readFromFile() != null) {
            mltext.setText(readFromFile());
        }
    }

        private void writeToFile(String message) {
            try {
                OutputStreamWriter osw=new OutputStreamWriter(openFileOutput("todo.txt", Context.MODE_PRIVATE));
                osw.write(message);
                osw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        private String readFromFile(){
            String result = "";
            try {
                InputStream istream= openFileInput("todo.txt");
                if(istream!=null) {
                    InputStreamReader isr=new InputStreamReader(istream);
                    BufferedReader breader= new BufferedReader(isr);
                    String tstring="";
                    StringBuilder sbuiler=new StringBuilder();
                    while ((tstring=breader.readLine())!=null){
                        sbuiler.append(tstring);

                    }
                    istream.close();
                    result=sbuiler.toString();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }
    }


