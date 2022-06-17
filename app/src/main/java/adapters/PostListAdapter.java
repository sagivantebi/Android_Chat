//package adapters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.TextureView;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.freakner.Post;
//import com.example.freakner.R;
//
//import java.util.List;
//
//public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostViewHolder> {
//
//
//
//    class PostViewHolder extends RecyclerView.ViewHolder{
//        private final TextView contactNameLeft;
//        private final TextView contactTimeLeft;
//        private final TextView contactLastMessLeft;
//        private final ImageView  contactImageLeft;
//
//        private PostViewHolder(View itemView){
//            super(itemView);
//            contactNameLeft = itemView.findViewById(R.id.contactNameLeft);
//            contactLastMessLeft = itemView.findViewById(R.id.contactLastMessLeft);
//            contactTimeLeft = itemView.findViewById(R.id.contactTimeLeft);
//            contactImageLeft=itemView.findViewById(R.id.contactImageLeft);
//        }
//
//    }
//    private final LayoutInflater mInflater;
//    private List<Post> posts;
//
//    public PostListAdapter(Context context) { mInflater = LayoutInflater.from(context);}
//
//    @Override
//    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = mInflater.inflate(R.layout.activity_contact_left_box,parent,false);
//        return new PostViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(PostViewHolder holder, int position) {
//        if (posts!=null){
//            final Post current = posts.get(position);
//            holder.contactNameLeft.setText(current.getName());
//            holder.contactTimeLeft.setText(current.getLastDate());
//            holder.contactLastMessLeft.setText(current.getLast());
//
//
//        }
//    }
//
//    public void setPosts(List<Post> s){
//        posts = s;
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public int getItemCount() {
//        if(posts != null)
//            return posts.size();
//        else return 0;
//    }
//
//    public List<Post> getPosts(){return posts;}
//
//}
