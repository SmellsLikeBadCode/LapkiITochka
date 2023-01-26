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
import com.example.myapplication.UserResponse;
import com.example.myapplication.postActivity;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

import retrofit2.Callback;

public class LostAdapter extends RecyclerView.Adapter<LostAdapter.LostViewHolder> {

    Context context;
    List<UserResponse> userResponseList;

    public LostAdapter(Callback<List<UserResponse>> context, List<UserResponse> userResponseList) {
        /*this.context = context;
        this.userResponseList = userResponseList;*/
    }

    public void setData(List<UserResponse> userResponseList){
        this.userResponseList = userResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LostAdapter.LostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View lostItems = LayoutInflater.from(context).inflate(R.layout.lost_item, parent, false);
        return new LostAdapter.LostViewHolder(lostItems);
    }

    @Override
    public void onBindViewHolder(@NonNull LostAdapter.LostViewHolder holder, int position) {

        UserResponse userResponse = userResponseList.get(position);

        String lostTitle = userResponse.getDescription();
        if (userResponse.getDescription().length() < 40) {
            lostTitle = userResponse.getDescription();
        } else {
            lostTitle = userResponse.getDescription().substring(0, 40) + "...";
        }
        String lostAddress = userResponse.getAddress();
        String imageURL = "http://10.0.2.2:8080/image/fileSystem/" + userResponse.getFilename();


        Picasso.get()
                .load(imageURL)
                .fit()
                .into(holder.lostImage);
        holder.lostAddress.setText(lostAddress);
        holder.lostTitle.setText(lostTitle);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, postActivity.class);
                intent.putExtra("url", imageURL);
                intent.putExtra("postText", userResponse.getDescription());
                intent.putExtra("postDate", userResponse.getDate());
                intent.putExtra("postDateL", userResponse.getDate());
                intent.putExtra("postNumber", userResponse.getId());
                intent.putExtra("postGender", userResponse.getGender());
                intent.putExtra("postTitle", generateTextTitle(userResponse));

                context.startActivity(intent);
            }
        });

        /*int imageId = context.getResources().getIdentifier("ic_"+losts.get(position).getImg(), "drawable", context.getPackageName());
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
        });*/
    }

    public static String generateTextTitle(UserResponse userResponse){
        String textTitle = "";
        if ((Objects.equals(userResponse.getAnimal(), "cat")) && (Objects.equals(userResponse.getGender(), "female"))) textTitle += "Потерялась кошка";
        else if ((Objects.equals(userResponse.getAnimal(), "cat")) && (Objects.equals(userResponse.getGender(), "male")))  textTitle += "Потерялся кот";
        else if ((Objects.equals(userResponse.getAnimal(), "dog")) && (Objects.equals(userResponse.getGender(), "female"))) { textTitle += "Потерялась собака";}
        else if ((Objects.equals(userResponse.getAnimal(), "dog")) && (Objects.equals(userResponse.getGender(), "male"))) { textTitle += "Потерялся пес";}
        textTitle += ", " + userResponse.getAddress();
        return textTitle;
    }


    @Override
    public int getItemCount() {
        return userResponseList.size();
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
