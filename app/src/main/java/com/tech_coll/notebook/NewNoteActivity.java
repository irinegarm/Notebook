package com.tech_coll.notebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tech_coll.notebook.Note;
import com.tech_coll.notebook.R;

public class NewNoteActivity extends AppCompatActivity {

    static int RESULT_CODE_SUCCESS = 1;
    static int RESULT_CODE_CANCELED = 0;

    Intent i = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_node);

        Toolbar tb = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(tb);

        Button btn = (Button) findViewById(R.id.btnAdd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickAdd();
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CODE_CANCELED, i);
        super.onBackPressed();
    }

    public void clickAdd() {
        EditText etTitle = (EditText) findViewById(R.id.etTitle);
        EditText etContent = (EditText) findViewById(R.id.etContent);

        Note note = new Note(etTitle.getText().toString(), etContent.getText().toString());

        i.putExtra("note", note);
        setResult(RESULT_CODE_SUCCESS, i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_second, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
