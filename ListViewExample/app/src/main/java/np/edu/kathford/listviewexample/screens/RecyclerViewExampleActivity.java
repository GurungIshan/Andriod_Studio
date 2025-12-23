package np.edu.kathford.listviewexample.screens;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import np.edu.kathford.listviewexample.R;
import np.edu.kathford.listviewexample.adapter.CustomRecyclerViewAdapter;
import np.edu.kathford.listviewexample.model.MovieModel;

public class RecyclerViewExampleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<MovieModel> movieList;
    private CustomRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_example);
        recyclerView=findViewById(R.id.recyclerView);

        movieDataSource();
        adapter = new CustomRecyclerViewAdapter(movieList, new CustomRecyclerViewAdapter.CustomOnItemClickLister() {
            @Override
            public void onMovieClick(MovieModel movieModel) {
                Toast.makeText(RecyclerViewExampleActivity.this, movieModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


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