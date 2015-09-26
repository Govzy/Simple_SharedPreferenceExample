
package com.kingbell.simple_sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText userName, password;
    TextView userNameText, passwordText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.userEdit);
        password = (EditText) findViewById(R.id.passwordEdit);
        userNameText = (TextView) findViewById(R.id.userText);
        passwordText = (TextView) findViewById(R.id.passwordText);
         sharedPreferences = getSharedPreferences("myData",Context.MODE_PRIVATE);
    }


    public void savePreference(View view) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name",userName.getText().toString());
        editor.putString("Password",password.getText().toString());
        editor.commit();
    }

    public void loadPreferences(View view) {

        userNameText.setText(sharedPreferences.getString("Name","NA"));
        passwordText.setText(sharedPreferences.getString("Password","NA"));
    }
}
