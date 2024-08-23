package com.example.encrypt;

import static com.example.encrypt.AES.encrypt;
import static com.example.encrypt.AES.generateKey;
import static com.example.encrypt.Base64en.encodeToBase64;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.crypto.SecretKey;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
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
        try {
            if(num==0){
            SecretKey secretKey = generateKey();
            String encryptedText = encrypt(plainText, secretKey);
            textView.setText(encryptedText);}
            if(num==1){
                String encryptedText = encodeToBase64(plainText);
                textView.setText(encryptedText);
            }
        } catch (Exception e) {
//            throw new RuntimeException(e);
            Toast.makeText(this, "Error occured", Toast.LENGTH_SHORT).show();
        }

    }
}