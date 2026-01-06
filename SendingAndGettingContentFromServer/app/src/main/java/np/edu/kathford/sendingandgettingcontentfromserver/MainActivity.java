package np.edu.kathford.sendingandgettingcontentfromserver;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.sendingandgettingcontentfromserver.model.request.PostRequest;
import np.edu.kathford.sendingandgettingcontentfromserver.model.response.PostResponse;
import np.edu.kathford.sendingandgettingcontentfromserver.network.ApiService;
import np.edu.kathford.sendingandgettingcontentfromserver.network.NetworkHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

                PostRequest request = new PostRequest(title, message, 1);
                Call<PostResponse> result = apiService.createPost(request);
                result.enqueue(new Callback<PostResponse>() {
                    @Override
                    public void onResponse(Call<PostResponse> call, @NonNull Response<PostResponse> response) {
                        if (response.code()==201){
                            PostResponse postResponse = response.body();

                            assert postResponse != null;
                            Toast.makeText(MainActivity.this, postResponse.getTitle()+" "+postResponse.getId(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PostResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
