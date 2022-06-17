package api;

import com.example.freakner.MyApplication;
import com.example.freakner.Post;
import com.example.freakner.R;
import com.example.freakner.User;

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
                .baseUrl(MyApplication.context.getString(R.string.BaseUrlApi))
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
}