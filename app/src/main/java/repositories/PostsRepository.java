package repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.freakner.Post;

import java.util.LinkedList;
import java.util.List;

public class PostsRepository {
    //private PostDao dao;
    //private PostListData postListData;

    public PostsRepository() {
      //  LocalDatabase db = LocalDatabase.getInstance();
      //  dao = db.postDao();
      //  postListData = new PostListData();
    }

    class PostListData extends MutableLiveData<List<Post>> {

        public PostListData() {
            super();
            setValue(new LinkedList<Post>());
        }

//        @Override
//        protected void onActive() {
//            super.onActive();
//
//            new Thread(() -> {
//                postListData.postValue(dao.get());
//            }).start();
//        }
    }
//
//    public LiveData<List<Post>> getAll() {
//        return postListData;
//    }


}