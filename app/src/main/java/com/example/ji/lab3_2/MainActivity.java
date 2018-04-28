package com.example.ji.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    RadioGroup radioGroupGender;
    RadioButton radioMan;
    RadioButton radioWoman;
    CheckBox checkSms;
    CheckBox checkEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.register);
        editText = (EditText)findViewById(R.id.editName);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioMan = (RadioButton)findViewById(R.id.radioMan);
        radioWoman = (RadioButton)findViewById(R.id.radioWoman);
        checkSms = (CheckBox)findViewById(R.id.checkSms);
        checkEmail = (CheckBox)findViewById(R.id.checkEmail);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), subActivity.class);
                Bundle myBundle = new Bundle(); //create Bundle to put values in it
                /* name_value1 */
                String name = editText.getText().toString();
                myBundle.putString("name", name);

                /* radio button_value2 */
                int radioId = radioGroupGender.getCheckedRadioButtonId();
                String msg = "";
                if(radioMan.getId() == radioId)
                    msg  = "남";
                if(radioWoman.getId() == radioId)
                    msg = "여";
                myBundle.putString("gender", msg);

                /* check box_value3 */
                String chkMsg = "";
                if(checkSms.isChecked())
                    chkMsg = "SMS";
                if(checkEmail.isChecked())
                    chkMsg = "e-mail";
                myBundle.putString("callBack", chkMsg);

                intent.putExtras(myBundle); //send the values by intent
                startActivity(intent);
            }
        });
    }
}

