package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.retrofittest.adapter.BookAdapter;
import com.example.retrofittest.databinding.ActivityMainBinding;
import com.example.retrofittest.model.Book;
import com.example.retrofittest.network.GetDataService;
import com.example.retrofittest.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    BookAdapter bookAdapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();


    }

    private void handleRetrofitIns() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<List<Book>> call = service.getBooks();

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.d("retrofit1", t.toString());
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        handleProgressBar();
        handleRetrofitIns();
    }

    private void handleProgressBar() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading ...");
        progressDialog.show();
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Book> bookList) {
        bookAdapter = new BookAdapter(this,bookList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(bookAdapter);
    }


}