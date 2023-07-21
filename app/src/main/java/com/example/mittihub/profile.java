package com.example.mittihub;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class profile extends AppCompatActivity {
//    private FirebaseAuth firebaseAuth;
//    FirebaseUser firebaseUser;
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference databaseReference;
//    StorageReference storageReference;
//    String storagepath = "Users_Profile_Cover_image/";
//    String uid;
//    ImageView set;
//    TextView profilepic, editname, edituser,editprof,editdepart;
//    ProgressDialog pd;
//    private static final int CAMERA_REQUEST = 100;
//    private static final int STORAGE_REQUEST = 200;
//    private static final int IMAGEPICK_GALLERY_REQUEST = 300;
//    private static final int IMAGE_PICKCAMERA_REQUEST = 400;
//    String cameraPermission[];
//    String storagePermission[];
//    Uri imageuri;
//    String profileOrCoverPhoto;
//    TextView stv2;
  CardView cc7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        profilepic = findViewById(R.id.tv1);
//        editname = findViewById(R.id.tv2);
//        edituser = findViewById(R.id.tv3);
//        editprof = findViewById(R.id.tv4);
//        editdepart = findViewById(R.id.tv5);
//        set = findViewById(R.id.set);
//        stv2=findViewById(R.id.stv2);
        cc7=findViewById(R.id.cc7);
        cc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent l = new Intent(profile.this,SignIn.class);
                startActivity(l);
                finish();

            }
        });
//
//        pd = new ProgressDialog(this);
//        pd.setCanceledOnTouchOutside(false);
//        firebaseAuth = FirebaseAuth.getInstance();
//        firebaseUser = firebaseAuth.getCurrentUser();
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        storageReference = FirebaseStorage.getInstance().getReference();
//        databaseReference = firebaseDatabase.getReference("Users");
//        cameraPermission = new String[]{android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
//        storagePermission = new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
//
//
//        Query query=databaseReference.orderByChild("email").equalTo(firebaseUser.getEmail());
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//
//                    String image = "" + dataSnapshot1.child("image").getValue();
//
//
//                    try {
//                        Glide.with(profile.this).load(image).into(set);
//                    }
//                    catch (Exception e) {
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//
//
//        profilepic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pd.setMessage("Updating Profile Picture");
//                profileOrCoverPhoto = "image";
//                showImagePicDialog();
//            }
//        });
//
//        editname.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pd.setMessage("Updating Name");
//                showNamephoneupdate("name");
//            }
//        });
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Query query = databaseReference.orderByChild("email").equalTo(firebaseUser.getEmail());
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//
//                    String image = "" + dataSnapshot1.child("image").getValue();
//
//                    try {
//                        Glide.with(profile.this).load(image).into(set);
//                    } catch (Exception e) {
//                    }
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Query query = databaseReference.orderByChild("email").equalTo(firebaseUser.getEmail());
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//
//                    String image = "" + dataSnapshot1.child("image").getValue();
//                    Log.d("msg", "onDataChange: "+image);
//
//                    try {
//
//                        Glide.with(profile.this).load(image).into(set);
//                    } catch (Exception e) {
//                    }
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//    }
//
//    private void showNamephoneupdate(final String key) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Update" + key);
//
//        // creating a layout to write the new name
//        LinearLayout layout = new LinearLayout(this);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        layout.setPadding(10, 10, 10, 10);
//        final EditText editText = new EditText(this);
//        editText.setHint("Enter" + key);
//        layout.addView(editText);
//        builder.setView(layout);
//
//        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                final String value = editText.getText().toString().trim();
//                if (!TextUtils.isEmpty(value)) {
//                    pd.show();
//
//                    // Here we are updating the new name
//                    HashMap<String, Object> result = new HashMap<>();
//                    result.put(key, value);
//                    databaseReference.child(firebaseUser.getUid()).updateChildren(result).addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            pd.dismiss();
//
//                            // after updated we will show updated
//                            Toast.makeText(profile.this, " updated ", Toast.LENGTH_LONG).show();
//
//
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            pd.dismiss();
//                            Toast.makeText(profile.this, "Unable to update", Toast.LENGTH_LONG).show();
//                        }
//                    });
//                    if (key.equals("name")) {
//                        final DatabaseReference databaser = FirebaseDatabase.getInstance().getReference("Posts");
//                        Query query = databaser.orderByChild("uid").equalTo(uid);
//                        query.addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                                    String child = databaser.getKey();
//                                    dataSnapshot1.getRef().child("uname").setValue(value);
//                                }
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                            }
//                        });
//                    }
//                } else {
//                    Toast.makeText(profile.this, "Unable to update", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                pd.dismiss();
//            }
//        });
//        builder.create().show();
//    }
//
//    private void showImagePicDialog() {
//        String options[] = {"Camera", "Gallery"};
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Pick Image From");
//        builder.setItems(options, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // if access is not given then we will request for permission
//                if (which == 0) {
//
//                        pickFromCamera();
//
//                } else if (which == 1) {
//
//                        pickFromGallery();
//
//                }
//            }
//        });
//        builder.create().show();
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (resultCode == Activity.RESULT_OK) {
//            if (requestCode == IMAGEPICK_GALLERY_REQUEST) {
//                imageuri = data.getData();
//                uploadProfileCoverPhoto(imageuri);
//            }
//            if (requestCode == IMAGE_PICKCAMERA_REQUEST) {
//                uploadProfileCoverPhoto(imageuri);
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case CAMERA_REQUEST: {
//                if (grantResults.length > 0) {
//                    boolean camera_accepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                    boolean writeStorageaccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
//                    if (camera_accepted && writeStorageaccepted) {
//                        pickFromCamera();
//                    } else {
//                        Toast.makeText(this, "Please Enable Camera and Storage Permissions", Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//            break;
//            case STORAGE_REQUEST: {
//                if (grantResults.length > 0) {
//                    boolean writeStorageaccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                    if (writeStorageaccepted) {
//                        pickFromGallery();
//                    } else {
//                        Toast.makeText(this, "Please Enable Storage Permissions", Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//            break;
//        }
//    }
//
//    // Here we will click a photo and then go to startactivityforresult for updating data
//    private void pickFromCamera() {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(MediaStore.Images.Media.TITLE, "Temp_pic");
//        contentValues.put(MediaStore.Images.Media.DESCRIPTION, "Temp Description");
//        imageuri = this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
//        Intent camerIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        camerIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageuri);
//        startActivityForResult(camerIntent, IMAGE_PICKCAMERA_REQUEST);
//    }
//
//    // We will select an image from gallery
//    private void pickFromGallery() {
//        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
//        galleryIntent.setType("image/*");
//        startActivityForResult(galleryIntent, IMAGEPICK_GALLERY_REQUEST);
//    }
//
//    // We will upload the image from here.
//    private void uploadProfileCoverPhoto(final Uri uri) {
//        pd.show();
//
//        // We are taking the filepath as storagepath + firebaseauth.getUid()+".png"
//        String filepathname = storagepath + "" + profileOrCoverPhoto + "_" + firebaseUser.getUid();
//        StorageReference storageReference1 = storageReference.child(filepathname);
//        storageReference1.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
//                while (!uriTask.isSuccessful()) ;
//
//                // We will get the url of our image using uritask
//                final Uri downloadUri = uriTask.getResult();
//                if (uriTask.isSuccessful()) {
//
//                    // updating our image url into the realtime database
//                    HashMap<String, Object> hashMap = new HashMap<>();
//                    hashMap.put(profileOrCoverPhoto, downloadUri.toString());
//                    databaseReference.child(firebaseUser.getUid()).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            pd.dismiss();
//                            Toast.makeText(profile.this, "Updated", Toast.LENGTH_LONG).show();
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            pd.dismiss();
//                            Toast.makeText(profile.this,"Error Updating ", Toast.LENGTH_LONG).show();
//                        }
//                    });
//                } else {
//                    pd.dismiss();
//                    Toast.makeText(profile.this, "Error", Toast.LENGTH_LONG).show();
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                pd.dismiss();
//                Toast.makeText(profile.this, "Error", Toast.LENGTH_LONG).show();
//            }
//        });
    }
}