package com.example.shruti.bookcrow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.widget.Toast.LENGTH_LONG;


public class SignUp extends AppCompatActivity {

    private static final String TAG = "SignupActivity";

    @Bind(R.id.name) EditText nameText;
    @Bind(R.id.address) EditText addressText;
    @Bind(R.id.email) EditText emailText;
    @Bind(R.id.mobile) EditText mobileText;
    @Bind(R.id.password) EditText passwordText;
    @Bind(R.id.reEnterPassword) EditText reEnterPasswordText;
    @Bind(R.id.signup) Button signupButton;
    @Bind(R.id.gotologin) TextView loginLink;
    DataBaseOperations db;
    String name;
    String address;
    String email;
    String mobile ;
    String password ;
    String reEnterPassword ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        db=new DataBaseOperations(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Login Page", LENGTH_LONG).show();
                // Finish the registration screen and return to the Login activity
//                Intent intent = new Intent(this,LoginIn.class);
//                startActivity(intent);
                finish();
               // overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        signupButton.setEnabled(false);


         name = nameText.getText().toString();
         address = addressText.getText().toString();
         email = emailText.getText().toString();
         mobile = mobileText.getText().toString();
         password = passwordText.getText().toString();
         reEnterPassword = reEnterPasswordText.getText().toString();

        onSignupSuccess();

    }


    public void onSignupSuccess() {
        signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        LogIn.user=((EditText)findViewById(R.id.name)).getText().toString();
        LogIn.password=((EditText)findViewById(R.id.password)).getText().toString();
        db.insert(new DataBaseOperations(this),name,password);
        new Thread(){
            @Override
            public void run() {

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finally {
                    startActivity(new Intent(SignUp.this,Categories.class));
                }
            }
        }.start();

    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", LENGTH_LONG).show();

        signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = nameText.getText().toString();
        String address = addressText.getText().toString();
        String email = emailText.getText().toString();
        String mobile = mobileText.getText().toString();
        String password = passwordText.getText().toString();
        String reEnterPassword = reEnterPasswordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            nameText.setError("at least 3 characters");
            valid = false;
        } else {
            nameText.setError(null);
        }

        if (address.isEmpty()) {
            addressText.setError("Enter Valid Address");
            valid = false;

        } else {
            addressText.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (mobile.isEmpty() || mobile.length()!=10) {
            mobileText.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            mobileText.setError(null);
        }

        if (password.isEmpty() || password.length() < 8 || password.length() > 15) {
            passwordText.setError("between 8 and 15 alphanumeric characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 8 || reEnterPassword.length() > 15 || !(reEnterPassword.equals(password))) {
            reEnterPasswordText.setError("Password Do not match");
            valid = false;
        } else {
            reEnterPasswordText.setError(null);
        }

        return valid;
    }
}
