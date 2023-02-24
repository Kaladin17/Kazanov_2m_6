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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText email, password;
    private TextView enter, welcome, message, forget;
    @Override @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        button = findViewById(R.id.button);
        enter = findViewById(R.id.tv_enter);
        welcome = findViewById(R.id.tv_welcome);
        message = findViewById(R.id.tv_message);
        forget = findViewById(R.id.tv_forget);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (email.getText().toString().isEmpty()){
                    button.setBackgroundColor(getColor(R.color.grey));

                } else {
                    password.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        }
                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        }
                        @Override
                        public void afterTextChanged(Editable editable) {
                            if (password.getText().toString().isEmpty()){
                                button.setBackgroundColor(getColor(R.color.grey));
                            } else {
                                button.setBackgroundColor(getColor(R.color.terracot));
                            }
                        }
                    });

                }
            }
        });

        button.setOnClickListener(view -> {
            if (email.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                email.setVisibility(View.INVISIBLE);
                password.setVisibility(View.INVISIBLE);
                button.setVisibility(View.INVISIBLE);
                enter.setVisibility(View.INVISIBLE);
                message.setVisibility(View.INVISIBLE);
                forget.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "Авторизация прошла успешно!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_LONG).show();

            }
        });
    }
}
