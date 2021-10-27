package com.example.retrofittest.adapter;

import android.content.Context;
import android.text.Html;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittest.R;
import com.example.retrofittest.model.Book;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {

    private Context context;
    private List<Book> bookList;

    public BookAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {

        holder.title.setText(bookList.get(position).getTitle());
        holder.subtitle.setText(bookList.get(position).getSubtitle());
        holder.author.setText(bookList.get(position).getAuthor());

        holder.url.setText(Html.fromHtml(bookList.get(position).getWebsite()));
        Linkify.addLinks(holder.url, Linkify.WEB_URLS);

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(bookList.get(position).getThumbnail())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.thumbnail);


    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private final ImageView thumbnail;
        private final TextView title;
        private final TextView subtitle;
        private final TextView author;
        private final TextView url;


        public BookHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            thumbnail = (ImageView) itemView.findViewById(R.id.ivThumbnail);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            subtitle = (TextView) itemView.findViewById(R.id.tvSubtitle);
            author = (TextView) itemView.findViewById(R.id.tvAuthor);
            url = (TextView) itemView.findViewById(R.id.tvUrl);
        }
    }

}
