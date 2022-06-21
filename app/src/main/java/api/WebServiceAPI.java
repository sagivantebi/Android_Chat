package api;

import com.example.freakner.Message;
import com.example.freakner.Post;
import com.example.freakner.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface WebServiceAPI {
    @GET("users")
    Call<List<User>> getUsers();

    @GET("users/{id}")

    Call<ApiUser> getUser(@Path("id") String id);

    @POST("users")
    Call<Void> createUser(@Body ApiUser user);

    @DELETE("users/{id}")
    Call<Void> deleteUser(@Path("id") int id);

    @POST("contacts")
    Call<Void> addContact(@Query("username") String username, @Body Cont c);

    @POST("contacts/{contact}/messages/")
    Call<Void> sendMessage(@Path("contact") String contact, @Query("username") String username,@Body Mess m);

    @GET("contacts")
    Call<List<ApiContact>> getContacts(@Query("username") String username);

    @GET("contacts/{contact}/messages")
    Call<List<Message>> getMessages(@Path("contact") String contact, @Query("username") String username);
}
