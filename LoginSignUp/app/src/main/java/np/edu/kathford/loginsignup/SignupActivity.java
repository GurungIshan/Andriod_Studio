package np.edu.kathford.loginsignup;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    private EditText fullNameEditText, phonenumberEditText,  passwordEditText;
    private RadioGroup genderRadioGroup;
    private Spinner nationalitySpinner;
    private CheckBox termsandconditionCheckbox;
    private Button signupButton;
    private String fullname, password, phonenumber;
    private String gender, nationality;
    private boolean isTermsChecked = false;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullNameEditText = findViewById(R.id.fullnameEditText);
        phonenumberEditText = findViewById(R.id.phonenumberEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        genderRadioGroup = findViewById(R.id.genderRadioButton);
        termsandconditionCheckbox = findViewById(R.id.termsandconditionCheckbox);
        nationalitySpinner = findViewById(R.id.nationalitySpinner);
        signupButton = findViewById(R.id.signupButton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // local variable
                 fullname = fullNameEditText.getText().toString().trim();
                 phonenumber = phonenumberEditText.getText().toString().trim();
                 password = passwordEditText.getText().toString().trim();

                 if(!fullname.isEmpty() && !phonenumber.isEmpty() && !password.isEmpty()
                         && gender!=null && !nationality.isEmpty() && isTermsChecked){
                     Toast.makeText(SignupActivity.this, "Signup success", Toast.LENGTH_SHORT).show();
                     finish();
                 }else {
                     Toast.makeText(SignupActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                 }
            }

        });
        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if(R.id.maleRadioButton == checkedId){
                    gender= "Male";
                } else if (R.id.femaleRadioButton== checkedId) {
                    gender="Female";
                }else {
                    gender="Sushil";
                }
            }
        });
        nationalitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               nationality =  nationalitySpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        termsandconditionCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                isTermsChecked= isChecked;
            }
        });
    }
}
