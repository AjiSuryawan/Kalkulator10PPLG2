package com.example.kalkulator10pplg2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder>{

    private Context context;
    private List<EPLTeamModel> contactList;
    private ContactsAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvname, tvphone;
        public ImageView ivLogoTeam;

        public MyViewHolder(View view) {
            super(view);
            tvname = view.findViewById(R.id.tvname);
            tvphone = view.findViewById(R.id.tvphone);
            ivLogoTeam = view.findViewById(R.id.ivlogoteam);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onContactSelected(contactList.get(getAdapterPosition()));
                }
            });
        }
    }

    public ContactsAdapter(Context context, List<EPLTeamModel> contactList , ContactsAdapterListener listener) {
        this.context = context;
        this.contactList = contactList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.MyViewHolder holder, int position) {
        final EPLTeamModel contact = this.contactList.get(position);
        holder.tvname.setText(contact.getTeamName());
        holder.tvphone.setText(contact.getStadiun());
        Glide.with(holder.itemView.getContext()).load(contact.getStrTeamBadge()).into(holder.ivLogoTeam);

    }

    @Override
    public int getItemCount() {
        return this.contactList.size();
    }

    public interface ContactsAdapterListener {
        void onContactSelected(EPLTeamModel contact);
    }
}
