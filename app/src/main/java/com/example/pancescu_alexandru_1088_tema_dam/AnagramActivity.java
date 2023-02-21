package com.example.pancescu_alexandru_1088_tema_dam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AnagramActivity extends AppCompatActivity implements Dialog.DialogListener {

    Button btn;
    Dialog dialog;
    TextView tvInput, tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anagram_activity);

        btn = findViewById(R.id.id_pancescu_alexandru_1088_btn_create);
        tvInput = findViewById(R.id.id_pancescu_alexandru_1088_txt_input);
        tvOutput = findViewById(R.id.id_pancescu_alexandru_1088_txt_output);

        //afisarea layout-ului de tip AlertDialog la apasarea butonului din activitatea principala
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog();
                dialog.show(getSupportFragmentManager(), "Create an anagram");
            }
        });
    }

    @Override
    public void applyTexts(String input, String output) {
        tvInput.setText(input);
        if (output == "") {
            Toast.makeText(getApplicationContext(), "Text invalid",Toast.LENGTH_SHORT).show();
             // tvOutput.setText("Cuvantul nu are diagrama");
            //Toast.makeText(getApplicationContext(), "Hint: Incearca ORDAINDD", Toast.LENGTH_LONG).show();
        } else tvOutput.setText(output);
    }
}