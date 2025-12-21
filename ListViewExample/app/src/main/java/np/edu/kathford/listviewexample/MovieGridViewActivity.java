package np.edu.kathford.listviewexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MovieGridViewActivity extends AppCompatActivity {
    private GridView gridView;

    private String[] numbers = {"1","2","3","4","5"};


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_layout);

        gridView = findViewById(R.id.gridView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, numbers
        );
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String number = numbers[position];
                Toast.makeText(MovieGridViewActivity.this, number, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
