package api;

import com.example.freakner.Post;
import com.example.freakner.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebServiceAPI {
    @GET("users")
    Call<List<User>> getUsers();

    @POST("users")
    Call<Void> createUser(@Body User user);

    @DELETE("users/{id}")
    Call<Void> deleteUser(@Path("id") int id);
}
