package uz.exemple.less7_task3_java;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews() {
        TextInputLayout passwordLayout = findViewById(R.id.tl_password);
        TextInputEditText editTextPassword =findViewById(R.id.et_Password);

        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = s.toString();
                if (password.length()>=8){
                    Pattern pattern = Pattern.compile("[^a-zA-Z0-0]");
                    Matcher matcher = pattern.matcher(password);
                    boolean isPwdContainsSpeChar = matcher.find();
                    if (isPwdContainsSpeChar){
                        passwordLayout.setHelperText("Strong Password");
                        passwordLayout.setError("");
                    }else{
                        passwordLayout.setHelperText("");
                        passwordLayout.setError("Enter minimum 1 special character");
                    }

                }else {
                    passwordLayout.setHelperText("Enter Minimum 8 char");
                    passwordLayout.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        TextInputLayout nameLayout = findViewById(R.id.tl_name);
        TextInputEditText editTextName =findViewById(R.id.et_name);
        editTextName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String text = Objects.requireNonNull(editTextName.getText()).toString();

                if (text.length()<10){
                    nameLayout.setHelperText("NikName must be beautiful");
                }else {
                    nameLayout.setErrorEnabled(true);
                    nameLayout.setError("Please choose shorter NikName");
                }


                //nameLayout.setHelperText("Name must be beautiful");
                return false;
            }
        });


    }

}