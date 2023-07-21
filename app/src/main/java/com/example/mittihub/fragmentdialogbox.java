//package com.example.mittihub;
//
//import android.Manifest;
//import android.app.AlertDialog;
//import android.app.Dialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.net.Uri;
//import android.os.Build;
//import android.os.Bundle;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.core.app.ActivityCompat;
//import androidx.fragment.app.DialogFragment;
//
//public class fragmentdialogbox extends DialogFragment {
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        String[] contacts = getActivity().getResources().getStringArray(R.array.contact);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("Contact Us");
//        builder.setItems(contacts, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int i) {
//                if (contacts[i].equals("Call")) {
//                    callphonenumber();
//
//                }
//                if (contacts[i].equals("Mail")) {
//                    Intent intent = new Intent(Intent.ACTION_SEND);
//                    intent.setType("text/html");
//                    intent.putExtra(Intent.EXTRA_EMAIL, "Abhinavagarwal20.aa@gmail.com");
//                    intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//                    intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
//                    startActivity(Intent.createChooser(intent, "Send Email"));
//                    if (intent.resolveActivity(getContext().getPackageManager()) != null) {
//                        startActivity(intent);
//                    } else {
//                        Toast.makeText(getActivity(), "There is no application that support this action",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
//
//        return builder.create();
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == 101) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                callphonenumber();
//            }
//        }
//    }
//
//    private void callphonenumber() {
//
//
//        if (Build.VERSION.SDK_INT > 22) {
//
//            if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CALL_PHONE)
//                    != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(getActivity(),
//                        new String[]{Manifest.permission.CALL_PHONE}, 101);
//
//
//                Intent call = new Intent(Intent.ACTION_DIAL);
//                call.setData(Uri.parse("tel:" + "9602919966"));
//                startActivity(call);
//            } else {
//
//
//                Intent call = new Intent(Intent.ACTION_DIAL);
//                call.setData(Uri.parse("tel:" + "9602919966"));
//                startActivity(call);
//
//            }
//
//
//        }
//    }
//}
