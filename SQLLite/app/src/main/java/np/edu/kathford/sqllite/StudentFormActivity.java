package np.edu.kathford.sqllite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.sqllite.handler.DbHandler;
import np.edu.kathford.sqllite.models.Student;

public class StudentFormActivity extends AppCompatActivity {
    private EditText idEditText, fullnameEditText, addressEditText, mobilenumberEditText;

    private Button addStudentButton, updateStudentInfoButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        idEditText = findViewById(R.id.studentIdEditText);
        fullnameEditText= findViewById(R.id.fullNameEditText);
        addressEditText = findViewById(R.id.addressEditText);
        mobilenumberEditText = findViewById(R.id.mobilenumberEditText);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = fullnameEditText.getText().toString().trim();
                String mobilenumber = mobilenumberEditText.getText().toString().trim();
                String address = addressEditText.getText().toString().trim();

                Student student = new Student();
                student.setFullname(fullname);
                student.setAddress(address);
                student.setMobileNumber(mobilenumber);

                DbHandler handler = new DbHandler(StudentFormActivity.this);
                long insertedId = handler.addStudent(student);

                if(insertedId>0){
                    Toast.makeText(StudentFormActivity.this, "Student Record Added Successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(StudentFormActivity.this, "Unable to add student record", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
