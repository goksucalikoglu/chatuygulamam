package com.sadchat.yetki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.sadchat.MainActivity;
import com.sadchat.R;
import com.sadchat.databinding.ActivityTelefonKayitBinding;

import java.util.concurrent.TimeUnit;

public class TelefonKayitActivity extends AppCompatActivity {

    private ActivityTelefonKayitBinding binding;

    private static final String TAG="TelefonKayitActivity";

    private FirebaseAuth mYetki;
    private String mDogrulamaId;

    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_telefon_kayit);

        mYetki=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);

        binding.btnDevamEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.btnDevamEt.getText().toString().equals("DEVAM ET"))
                {
                    progressDialog.setMessage("Lütfen Bekleyiniz");
                    progressDialog.show();

                    String telefon="+"+binding.edtUlkekodu.getText().toString()+binding.edtTelefon.getText().toString();
                    telefonlaDogrulamayiBaslat(telefon);
                }
                else
                    {
                        progressDialog.setMessage("Doğrulanıyor");
                        progressDialog.show();

                        telefonNumarasiniKodlaDogrula(mDogrulamaId,binding.edtKod.getText().toString());
                        

                    }

            }
        });
        mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                Log.d(TAG,"dogrulamaTamamlandıgında: Tamamlandı");
                telefonlaYetkiyeGöreGirisYap(phoneAuthCredential);
                progressDialog.dismiss();
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Log.d(TAG,"dogrulamaBasarisizOldugunda:"+e.getMessage());
            }
            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d(TAG, "onCodeSent:" + verificationId);

                // Save verification ID and resending token so we can use them later
                mDogrulamaId = verificationId;
                mResendToken = token;

                binding.btnDevamEt.setText("Doğrula");
            }
        };

    }

    private void telefonNumarasiniKodlaDogrula(String mDogrulamaId, String kod)

    {
        if(kod.isEmpty())
        {
            Toast.makeText(this,"Doğrulama kodunu yazın!!",Toast.LENGTH_LONG).show();

    }
        else{
            PhoneAuthCredential kimlik= PhoneAuthProvider.getCredential(mDogrulamaId, kod);
            telefonlaYetkiyeGöreGirisYap(kimlik);
        }

    }

    private void telefonlaYetkiyeGöreGirisYap(PhoneAuthCredential kimlik) {
        mYetki.signInWithCredential(kimlik)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "Telefonla Kayıt Başarılı");

                            FirebaseUser user = task.getResult().getUser();
                            startActivity(new Intent(TelefonKayitActivity.this, MainActivity.class));
                            // Update UI
                        } else {
                            progressDialog.dismiss();
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "kimlikDoğrulama ile giriş:başarısız", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {

                                Log.d(TAG,"tamamlandı: hata kodu",task.getException());
                                // The verification code entered was invalid
                            }
                        }
                    }
                });
    }


    private void telefonlaDogrulamayiBaslat(String telefon) {

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mYetki)
                .setPhoneNumber(telefon)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(mCallbacks)
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }
}