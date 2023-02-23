package com.kazanov.kazanov_2m_6;

import androidx.annotation.ColorLong;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    EditText editText1;


    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
        }
        @Override
        public void onTextChanged(CharSequence s, int i, int i1, int i2) {
            String emailInput = editText.getText().toString().trim();
            String passwordInput = editText1.getText().toString().trim();
            if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                button.setBackgroundColor(getColor(R.color.grey));
            }
            else {
                button.setBackgroundColor(getColor(R.color.terracot));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        editText = findViewById(R.id.email);
        editText1 = findViewById(R.id.password);

        editText.addTextChangedListener(loginTextWatcher);
        editText1.addTextChangedListener(loginTextWatcher);

        String emailInput = editText.getText().toString();
        String passwordInput = editText1.getText().toString();

        ConstraintLayout constraintLayout = findViewById(androidx.constraintlayout.widget.R.id.constraint);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailInput == "admin" && passwordInput == "admin") {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрированы!", Toast.LENGTH_LONG).show();
                    constraintLayout.setVisibility(View.INVISIBLE);
                } else {
                    Toast.makeText(MainActivity.this, "Логин или пароль введены неправильно", Toast.LENGTH_LONG).show();
                    constraintLayout.setVisibility(View.VISIBLE);
                }
            }

        });
    }
}
