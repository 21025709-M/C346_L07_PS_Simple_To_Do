package sg.edu.rp.c346.id21025709.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNewTodo;
    Button btnAdd;
    Button btnClearAll;
    ListView lvTodo;

    ArrayList<String> alTodo;
    ArrayAdapter<String> aaTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Simple To Do");

        etNewTodo = findViewById(R.id.editTextadd);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClearAll = findViewById(R.id.buttonClear);
        lvTodo = findViewById(R.id.listViewToDo);

        alTodo = new ArrayList<>();

        aaTodo = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,alTodo);

        lvTodo.setAdapter(aaTodo);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTodo = etNewTodo.getText().toString();
                alTodo.add(newTodo);
                aaTodo.notifyDataSetChanged();
                etNewTodo.setText("");
            }

        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTodo.clear();
                aaTodo.notifyDataSetChanged();
            }
        });

    }
}