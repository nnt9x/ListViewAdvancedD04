package com.bkacad.edu.nnt.listviewadvancedd04;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bkacad.edu.nnt.listviewadvancedd04.adapter.MyAdapter;
import com.bkacad.edu.nnt.listviewadvancedd04.model.Food;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // View
    private ListView lvFoods;
    // Du lieu
    private List<Food> data;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // BIND ID
        lvFoods = findViewById(R.id.lv_foods);

        // Du lieu
        data = new ArrayList<>();
        data.add(new Food("Bún bò 1",40000,"https://takestwoeggs.com/wp-content/uploads/2024/10/Bun-Bo-Hue-Spicy-Vietnamese-Beef-Noodle-Soup-7-500x500.jpg"));
        data.add(new Food("Bún bò 2",45000,"https://takestwoeggs.com/wp-content/uploads/2024/10/Bun-Bo-Hue-Spicy-Vietnamese-Beef-Noodle-Soup-7-500x500.jpg"));
        data.add(new Food("Bún bò 3",50000,"https://takestwoeggs.com/wp-content/uploads/2024/10/Bun-Bo-Hue-Spicy-Vietnamese-Beef-Noodle-Soup-7-500x500.jpg"));

        // Adapter
        myAdapter = new MyAdapter(MainActivity.this, data);
        // set adapter cho listview
        lvFoods.setAdapter(myAdapter);
    }
}