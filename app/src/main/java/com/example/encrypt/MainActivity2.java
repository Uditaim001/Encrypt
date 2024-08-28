package com.example.encrypt;

import static com.example.encrypt.AES.decrypt;
import static com.example.encrypt.AES.encrypt;
import static com.example.encrypt.AES.generateKey;
import static com.example.encrypt.Base64en.decodeFromBase64;
import static com.example.encrypt.Base64en.encodeToBase64;
import static com.example.encrypt.SHA256NR.SHA256Hash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.crypto.SecretKey;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    TextView textView,textView2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        String plainText = intent != null ? intent.getStringExtra("text") : null;
        int num=intent.getIntExtra("num",0);
        textView=findViewById(R.id.textView3);
        button=findViewById(R.id.button7);
        textView2=findViewById(R.id.textView6);
        try {
            if(num==0){
            SecretKey secretKey = generateKey();
            String encryptedText = encrypt(plainText, secretKey);
            textView.setText(encryptedText);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            try {
                                String decryptedText=decrypt(encryptedText,secretKey);
                                textView2.setText(decryptedText);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }

                    }
                });}
            else if(num==1){
                String encryptedText = encodeToBase64(plainText);
                textView.setText(encryptedText);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String decryptedText=decodeFromBase64(encryptedText);
                            textView2.setText(decryptedText);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                    }
                });
            } else if (num==2) {
                String encryptedText = SHA256Hash(plainText);
                textView.setText(encryptedText);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            textView2.setText("SHA is a one way process ");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                    }
                });
            }

        } catch (Exception e) {
//            throw new RuntimeException(e);
            Toast.makeText(this, "Error occured", Toast.LENGTH_SHORT).show();
        }


    }
}