package api;

import android.widget.Toast;

import com.example.freakner.Chat;
import com.example.freakner.Message;
import com.example.freakner.MyApplication;
import com.example.freakner.Post;
import com.example.freakner.R;
import com.example.freakner.User;
import android.content.Context;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class UserAPI {
    Retrofit retrofit;
    WebServiceAPI webServiceAPI;

    public UserAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrlApi))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
    }

    public void addUser(Context context, User u) {
        ApiUser apiUser  = new ApiUser(u);
        Call<Void> call = webServiceAPI.createUser(apiUser);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(context, "Added User successfully", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Couldnt add User", Toast.LENGTH_LONG).show();

            }
        });
    }
}
