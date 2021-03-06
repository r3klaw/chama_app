package com.example.valentine.chamaconnect;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    @InjectView(R.id.input_name)
    EditText _nameText;
    @InjectView(R.id.phone) EditText _phone;
    @InjectView(R.id.certificate) EditText _certificate;
    @InjectView(R.id.agreementdoc) EditText _agreement;
    @InjectView(R.id.constitution) EditText _constitution;
    @InjectView(R.id.btn_signup) Button _signupButton;
    @InjectView(R.id.btn_cert) Button _certButton;
    @InjectView(R.id.btn_agdoc) Button _agdocButton;
    @InjectView(R.id.btn_const) Button _constButton;
    @InjectView(R.id.link_login)
    TextView _loginLink;
//    EditText certificate;
//    EditText _agreement;
   Context mContext = SignupActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.inject(this);


        _certButton.setOnClickListener(new View.OnClickListener() {
            String mChosenDir;

            @Override
            public void onClick(View v) {
                SimpleFileChooserDialog myDialog = new SimpleFileChooserDialog(mContext, SimpleFileChooserDialog.FILE_SAVE, new SimpleFileChooserDialog.SimpleFileDialogListener() {
                    @Override
                    public void onPositiveButton(String chosenDir) {
                        _certificate.setText(chosenDir);
                        Toast.makeText(mContext, "Path to save file: " + chosenDir, Toast.LENGTH_LONG).show();
                    }
                });
                ArrayList<String> myExts = new ArrayList<>();
                myExts.add(".jpg");
                myExts.add(".jpeg");
                myExts.add(".png");
                myDialog.mAllowedFileExtsList = myExts;
                myDialog.chooseFile_or_Dir();
            }
        });

       _agdocButton.setOnClickListener(new View.OnClickListener() {
            String mChosenDir;

            @Override
            public void onClick(View v) {
                SimpleFileChooserDialog myDialog = new SimpleFileChooserDialog(SignupActivity.this, SimpleFileChooserDialog.FOLDER_SELECT, new SimpleFileChooserDialog.SimpleFileDialogListener() {
                    @Override
                    public void onPositiveButton(String chosenDir) {
                       _agreement.setText(chosenDir);
                        Toast.makeText(mContext, "ChosenDir: " + chosenDir, Toast.LENGTH_SHORT).show();
                    }
                });
                myDialog.chooseFile_or_Dir();
            }
        });

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



    public void signup() {
        Log.d(TAG, "Signup");

//        if (!validate()) {
//            onSignupFailed();
//            return;
//        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String phone = _phone.getText().toString();
        String certificate = _certificate.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

//    public boolean validate() {
//        boolean valid = true;
//
//        String name = _nameText.getText().toString();
//        String phone = _phone.getText().toString();
//        String certificate = _certificate.getText().toString();
//
//        if (name.isEmpty() || name.length() < 3) {
//            _nameText.setError("at least 3 characters");
//            valid = false;
//        } else {
//            _nameText.setError(null);
//        }
//
//        if (phone.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(phone).matches()) {
//            _phone.setError("enter a valid email address");
//            valid = false;
//        } else {
//            _phone.setError(null);
//        }
//
//        if (certificate.isEmpty() || certificate.length() < 4 || certificate.length() > 10) {
//            _certificate.setError("between 4 and 10 alphanumeric characters");
//            valid = false;
//        } else {
//            _certificate.setError(null);
//        }
//
//        return valid;
//
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
