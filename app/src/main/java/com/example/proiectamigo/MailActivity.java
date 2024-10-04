package com.example.proiectamigo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MailActivity extends AppCompatActivity {

    EditText etName, etPhoneNumber;
    Button btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        etName = findViewById(R.id.editTextName);
        etPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        btnSendEmail = findViewById(R.id.buttonSendEmail);

        int quizScore = getIntent().getIntExtra("QUIZ_SCORE", 0);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String phoneNumber = etPhoneNumber.getText().toString().trim();
                sendEmail(name, phoneNumber, quizScore);
            }
        });
    }


    private void sendEmail(String name, String phoneNumber, int quizScore) {
        String emailSubject = "Quiz Score Submission";
        String emailBody = "Name: " + name + "\nPhone Number: " + phoneNumber + "\nQuiz Score: " + quizScore;

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"amigo@contest.ro"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(emailIntent, "Send Email"));
        } else {
        }
    }

}

