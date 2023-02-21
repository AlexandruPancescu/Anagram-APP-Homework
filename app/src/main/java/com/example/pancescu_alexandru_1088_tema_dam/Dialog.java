package com.example.pancescu_alexandru_1088_tema_dam;

import static android.app.PendingIntent.getActivity;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.dialog.InsetDialogOnTouchListener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Dialog extends AppCompatDialogFragment {

    EditText inputText;
    private DialogListener dialogListener;
    Random random;
    List<String> anagrameFormate = new ArrayList<>();

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view);
        builder.setTitle("Create an anagram");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "canceled", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String input = inputText.getText().toString();
                String output = anagm(input, 0, input.length() - 1);
                dialogListener.applyTexts(input, output);
//                Intent intent = new Intent(getContext(), AnagramActivity.class);
//                intent.putExtra(KEY_INPUT, inputText.getText().toString());
            }
        });

        inputText = view.findViewById(R.id.id_pancescu_alexandru_1088_edit_text);


        return builder.create();
    }

    //generare anagrama prin permutari, stocarea variabilelor intr-un String List
    private String anagm(String str, int start, int end) {
        if (start == end) {
            anagrameFormate.add(str);
        } else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i);
                anagm(str, start + 1, end);
                str = swap(str, start, i);
            }

        }
        random = new Random();
        //lista stocheaza toate combinatiile de litere produse si returneaza un element random
        return anagrameFormate.get(random.nextInt(anagrameFormate.size()));
    }

    //functie permutari
    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            dialogListener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "implementeaza interfata");
        }
    }

    //interfata pentru a transmite date dintr-un layout intr-o activitate
    public interface DialogListener {
        void applyTexts(String input, String output);
    }

    //for( String s : anagrameFormate ){
//          if(isValidWord(s) != ""){
//              //daca cuvantul a fost gasit in lista de cuvinte se iese din Loop
//              result = s;
//              break;
//          }

    private String isValidWord(String s) throws IOException {
        String result = "";

//        //to modify path
//        File file = new File("C:\\Users\\alexp\\Desktop\\Pancescu_Alexandru_1088_Tema_DAM\\app\\src\\main\\assets\\words.txt");
//        Scanner sc = new Scanner(file);
//
//        while (sc.hasNextLine()){
//            if(s.equals(sc.findInLine(s))){
//                result = s;
//                break;
//            }
//        }

        return result;

    }

}



