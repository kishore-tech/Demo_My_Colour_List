package sg.edu.rp.c346.id18037611.demomycolourlist;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText etElement;
    EditText etPosition;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etPosition = findViewById(R.id.editTextPosition);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemove);
        btnUpdate = findViewById(R.id.buttonUpdate);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                alColours.add(colour);
                aaColour.notifyDataSetChanged();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = Integer.parseInt(etPosition.getText().toString());
                alColours.remove(index);
                aaColour.notifyDataSetChanged();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int index = Integer.parseInt(etPosition.getText().toString());
                alColours.set(index,colour);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_LONG).show();
            }
        });
    }
}
