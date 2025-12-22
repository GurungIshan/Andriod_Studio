package np.edu.kathford.listviewexample;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import np.edu.kathford.listviewexample.adapter.CustomGridViewAdapter;

public class GridViewMovieActivity extends AppCompatActivity {
    private GridView gridView;
    private CustomGridViewAdapter adapter;
    private ArrayList<MovieModel> movieList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_layout);

        gridView = findViewById(R.id.gridView);
        movieDataSource();
        adapter = new CustomGridViewAdapter(this, movieList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MovieModel movieModel = movieList.get(position);
                Toast.makeText(GridViewMovieActivity.this, movieModel.getName() , Toast.LENGTH_SHORT).show();
            }
        });
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

        movieModel = new MovieModel(4, "Sholay","209 mins",
                "This special re-release is a celebration of 50 years anniversary and a tribute " +
                        "to the enduring legacy of Sholay and its legendary cast, especially Dharmendra’s " +
                        "iconic portrayal of Veeru, a performance that continues to live on in the hearts of audiences.",
                "https://inicinemas.com/Modules/CineUploadFiles/Movie/image/Sholay_620x780_243217.png");
        movieList.add(movieModel);


    }
}
