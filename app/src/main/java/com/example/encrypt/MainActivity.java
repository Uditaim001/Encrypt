package com.example.encrypt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button AES,BASE,SHA,DEC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editText=findViewById(R.id.editTextTextMultiLine2);
        AES=findViewById(R.id.button);
        BASE=findViewById(R.id.button2);
        SHA=findViewById(R.id.button3);
        DEC=findViewById(R.id.button4);
        AES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.length()>0){
                    String text;
                    int num;
                    num=0;
                    text=editText.getText().toString();
                    Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("text",text);
                    intent.putExtra("num",num);
                    startActivity(intent);
                }
                else{
//                    String text;
//
//                    Intent intent=new Intent(MainActivity.this, MainActivity2.class);
//                    intent.putExtra("text","Not found");
//                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Please Enter something to encrypt", Toast.LENGTH_SHORT).show();
                }
            }
        });
        BASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.length()>0){
                    String text;
                    int num;
                    num=1;
                    text=editText.getText().toString();
                    Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("text",text);
                    intent.putExtra("num",num);
                    startActivity(intent);
                }
                else{
//                    String text;
//
//                    Intent intent=new Intent(MainActivity.this, MainActivity2.class);
//                    intent.putExtra("text","Not found");
//                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Please Enter something to encrypt", Toast.LENGTH_SHORT).show();
                }

            }
        });
        SHA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.length()>0){
                    String text;
                    int num;
                    num=2;
                    text=editText.getText().toString();
                    Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("text",text);
                    intent.putExtra("num",num);
                    startActivity(intent);
                }
                else{
//                    String text;
//
//                    Intent intent=new Intent(MainActivity.this, MainActivity2.class);
//                    intent.putExtra("text","Not found");
//                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Please Enter something to encrypt", Toast.LENGTH_SHORT).show();
                }
            }
        });
        DEC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent1);
            }
        });

    }
}