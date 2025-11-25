package np.edu.kathford.passingdataexample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText EditTextName, EditTextAge, EditTextMobileNo;
    private Button SubmitButton;
    private TextView resultTextView;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditTextName = findViewById(R.id.EditTextName);
        EditTextAge = findViewById(R.id.EditTextAge);
        EditTextMobileNo = findViewById(R.id.EditTextMobileNo);
        resultTextView = findViewById(R.id.resultTextView);
        SubmitButton = findViewById(R.id.SubmitButton);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = EditTextName.getText().toString().trim();
                int age = Integer.parseInt(EditTextAge.getText().toString().trim());
                String mobileNumber = EditTextMobileNo.getText().toString().trim();

                // Explicit intent

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // key - string , value
                intent.putExtra("full_name",fullname);
                intent.putExtra("age",age);
                intent.putExtra("mobile",mobileNumber);

                // this helps to provide data to another class
//                startActivity(intent);

                startActivityForResult(intent, 201);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == resultCode && data != null){
            int acknowledge = data.getIntExtra("ack", 17);
            resultTextView.setText(String.valueOf(acknowledge));
        }
    }
}
