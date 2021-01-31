package io.github.rajsolai.socketshare.ui.home;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import io.github.rajsolai.socketshare.R;

import java.io.*;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public byte[] file;
    public File filetosend;
    public String filepath;
    boolean result = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final Button button = root.findViewById(R.id.button);
        final EditText reciver_address_input = root.findViewById(R.id.editTextTextPersonName);
        final EditText file_address_input = root.findViewById(R.id.editTextTextPersonName2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filepath = file_address_input.getText().toString();
                checkFile(filepath);
            }
        });
        return root;
    }

    protected void checkFile(String filepath){
        filetosend = new File("/storage/emulated/0/"+filepath);
        if(filetosend.exists()){
            Toast.makeText(getContext(),"Sending File \uD83D\uDE80️",Toast.LENGTH_LONG).show();
            /* TODO code send file method */
        }else{
            Toast.makeText(getContext(),"File not found️",Toast.LENGTH_LONG).show();
        }
    }

}