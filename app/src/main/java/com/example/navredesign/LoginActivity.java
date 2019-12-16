package com.example.navredesign;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;

public class LoginActivity extends Activity {

    EditText _username;
    EditText _passwordText;
    Button _loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_login);
        _passwordText =  findViewById(R.id.etPassword);
        _username = findViewById(R.id.etUserName);
        _loginButton = findViewById(R.id.btnLogin);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.open_sans);
        _passwordText.setTypeface(typeface);
        _passwordText.setTransformationMethod(new PasswordTransformationMethod());
//        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.app_title);

    }

    public void onLoginClick(View View) {
        if(login()){
            Intent mainContentIntent = new Intent(this, MainContentActivity.class);
            startActivity(mainContentIntent);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            ActivityOptions options =
                    ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out);
            startActivity(mainContentIntent, options.toBundle());
        }


    }


    public boolean login() {

        if (!validate()) {
            onLoginFailed();
            return false;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.Theme_AppCompat_Dialog_Alert);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = _username.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.
        if(!password.contentEquals("test")){
            onLoginFailed();
            return false;
        }


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
        return true;
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String username = _username.getText().toString();
        String password = _passwordText.getText().toString();

        if (username.isEmpty() ) {
//            if (username.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            _username.setError("Username cannot be empty");
//            _username.setError(Html.fromHtml("<font color='blue' background-color='white' ba>Username cannot be empty</font>"));
//            int ecolor = R.color.pcmsPrmryLight; // whatever color you want
//            String estring = "Username cannot be empty";
//            ForegroundColorSpan fgcspan = new ForegroundColorSpan(getResources().getColor(R.color.pcmsPrmryLight));
//            SpannableStringBuilder ssbuilder = new SpannableStringBuilder(estring);
//            ssbuilder.setSpan(fgcspan, 0, estring.length(), 0);

//            _username.requestFocus();
//            _username.setError(ssbuilder);
            valid = false;
        } else {
            _username.setError(null);
        }

        if (password.isEmpty()) {
//            _passwordText.setError(Html.fromHtml("Password cannot be empty"));
            _passwordText.setError("Password cannot be empty");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }


}

