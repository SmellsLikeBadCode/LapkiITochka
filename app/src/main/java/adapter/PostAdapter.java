package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;
import model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{

    Context context;
    List<Post> posts;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View postItems = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false);
        return new PostAdapter.PostViewHolder(postItems);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier("ic_" + posts.get(position).getImg(), "drawable", context.getPackageName());
        holder.imagePhoto.setImageResource(imageId);
        holder.textPrice.setText(posts.get(position).getPrice());
        holder.textTitle.setText(posts.get(position).getTitle());
        holder.textAddress.setText(posts.get(position).getAddress());


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static final class PostViewHolder extends RecyclerView.ViewHolder {

        ImageView imagePhoto;
        TextView textPrice, textAddress, textTitle;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePhoto = itemView.findViewById(R.id.imagePhoto);
            textAddress = itemView.findViewById(R.id.textAddress);
            textPrice = itemView.findViewById(R.id.textPrice);
            textTitle = itemView.findViewById(R.id.textTitle);

        }
    }

}
