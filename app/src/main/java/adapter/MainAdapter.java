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
import com.example.myapplication.UserResponse;

import java.util.List;

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
        if (userResponse.getDescription().length() < 20){ textTitle = userResponse.getDescription(); }
        else { textTitle = userResponse.getDescription().substring(0,20)+"..."; }
        String textAddress = userResponse.getAddress();
        String textPrice = "В добрые руки";

        holder.textTitle.setText(textTitle);
        holder.textAddress.setText(textAddress);
        holder.textPrice.setText(textPrice);

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
