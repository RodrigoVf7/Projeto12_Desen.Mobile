package br.edu.fateczl.timejogador;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.edu.fateczl.timejogador.controller.TimeAdapter;
import br.edu.fateczl.timejogador.controller.TimeController;
import br.edu.fateczl.timejogador.model.Time;

public class TimeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TimeController timeController;
    private TimeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        timeController = new TimeController(this);

        recyclerView = findViewById(R.id.recyclerViewTimes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(TimeActivity.this, TimeFormActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Time> times = timeController.listarTodosTimes();
        adapter = new TimeAdapter(times, time -> {
            Intent intent = new Intent(TimeActivity.this, TimeFormActivity.class);
            intent.putExtra("time", time);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }
}
