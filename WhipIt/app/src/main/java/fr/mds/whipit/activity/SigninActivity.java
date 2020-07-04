package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import com.google.firebase.quickstart.auth.R;
//import com.google.firebase.quickstart.auth.databinding.ActivityEmailpasswordBinding;
import fr.mds.whipit.R;
import fr.mds.whipit.model.User;

public class SigninActivity extends Activity implements View.OnClickListener {

    private EditText editTextName, editTextFirstName, editTextNickname, editTextPhone, editTextEmail, editTextPassword, editTextComfirmPassword;
    //private SeekBar seekbarDistance;
    private Button signinButton;
    private String name, firstname, nickname, email, phone;
    private String password, passwordcomfirm;
    private User user;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private static final String USERS = "users";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editTextName = findViewById(R.id.et_signin_name);
        editTextFirstName = findViewById(R.id.et_signin_firstname);
        editTextNickname = findViewById(R.id.et_signin_nickname);
        editTextEmail = findViewById(R.id.et_signin_email);
        editTextPassword = findViewById(R.id.et_signin_password);
        editTextPhone = findViewById(R.id.et_signin_phone);
        editTextComfirmPassword = findViewById(R.id.et_signin_password_comfirm);
        //seekbarDistance = findViewById(R.id.sb_distance);
        signinButton = findViewById(R.id.bt_modif);
        signinButton.setOnClickListener(this);
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USERS);
        mAuth = FirebaseAuth.getInstance();
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");
        //myRef.setValue("Hello World");
    }

    @Override
    public void onClick(View v) {
        //insert data into firebase database
        if(editTextEmail.getText().toString() != null && editTextPassword.getText().toString() != null) {
            name = editTextName.getText().toString();
            firstname = editTextFirstName.getText().toString();
            nickname = editTextNickname.getText().toString();
            email = editTextEmail.getText().toString();
            phone = editTextPhone.getText().toString();
            password = editTextPassword.getText().toString();
            passwordcomfirm = editTextComfirmPassword.getText().toString();
            user = new User(name, firstname, nickname, phone, email);
            registerUser();
        }
    }

    public void registerUser() {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "createUserWithEmail:success")
                            Toast.makeText(SigninActivity.this, "Authentication success.",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SigninActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }
    public void updateUI(FirebaseUser currentUser) {
        String keyid = mDatabase.push().getKey();
        name = editTextName.getText().toString();
        firstname = editTextFirstName.getText().toString();
        nickname = editTextNickname.getText().toString();
        email = editTextEmail.getText().toString();
        phone = editTextPhone.getText().toString();
        password = editTextPassword.getText().toString();
        passwordcomfirm = editTextComfirmPassword.getText().toString();
        if(!passwordcomfirm.equals(password)){
            Toast.makeText(SigninActivity.this, "Les champs mot de passe et confirmation du mot de passe sont différents",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            User user2 = new User(name, firstname, nickname, phone, email);
            mDatabase.child(keyid).setValue(user2); //adding user info to database
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
        }
    }
}