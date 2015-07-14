package com.kastenoriginal.obesencek;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

public class MainActivity extends Activity {

    public static final String TEXT_KEY = "TEXT_KEY";
    public static final String EDIT_TEXT_KEY = "EDIT_TEXT_KEY";

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
        buttonShowAll = (Button) findViewById(R.id.buttonShowAll);

        textView = (TextView) findViewById(R.id.textViewShowWords);

        newWord = (EditText) findViewById(R.id.editTextNewWord);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newWord.getText() == null) {
                    Toast.makeText(buttonInsert.getContext(), "No Words found", Toast.LENGTH_SHORT);
                } else {
                    textView.setText(newWord.getText().toString());
//                    Word word = new Word(newWord.getText().toString(), String.valueOf(newWord.getText().length()));
//                    db.insertWord(word);
//                    textView.setText(textView.getText() + "\nWord" + newWord.getText() + "added succesfully");
                }
            }
        });

        buttonShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "\n" + db.getWords());
            }
        });

        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString(TEXT_KEY));
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

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_KEY, (String) textView.getText());
//        outState.putString();
    }
}
