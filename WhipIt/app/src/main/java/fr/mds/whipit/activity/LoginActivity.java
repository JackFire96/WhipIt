package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.quickstart.auth.R;
//import com.google.firebase.quickstart.auth.databinding.ActivityEmailpasswordBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import fr.mds.whipit.R;

public class LoginActivity extends Activity implements View.OnClickListener {

    EditText email;
    EditText password;
    Button login;
    TextView noAccount;
    TextView signIn;
    TextView passwordForget;
    TextView becomeBaker;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.et_login_email);
        password = findViewById(R.id.et_login_password);
        login = findViewById(R.id.bt_login);
        noAccount = findViewById(R.id.tv_no_account);
        signIn = findViewById(R.id.bt_signin);
        passwordForget = findViewById(R.id.tv_password_forget);
        becomeBaker = findViewById(R.id.tv_become_baker);
        login.setOnClickListener(this);
        noAccount.setOnClickListener(this);
        signIn.setOnClickListener(this);
        passwordForget.setOnClickListener(this);
        becomeBaker.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


    }
    private void signIn(String email, String password) {
        /*Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }

        showProgressBar();
*/
        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                            // [START_EXCLUDE]
                            //checkForMultiFactorFailure(task.getException());
                            // [END_EXCLUDE]
                        }

                        // [START_EXCLUDE]
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        //hideProgressBar();
                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivityLogged.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "Email ou mot de passe incorrect",
                    Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login :
                    signIn(email.getText().toString(), password.getText().toString());
                break;

            case R.id.tv_no_account:
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.bt_signin:
                 intent = new Intent(LoginActivity.this, SigninActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_password_forget:
                intent = new Intent(LoginActivity.this, PasswordForgetActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_become_baker:
                intent = new Intent(LoginActivity.this, BecomeBakerNoAccountActivity.class);
                startActivity(intent);
                break;
        }


    }
}
