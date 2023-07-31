package jp.suntech.s22013.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonClickListener listener = new ButtonClickListener();

        Button btSead = findViewById(R.id.btSend);
        Button btClear = findViewById(R.id.btClear);
        Button btConfirm = findViewById(R.id.btConfirm);

        btSead.setOnClickListener(listener);
        btClear.setOnClickListener(listener);
        btConfirm.setOnClickListener(listener);

    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText input = findViewById(R.id.etName);
            EditText input1 = findViewById(R.id.etMail);
            EditText input2 = findViewById(R.id.etHeader);
            EditText input3 = findViewById(R.id.etComment);
            int id = v.getId();

            if (id == R.id.btSend) {
                String str = input.getText().toString();
                String str1 = input1.getText().toString();
                String str2 = input2.getText().toString();
                String str3 = input3.getText().toString();
                Snackbar.make(v, str + "" + str1 + "\n" + str2 + "" + str3, Snackbar.LENGTH_LONG).show();
            } else if (id == R.id.btClear) {
                input.setText("");
                input1.setText("");
                input2.setText("");
                input3.setText("");
            }
            if (id == R.id.btConfirm) {
                ConfirmMailDialogFragment dialogFragment = new ConfirmMailDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "ConfirmMailDialogFragment");

            }

        }

        private class ListConfirmClickListener implements AdapterView.OnItemClickListener {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConfirmMailDialogFragment dialogFragment = new ConfirmMailDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "ConfirmMailDialogFragment");
            }


        }
    }
}