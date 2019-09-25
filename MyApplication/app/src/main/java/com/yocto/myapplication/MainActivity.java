package com.yocto.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    TextView inputTextView;
    TextView outputLabelTextView;
    TextView outputTextView;

    private void decode_using_android_util_Base64(String input) {
        inputTextView.setText(input);
        outputLabelTextView.setText("Output using android.util.Base64:");

        try {
            byte[] binary = input.getBytes(StandardCharsets.UTF_8);
            byte[] decode = Base64.decode(binary, Base64.NO_WRAP);
            String output = new String(decode, StandardCharsets.UTF_8);
            outputTextView.setText(output);
            outputTextView.setTextColor(Color.BLACK);
        } catch (Exception e) {
            outputTextView.setText(e.toString());
            outputTextView.setTextColor(Color.RED);
        }
    }

    private void decode_using_java_util_Base64(String input) {
        inputTextView.setText(input);
        outputLabelTextView.setText("Output using java.util.Base64:");

        try {
            byte[] binary = input.getBytes(StandardCharsets.UTF_8);
            java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
            byte[] decode = decoder.decode(binary);
            String output = new String(decode, StandardCharsets.UTF_8);
            outputTextView.setText(output);
            outputTextView.setTextColor(Color.BLACK);
        } catch (Exception e) {
            outputTextView.setText(e.toString());
            outputTextView.setTextColor(Color.RED);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        inputTextView = findViewById(R.id.input_text_view);
        outputLabelTextView = findViewById(R.id.output_label_text_view);
        outputTextView = findViewById(R.id.output_text_view);

        findViewById(R.id.decode_button_case_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decode_using_android_util_Base64("キツネが怠惰な犬を飛び越える a quick fox jump over the lazy dog 敏捷的棕色狐狸跨過懶狗 Ein schneller Fuchs springt über den faulen Hund สุนัขจิ้งจอกตัวเตี้ยกระโดดข้ามสุนัขขี้เกียจ быстрый лис перепрыгнуть через ленивую собаку");
            }
        });

        findViewById(R.id.decode_button_case_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decode_using_android_util_Base64("invalid==base64==encode");
            }
        });

        findViewById(R.id.decode_button_case_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decode_using_java_util_Base64("キツネが怠惰な犬を飛び越える a quick fox jump over the lazy dog 敏捷的棕色狐狸跨過懶狗 Ein schneller Fuchs springt über den faulen Hund สุนัขจิ้งจอกตัวเตี้ยกระโดดข้ามสุนัขขี้เกียจ быстрый лис перепрыгнуть через ленивую собаку");
            }
        });

        findViewById(R.id.decode_button_case_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decode_using_java_util_Base64("invalid==base64==encode");
            }
        });
    }
}
