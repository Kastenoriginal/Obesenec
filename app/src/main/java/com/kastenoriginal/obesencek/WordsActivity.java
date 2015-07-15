package com.kastenoriginal.obesencek;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kastenoriginal.obesencek.db.Db;

public class WordsActivity extends Activity implements View.OnClickListener{

    public static final String TEXTVIEW_KEY = "TEXTVIEW_KEY";

    Button buttonInsert;
    Button buttonShowAll;
    TextView textView;
    EditText newWord;
    Db db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        db = new Db(this);

        buttonInsert = (Button) findViewById(R.id.buttonInsert);
        buttonInsert.setOnClickListener(this);
        buttonShowAll = (Button) findViewById(R.id.buttonShowAll);
        buttonShowAll.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textViewShowWords);

        newWord = (EditText) findViewById(R.id.editTextNewWord);

        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString(TEXTVIEW_KEY));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXTVIEW_KEY, (String) textView.getText());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonInsert:
                if (newWord.getText().toString().length() < 5) {
                    Toast.makeText(getApplicationContext(), "Word is too short", Toast.LENGTH_SHORT).show();
                } else {
                    Word word = new Word(newWord.getText().toString(), String.valueOf(newWord.getText().toString().length()));
                    db.insertWord(word);
                    textView.setText("\nWord " + word.getWordTitle() + " added succesfully and its length is " + newWord.getText().toString().length());
                    newWord.setText(null);
                }
                break;
            case  R.id.buttonShowAll:
                for (Word w : db.getWords()){
                    textView.setText(textView.getText() + "\n" + w.getWordTitle());
                }
                break;
        }
    }
}
