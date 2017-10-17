package com.jonmid.segundoparcial.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.segundoparcial.Array.Images;
import com.jonmid.segundoparcial.R;
import com.jonmid.segundoparcial.Views.DetailActivity;
import com.jonmid.segundoparcial.models.TeamModelAnguloJorge;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 17/10/2017.
 */

public class TeamAdapterAnguloJorge extends RecyclerView.Adapter<TeamAdapterAnguloJorge.ViewHolder> {


    List<TeamModelAnguloJorge> teamModelAnguloJorgeList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public TeamAdapterAnguloJorge(List<TeamModelAnguloJorge> teamModelAnguloJorgeList, Context context) {
        this.teamModelAnguloJorgeList = teamModelAnguloJorgeList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Encargado de trabajar con el item.xml y sus componentes
        Picasso.with(context).load(Images.imageRandom()).into(holder.imageViewteam);

        holder.textViewteamname.setText(teamModelAnguloJorgeList.get(position).getName());
        holder.textViewteamcode.setText(teamModelAnguloJorgeList.get(position).getCode());
    }

    @Override
    public int getItemCount() {
        return teamModelAnguloJorgeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewteamname;
        TextView textViewteamcode;
        ImageView imageViewteam;

        public ViewHolder(View item) {
            super(item);
            item.setOnClickListener(this);
            imageViewteam = (ImageView) item.findViewById(R.id.id_img_team);
            textViewteamname = (TextView) item.findViewById(R.id.id_tv_name_team);
            textViewteamcode = (TextView) item.findViewById(R.id.id_tv_cod_team);

        }

        @Override
        public void onClick(View view) {
            Context contextItem = view.getContext();
            Intent intent = new Intent(context, DetailActivity.class);

            intent.putExtra("name", teamModelAnguloJorgeList.get(getLayoutPosition()).getName());
            intent.putExtra("code", teamModelAnguloJorgeList.get(getLayoutPosition()).getCode());

            contextItem.startActivity(intent);
            //String valor = Integer.toString(albumModelList.get(getLayoutPosition()).getId());
            //Toast.makeText(contextItem, valor, Toast.LENGTH_SHORT).show();
        }
    }



}
