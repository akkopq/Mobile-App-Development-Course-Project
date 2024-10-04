package com.example.proiectamigo;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.Intent;

public class QuizActivity extends AppCompatActivity {
    Button raspA, raspB, raspC, raspD;
    TextView tvScor, tvIntrebare;
    private QuizIntrebari vectIntrebari=new QuizIntrebari();
    private String rasp;
    private int scor = 0;
    private int nrIntrebari=vectIntrebari.vectIntreb.length;
    static int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        raspA=findViewById(R.id.btnRaspA);
        raspB=findViewById(R.id.btnRaspB);
        raspC=findViewById(R.id.btnRaspC);
        raspD=findViewById(R.id.btnRaspD);
        tvIntrebare=findViewById(R.id.tvIntrebareFra);
        tvScor=findViewById(R.id.tvScorFra);
        index=0;
        actIntrebare(index);
        raspA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(raspA.getText().equals(rasp)){
                    scor++;
                    tvScor.setText("Scor: "+scor);
                }
                index++;
                if(index>=vectIntrebari.vectIntreb.length)
                {
                    index = 0;
                    launchMailActivity(scor);
                    afiseazaDialogScor();
                }
                actIntrebare(index);
            }
        });
        raspB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(raspB.getText().equals(rasp)){
                    scor++;
                    tvScor.setText("Scor: "+scor);
                }
                index++;
                if(index>=vectIntrebari.vectIntreb.length)
                {
                    index = 0;
                    launchMailActivity(scor);
                    afiseazaDialogScor();
                }
                actIntrebare(index);
            }
        });
        raspC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(raspC.getText().equals(rasp)){
                    scor++;
                    tvScor.setText("Scor: "+scor);
                }
                index++;
                if(index>=vectIntrebari.vectIntreb.length)
                {
                    index = 0;
                    launchMailActivity(scor);
                    afiseazaDialogScor();
                }
                actIntrebare(index);
            }
        });
        raspD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(raspD.getText().equals(rasp)){
                    scor++;
                    tvScor.setText("Scor: "+scor);
                }
                index++;
                if(index>=vectIntrebari.vectIntreb.length)
                {
                    index = 0;
                    launchMailActivity(scor);
                    afiseazaDialogScor();
                }
                actIntrebare(index);
            }
        });
    }

    private void launchMailActivity(int quizScore) {
        Intent intent = new Intent(QuizActivity.this, MailActivity.class);
        // Pass the quiz score to MailActivity
        intent.putExtra("QUIZ_SCORE", quizScore);
        startActivity(intent);
        finish();
    }


    private void actIntrebare(int i){
        tvIntrebare.setText(vectIntrebari.getIntrebare(i));
        raspA.setText(vectIntrebari.getRaspA(i));
        raspB.setText(vectIntrebari.getRaspB(i));
        raspC.setText(vectIntrebari.getRaspC(i));
        raspD.setText(vectIntrebari.getRaspD(i));
        rasp=vectIntrebari.getRaspCorect(i);
    }
    private void afiseazaDialogScor() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Scorul acumulat: " + scor + "/" + nrIntrebari)
                .setPositiveButton("Next", (dialog, which) -> {
                    Intent intent = new Intent(QuizActivity.this, MailActivity.class);
                    startActivity(intent);
                    finish();
                })
                .setCancelable(false)
                .create()
                .show();
    }
}