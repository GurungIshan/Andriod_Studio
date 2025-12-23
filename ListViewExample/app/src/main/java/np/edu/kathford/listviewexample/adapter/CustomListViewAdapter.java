package np.edu.kathford.listviewexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;

import np.edu.kathford.listviewexample.R;
import np.edu.kathford.listviewexample.model.MovieModel;


public class CustomListViewAdapter extends ArrayAdapter<MovieModel> {

    private Context context;
    private ArrayList<MovieModel> movieList;
    public CustomListViewAdapter(@NonNull Context context, ArrayList<MovieModel> movieList) {
        super(context, 0, movieList);
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
            ImageView imageView = convertView.findViewById(R.id.posterImageView);
            TextView movieNameTextView = convertView.findViewById(R.id.MovieNameTextView);
            TextView durationTextView = convertView.findViewById(R.id.durationTextView);
            TextView descriptionTextView = convertView.findViewById(R.id.descriptionTextView);

            MovieModel movieModel = movieList.get(position);
            movieNameTextView.setText(movieModel.getDuration());
            durationTextView.setText(movieModel.getDescription());
            descriptionTextView.setText(movieModel.getDescription());

            Picasso.get().load(movieModel.getPoster()).into(imageView);
        }
        return convertView;
    }
}
