package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.lostActivity;
import com.example.myapplication.postActivity;

import java.util.List;

import model.Lost;
import model.Post;

public class LostAdapter extends RecyclerView.Adapter<LostAdapter.LostViewHolder> {

    Context context;
    List<Lost> losts;

    public LostAdapter(Context context, List<Lost> losts) {
        this.context = context;
        this.losts = losts;
    }

    @NonNull
    @Override
    public LostAdapter.LostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lostItems = LayoutInflater.from(context).inflate(R.layout.lost_item, parent, false);
        return new LostAdapter.LostViewHolder(lostItems);
    }

    @Override
    public void onBindViewHolder(@NonNull LostAdapter.LostViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier("ic_"+losts.get(position).getImg(), "drawable", context.getPackageName());
        holder.lostImage.setImageResource(imageId);
        holder.lostTitle.setText(losts.get(position).getTitle());
        holder.lostAddress.setText(losts.get(position).getAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, postActivity.class);
                intent.putExtra("postImage", imageId);
                intent.putExtra("postTitle", losts.get(position).getTitle());
                intent.putExtra("postText", losts.get(position).getText());
                intent.putExtra("postNumber", losts.get(position).getNumber());
                intent.putExtra("postBreed", losts.get(position).getBreed());
                intent.putExtra("postGender", losts.get(position).getGender());
                intent.putExtra("postDate", losts.get(position).getDate());
                intent.putExtra("postDateL", losts.get(position).getDateL());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return losts.size();
    }

    public static final class LostViewHolder extends RecyclerView.ViewHolder{

        ImageView lostImage;
        TextView lostTitle, lostAddress;

        public LostViewHolder(@NonNull View itemView) {
            super(itemView);

            lostImage = itemView.findViewById(R.id.lostImage);
            lostTitle = itemView.findViewById(R.id.lostTitle);
            lostAddress = itemView.findViewById(R.id.lostAddress);
        }
    }
}
