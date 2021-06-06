package sg.edu.np.mad.madpractical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    List<User> users;
    AlertDialog.Builder builder;

    public UserAdapter(List<User> users){
        this.users = users;
    }

    //UserViewHolder Class
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.userrecyclerview,parent, false);
        return new UserViewHolder(item);
    }

    //View and Close Opinion while showing Data (Name + Description)
    public void onBindViewHolder(UserViewHolder holder, int position){
        Context context = holder.itemView.getContext();
        User info = users.get(position);
        holder.name.setText(info.name);
        holder.description.setText(info.description);
        holder.image.setOnClickListener(v -> new AlertDialog.Builder(context)
                        .setTitle("Profile")
                        .setMessage(info.name)
                        .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("View", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(context, MainActivity.class);
                                intent.putExtra("id", position);
                                context.startActivity(intent);
                            }
                        })

                        .show());

    }

    public int getItemCount(){
        return users.size();
    }
}
