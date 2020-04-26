package com.example.foodordering1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserAdapter> {
    private List<UserModel> userModelList;
    private List<UserModel> getUserModelListFiltered;
    private Context context;
    private SelectrdUser selectedUser;

    public UsersAdapter(List<UserModel> userModelList,SelectrdUser selectedUser) {
        this.userModelList = userModelList;
        this.getUserModelListFiltered = userModelList;
        this.selectedUser = selectedUser;
    }

    @NonNull
    @Override
    public UserAdapter onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        context = parent.getContext();
        return new UserAdapter( LayoutInflater.from( context ).inflate( R.layout.row_users,null ) );
    }

    public UsersAdapter(List<UserModel> userModelList) {
        this.userModelList = userModelList;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter holder,int position) {

        UserModel userModel = userModelList.get( position );
        String username = userModel.getItemname();
        String prefix = userModel.getItemname();
        holder.tvUsername.setText( username );
        holder.tvPrefix.setText( prefix );
    }

    public Filter getFilter() {
        Filter filter = new Filter(){

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filterResults.count = getUserModelListFiltered.size();
                    filterResults.values = getUserModelListFiltered;
                } else {
                    String searchchr = constraint.toString().toLowerCase();
                    List<UserModel> resultData = new ArrayList<>();
                    for (UserModel userModel : getUserModelListFiltered) {
                        if (userModel.getItemname().toLowerCase().contains( searchchr )) {
                            resultData.add( userModel );
                        }
                    }
                    filterResults.count = resultData.size();
                    filterResults.values = resultData;
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint,FilterResults results) {
                userModelList = (List<UserModel>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }


    public interface SelectrdUser {
        void SelectedUser(UserModel userModel);
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public class UserAdapter extends RecyclerView.ViewHolder implements Filterable {
        TextView tvPrefix;
        TextView tvUsername;
        ImageView imIcon;

        public UserAdapter(@NonNull View itemView) {
            super( itemView );
            tvPrefix = itemView.findViewById( R.id.prefix );
            tvUsername = itemView.findViewById( R.id.username );
            imIcon = itemView.findViewById( R.id.imageView );
            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedUser.SelectedUser( userModelList.get( getAdapterPosition() ) );
                }
            } );
        }

        @Override
        public Filter getFilter() {
            return null;
        }
    }
        public UsersAdapter(Context context) {
            this.context = context;
        }
}
