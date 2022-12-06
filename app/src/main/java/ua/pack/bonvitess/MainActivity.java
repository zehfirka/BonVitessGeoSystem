package ua.pack.bonvitess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Intent;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup chooseGroup = findViewById(R.id.radioGroup);
        RadioButton radioOne = findViewById(R.id.radioButton);
        RadioButton radioTwo = findViewById(R.id.radioButton2);
        RadioButton radioThree = findViewById(R.id.radioButton3);
        EditText startEdit = findViewById(R.id.editTextStart);
        EditText finishEdit = findViewById(R.id.editTextFinish);
        chooseGroup.clearCheck();


        chooseGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (radioOne.isChecked()) {
                    startEdit.setHint("Початкова зупинка");
                    finishEdit.setHint("Кінцева зупинка");
                    finishEdit.setVisibility(View.VISIBLE);
                    startEdit.setVisibility(View.VISIBLE);
                    finishEdit.setEnabled(true);
                    startEdit.setEnabled(true);

                }
                else if (radioTwo.isChecked()) {
                    startEdit.setHint("Початкова точка");
                    finishEdit.setHint("Кінцева точка");
                    finishEdit.setVisibility(View.VISIBLE);
                    startEdit.setVisibility(View.VISIBLE);
                    finishEdit.setEnabled(true);
                    startEdit.setEnabled(true);
                }
                else if (radioThree.isChecked()) {
                    finishEdit.setEnabled(false);
                    startEdit.setEnabled(false);
                    finishEdit.setVisibility(View.INVISIBLE);
                    startEdit.setVisibility(View.INVISIBLE);
                    startEdit.setHint("Номер маршруту");
                }
            }
        });
    }

    public void mOnButtonClick(View view) {
        String key = "AIzaSyD1q8wcNP-qK4XtN2PydpoTuqIxRskE3tM";
        Intent intClick = new Intent(this, DisplayResultActivity.class);
        startActivity(intClick);

    }

    public void OnSettingsButtonClick(View view) {
        Intent intSettings = new Intent(this, AppSettingsActivity.class);
        startActivity(intSettings);

    }
}

