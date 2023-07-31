package jp.suntech.s22013.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.Snackbar;

public class ConfirmMailDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("確認")
                .setMessage("送信しますか?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        switch (id)
                        {
                        case DialogInterface.BUTTON_POSITIVE:
                        EditText input = getActivity().findViewById(R.id.etName);
                        EditText input1 = getActivity().findViewById(R.id.etMail);
                        EditText input2 = getActivity().findViewById(R.id.etHeader);
                        EditText input3 = getActivity().findViewById(R.id.etComment);
                        String str = input.getText() +"" + input1.getText() + "\n" + input2.getText() + "" + input3.getText();
                        Toast.makeText(getActivity(), str, Toast.LENGTH_LONG).show();
                    }
                }
                })
                .setNegativeButton("キャンセル", null);

        return builder.create();
    }


    }

