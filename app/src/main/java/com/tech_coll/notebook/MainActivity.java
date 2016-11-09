package com.tech_coll.notebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tech_coll.notebook.ResyclerView.MyAdapter;
import com.tech_coll.notebook.ResyclerView.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener {

    int REQUEST_CODE_GET_NOTE = 0;
    private RecyclerView rvNotes;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;

    private List<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeData();

        Toolbar tb = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(tb);

        rvNotes = (RecyclerView) findViewById(R.id.rvNotes);
        rvNotes.setHasFixedSize(true);

        rvLayoutManager = new LinearLayoutManager(this);
        rvNotes.setLayoutManager(rvLayoutManager);

        rvAdapter = new MyAdapter(notes, this);
        rvNotes.setAdapter(rvAdapter);

    }

    private void initializeData() {
        notes = new ArrayList<>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tbAdd:
                addClick();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addClick() {
        Intent i = new Intent(this, NewNoteActivity.class);
        startActivityForResult(i, REQUEST_CODE_GET_NOTE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == NewNoteActivity.RESULT_CODE_SUCCESS) {
            Note note = (Note) data.getSerializableExtra("note");
            Log.d("TAG", note.getTitle() + " " + note.getContent());
            notes.add(note);
        }
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        Note note = notes.get(position);
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("note", note);
        startActivity(i);
    }
}
