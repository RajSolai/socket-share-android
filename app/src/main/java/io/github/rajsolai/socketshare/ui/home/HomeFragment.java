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
    public String filepath;
    boolean result = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final Button button = root.findViewById(R.id.button);
        final EditText input = root.findViewById(R.id.editTextTextPersonName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openFile("./");
                File ssam = new File("/storage/emulated/0/Documents/cnlabchecksum.pdf");
                Log.d("file", String.valueOf(ssam.exists()));
            }
        });
        return root;
    }

    private void openFile(String pickerInitialUri) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");

        // Optionally, specify a URI for the file that should appear in the
        // system file picker when it loads.
        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);
        intent.putExtra("result",result);
        startActivityForResult(intent, 2);
        Bundle useless = intent.getExtras();
        Log.d("uri",useless.toString());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)  {
        super.onActivityResult(requestCode, resultCode, data);
        Uri content_describer = data.getData();
        File sample = new File(content_describer.getPath());
        Log.d("uri",sample.getName());
        Log.d("uri",content_describer.toString());
        Log.d("uri",sample.getParent());
    }


}