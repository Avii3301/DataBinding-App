package com.example.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bio.data.Bio;
import com.example.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private EditText enterHobbies;
    private TextView hobbies;
    private final Bio bio=new Bio();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        bio.setName("Avinash Kumar");
        binding.setBio(bio);
        binding.doneButton.setOnClickListener(this::addHobbies);

    }

    public void addHobbies(View view) {
        bio.setHobbies(String.format("Lorem Ipsum text: %s", binding.enterHobbies.getText().toString().trim()));
        //binding.hobbiesText.setText(String.format("Lorem Ipsum text: %s", binding.enterHobbies.getText().toString().trim()));
        binding.invalidateAll();
        binding.hobbiesText.setVisibility(View.VISIBLE);
        //hide Keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}