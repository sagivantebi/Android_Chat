package api;

import android.util.Log;
import android.widget.Toast;

import com.example.freakner.AppDB;
import com.example.freakner.Chat;
import com.example.freakner.Login;
import com.example.freakner.MesCon;
import com.example.freakner.Message;
import com.example.freakner.MyApplication;
import com.example.freakner.Post;
import com.example.freakner.PostCon;
import com.example.freakner.R;
import com.example.freakner.User;
import com.example.freakner.UserCon;
import com.google.android.gms.common.api.Api;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class UserAPI {
    Retrofit retrofit;
    WebServiceAPI webServiceAPI;
    ApiUser currUser;
    public ArrayList<User> allUsers;

    public UserAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrlApi))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
    }



    public void get(AppDB db) {
        allUsers = null;
        Call<List<User>> call = webServiceAPI.getUsers();
        final ArrayList<User>[] posts = new ArrayList[]{null};
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d("users", response.body().toString());
                allUsers = (ArrayList<User>) response.body();
                insertAll(allUsers, db);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("users", "ERROR");

            }
        });
    }

    public ApiUser getUser(Context context, UserCon userCon, MesCon mesCon, PostCon postCon, String username){
        this.currUser = null;
        Call<ApiUser> call = webServiceAPI.getUser(username);
        call.enqueue(new Callback<ApiUser>() {
            @Override
            public void onResponse(Call<ApiUser> call, Response<ApiUser> response) {
                if(response.body() != null){
                    ApiUser receivedUser = new ApiUser(response.body());
                    currUser = receivedUser;
                    Toast.makeText(context, "Got Response From Server", Toast.LENGTH_LONG).show();
                    Log.d("userRec", receivedUser.toString());
                }

            }

            @Override
            public void onFailure(Call<ApiUser> call, Throwable t) {
                Log.d("err", t.toString());
                Toast.makeText(context, "Couldnt Contact Server", Toast.LENGTH_LONG).show();

            }
        });
        return currUser;
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

    public void insertAll(ArrayList<User> userList, AppDB db){
        for (User u : userList) {
            //db.userCon().insert(u);
            insertContacts(u.username, db);

        }
    }
    public void insertContactsHelper(String username, ArrayList<ApiContact> contacts, AppDB adb){
        PostCon p = adb.postCon();
        for(ApiContact contact : contacts) {
            //p.insert(new Post(contact, username));w
            insertMessages(adb, username, contact.name);
        }

    }

    public void insertMessageHelper(String username, String contact, AppDB adb, ArrayList<Message> messages){
        for(Message m : messages) {
            m.chatId = adb.postCon().getChatId(username, contact);
            adb.mesCon().insert(m);
        }
    }

    protected void insertMessages(AppDB adb, String username, String contact){
        Call<List<Message>> call = webServiceAPI.getMessages(contact, username);
        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response)
            {
                if(response.body() != null)
                    Log.d("messages", response.body().toString());
                if(response.isSuccessful()){
                   insertMessageHelper(username, contact, adb, (ArrayList<Message>) response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Log.d("messages fail", t.toString());

            }
        });
    }

    public void insertContacts(String username, AppDB adb){
        Call<List<ApiContact>> call = webServiceAPI.getContacts(username);
        call.enqueue(new Callback<List<ApiContact>>() {
            @Override
            public void onResponse(Call<List<ApiContact>> call, Response<List<ApiContact>> response) {
                Log.d("contacts", response.body().toString());
                if(response.isSuccessful()){
                    insertContactsHelper(username, (ArrayList<ApiContact>) response.body(), adb);
                }
            }

            @Override
            public void onFailure(Call<List<ApiContact>> call, Throwable t) {
                Log.d("contacts fail", t.toString());

            }
        });
    }

}
