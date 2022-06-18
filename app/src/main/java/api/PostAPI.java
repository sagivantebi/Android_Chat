package api;

import android.content.Context;
import android.widget.Toast;

import com.example.freakner.MyApplication;
import com.example.freakner.Post;
import com.example.freakner.R;
import com.example.freakner.User;
import com.example.freakner.UserCon;

import java.util.List;

import api.WebServiceAPI;
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
                .baseUrl(MyApplication.context.getString(R.string.BaseContactApiUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
    }

    public List<User> get() {
        Call<List<User>> call = webServiceAPI.getUsers();
        final List<User>[] posts = new List[]{null};
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
               posts[0] = response.body();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
            }
        });
    return posts[0];
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
}