package np.edu.kathford.application_logo_example;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    String[] appNames = {
            "YouTube", "Facebook", "Twitter",
            "TikTok"
    };

    int[] appIcons = {
            R.drawable.youtube,
            R.drawable.facebook,
            R.drawable.twitter,
            R.drawable.tiktok,
    };

    String[] appUrls = {
            "https://www.youtube.com",
            "https://www.facebook.com",
            "https://www.twitter.com",
            "https://www.tiktok.com",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        AppAdapter adapter = new AppAdapter(this, appNames, appIcons);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, WebActivity.class);
            intent.putExtra("url", appUrls[position]);
            startActivity(intent);
        });
    }
}