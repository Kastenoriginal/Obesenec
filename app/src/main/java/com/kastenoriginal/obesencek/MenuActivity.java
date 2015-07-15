package com.kastenoriginal.obesencek;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MenuActivity extends Activity implements View.OnClickListener{

    Button buttonNewGame;
    Button buttonContinue;
    Button buttonWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu);

        buttonNewGame = (Button) findViewById(R.id.buttonNewGame);
        buttonContinue = (Button) findViewById(R.id.buttonContinue);
        buttonWords = (Button) findViewById(R.id.buttonWords);
        buttonWords.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonNewGame:
                break;
            case R.id.buttonContinue:
                break;
            case R.id.buttonWords:
                Intent intent = new Intent(this, WordsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
