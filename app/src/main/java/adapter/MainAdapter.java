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

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterVH> {

    private List<UserResponse> userResponseList;
    private Context context;

    public MainAdapter(Callback<List<UserResponse>> context, List<UserResponse> userResponseList) {
        /*this.context = context;
        this.userResponseList = userResponseList;*/
    }

    public void setData(List<UserResponse> userResponseList){
        this.userResponseList = userResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new MainAdapter.MainAdapterVH(LayoutInflater.from(context).inflate(R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapterVH holder, int position) {

        UserResponse userResponse = userResponseList.get(position);

        String textTitle;
        if (userResponse.getDescription().length() < 15) {
            textTitle = userResponse.getDescription();
        } else {
            textTitle = userResponse.getDescription().substring(0, 15) + "...";
        }
        String textAddress = userResponse.getAddress();
        String textPrice = "В добрые руки";
        String imageURL = "http://10.0.2.2:8080/image/fileSystem/" + userResponse.getFilename();

        /*Picasso.get()
                .load(imageURL)
                .fit()
                .into(holder.imagePhoto);*/
        Picasso.get()
                        .load(imageURL).resize(1000,1000).centerCrop().into(holder.imagePhoto);

        holder.textTitle.setText(textTitle);
        holder.textAddress.setText(textAddress);
        holder.textPrice.setText(textPrice);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, postActivity.class);
                intent.putExtra("postText", userResponse.getDescription());
                intent.putExtra("postDate", userResponse.getDate());
                intent.putExtra("postDateL", userResponse.getDate());
                intent.putExtra("postNumber", userResponse.getId());
                intent.putExtra("postGender", userResponse.getGender());
                intent.putExtra("postTitle", generateTextTitle(userResponse));
                intent.putExtra("url", imageURL);

                context.startActivity(intent);


                /*"id": 2, - айдишник объявления
                        "address": "ул. пушкина д. колотушкина", - адрес
                        "animalType": "Кошка", - кошка/собака
                        "date": "2020-02-13", - дата пропажи
                        "gender": "Мальчик", - пол животного
                        "name": null, - имя создателя объявления
                        "description": "Потерялся кот для ебания, нашедшему просьба позвонить", - описание объявления
                        "isLost": true, - потерялся/не потерялся
                        "filename": null, - прикрепленная картинка
                        "geoLat": 12.1241, - геоданные
                        "geoLon": 15.1261, - геоданные
                        "lost": true */
                /*Intent intent = new Intent(context, postActivity.class);
                intent.putExtra("postImage", imageId);
                intent.putExtra("postTitle", posts.get(position).getTitle());
                intent.putExtra("postText", posts.get(position).getText());
                intent.putExtra("postNumber", posts.get(position).getNumber());
                intent.putExtra("postBreed", posts.get(position).getBreed());
                intent.putExtra("postGender", posts.get(position).getGender());
                intent.putExtra("postDate", posts.get(position).getDate());
                intent.putExtra("postDateL", posts.get(position).getDateL());
                context.startActivity(intent);*/
            }


        });
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

    public class MainAdapterVH extends RecyclerView.ViewHolder {

        TextView textPrice, textAddress, textTitle;
        ImageView imagePhoto;

        public MainAdapterVH(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textAddress = itemView.findViewById(R.id.textAddress);
            textPrice = itemView.findViewById(R.id.textPrice);
            imagePhoto = itemView.findViewById(R.id.imagePhoto);
        }
    }

}
