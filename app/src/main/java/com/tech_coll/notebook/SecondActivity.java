package com.tech_coll.notebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.tech_coll.notebook.Note;
import com.tech_coll.notebook.R;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        Toolbar tb = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(tb);

        TextView tvContent = (TextView) findViewById(R.id.Content);
        Intent i = getIntent();
        Note note = (Note) i.getSerializableExtra("note");

        //Toolbar tb = (Toolbar) findViewById(R.id.tb);
        TextView tvTitle = (TextView) tb.findViewById(R.id.tvToolbar);
        tvContent.setText(note.getContent());
        tvTitle.setText(note.getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_second, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
