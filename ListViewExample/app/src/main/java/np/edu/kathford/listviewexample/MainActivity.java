package np.edu.kathford.listviewexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] datas = {"Sushil","Sushil baini","Rehman Dakait","Hamza"};

    private ArrayList<MovieModel> movieList;

    private CustomListViewAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        // array adapter for simple listview
//        ArrayAdapter<String> adapter = new ArrayAdapter(this,
//                android.R.layout.simple_list_item_1, datas ); // android built-in item
//
//        // setting adapter to the listview
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                String name = datas[position];
//                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
//            }
//        });

        movieDataSource();
        adapter = new CustomListViewAdapter(this, movieList);
        listView.setAdapter(adapter);

    }

    private void movieDataSource(){
        movieList = new ArrayList<>();
        MovieModel movieModel = new MovieModel(
                1, "Dhunrandhar","212min",
                "Dhurandhar is a star-studded saga inspired " +
                        "by incredible true events set in the gritty criminal " +
                        "vein of underworld with a backdrop of Indian patriotism, " +
                        "featuring action sequences, Shakespearean betrayals, " +
                        "and tradecrafts of espionage.",
                "https://inicinemas.com/Modules/CineUploadFiles/Movie/image/Dhurandhar_620x780_276584.png"
        );
        movieList.add(movieModel);

        movieModel = new MovieModel(2, "Sholay","209 mins",
                "This special re-release is a celebration of 50 years anniversary and a tribute " +
                        "to the enduring legacy of Sholay and its legendary cast, especially Dharmendra’s " +
                        "iconic portrayal of Veeru, a performance that continues to live on in the hearts of audiences.",
                "https://inicinemas.com/Modules/CineUploadFiles/Movie/image/Sholay_620x780_243217.png");
        movieList.add(movieModel);

        movieModel = new MovieModel(3, "Avatar : Fire and Ash",
                "3hr 15min",
                "Jake and Neytiri's family grapples with grief after Neteyam's death, " +
                        "encountering a new, aggressive Na'vi tribe, the Ash People, who are led " +
                        "by the fiery Varang, as the conflict on Pandora escalates and a new moral focus emerges.",
                "https://inicinemas.com/Modules/CineUploadFiles/Movie/image/Avatar-Fire-and-Ash_620x780_603394.png");
        movieList.add(movieModel);
    }
}
