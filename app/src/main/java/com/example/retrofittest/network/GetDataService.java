package com.example.retrofittest.network;

import com.example.retrofittest.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/book")
    Call<List<Book>> getBooks();

}
