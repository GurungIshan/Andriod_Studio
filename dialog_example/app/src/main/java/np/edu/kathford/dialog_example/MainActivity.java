package np.edu.kathford.dialog_example;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button logoutButton, dialogFragmentButton, customDialogButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoutButton = findViewById(R.id.logoutButton);
        dialogFragmentButton = findViewById(R.id.dialogFragmentButton);
        customDialogButton = findViewById(R.id.customDialogButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutButton();
            }
        });
        dialogFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogoutDialogFragment logoutDialogFragment = new LogoutDialogFragment();
                logoutDialogFragment.show(getSupportFragmentManager(), "LogoutFragmentManager");
            }
        });
        customDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog();
            }
        });
    }
    private void customDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.dialog_simple_interest, null);

        EditText principalEditText = view.findViewById(R.id.principalEditText);
        EditText timeEditText = view.findViewById(R.id.timeEditText);
        EditText rateEditText = view.findViewById(R.id.rateEditText);
        Button calculateButton = view.findViewById(R.id.calculateButton);
        TextView resultTextView = view.findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double principal = Double.parseDouble(principalEditText.getText().toString().trim());
                double rate = Double.parseDouble(rateEditText.getText().toString().trim());
                int time = Integer.parseInt(timeEditText.getText().toString().trim());

                double SI = (principal*time*rate)/100;

                resultTextView.setText("The SI is: "+SI);
            }
        });
        builder.setView(view);
        AlertDialog alert = builder.create();
        alert.show();
    }
    private void logoutButton(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("Logout");
        builder.setMessage("Logout garna chahannu hunxa ra?");
        builder.setPositiveButton("logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Ok clicked", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
