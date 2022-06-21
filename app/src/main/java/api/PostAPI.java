package api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.freakner.MyApplication;
import com.example.freakner.Post;
import com.example.freakner.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostAPI {
//    private MutableLiveData<List<Post>> postListData;
//    private PostDao dao;
    Retrofit retrofit;
    WebServiceAPI webServiceAPI;
//in the public : "MutableLiveData<List<Post>> postListData, PostDao dao"
    public PostAPI() {
//        this.postListData = postListData;
//        this.dao = dao;

        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrlApi))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
    }


    public void addContact(Context context, String username, Cont c){
        Call<Void> call = webServiceAPI.addContact(username, c);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(context, "Added Contact successfully", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Couldnt add contact", Toast.LENGTH_LONG).show();

            }
        });
    }
    public void sendMess(Context context, String username, String contact, Mess m){
        Call<Void> call = webServiceAPI.sendMessage(contact, username, m);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(context, "sent message successfully", Toast.LENGTH_SHORT).show();
                Log.d("errMess", response.toString());

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Couldnt send message", Toast.LENGTH_LONG).show();

            }
        });
    }

}