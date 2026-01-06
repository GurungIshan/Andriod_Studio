package np.edu.kathford.sendingandgettingcontentfromserver;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.sendingandgettingcontentfromserver.network.ApiService;
import np.edu.kathford.sendingandgettingcontentfromserver.network.NetworkHelper;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private EditText posttitleEditText, messageEditText;
    private Button submitButton;
    private ApiService apiService;
    private Retrofit retrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posttitleEditText = findViewById(R.id.posttitleEditText);
        messageEditText = findViewById(R.id.messageEditText);
        submitButton = findViewById(R.id.submitButton);

        retrofit = NetworkHelper.INSTANCE();
        apiService = retrofit.create(ApiService.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = posttitleEditText.getText().toString().trim();
                String message = messageEditText.getText().toString().trim();
            }
        });

    }
}
