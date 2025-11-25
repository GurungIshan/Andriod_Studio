package np.edu.kathford.passingdataexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView fullnameTextView, ageTextView, mobilenoTextView;
    private Button OKButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fullnameTextView = findViewById(R.id.fullnameTextView);
        ageTextView = findViewById(R.id.ageTextView);
        mobilenoTextView = findViewById(R.id.mobilenoTextView);
        OKButton = findViewById(R.id.OkButton);

        if (getIntent()!=null){ // not necessary
            Intent intent = getIntent();
            String fullName = intent.getStringExtra("full_name");
            int age = intent.getIntExtra("age", 8);
            boolean is_active = intent.getBooleanExtra("is_active", false);
            String mobileNumber = intent.getStringExtra("mobile");

            fullnameTextView.setText(fullName);
            ageTextView.setText(String.valueOf(age));
            mobilenoTextView.setText(mobileNumber);

            OKButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("ack","Info received");
                    setResult(201,intent);
                    finish();
                }
            });
        }

    }
}
