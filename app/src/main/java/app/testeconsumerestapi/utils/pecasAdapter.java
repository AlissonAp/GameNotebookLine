package app.testeconsumerestapi.utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import app.testeconsumerestapi.R;
import app.testeconsumerestapi.models.Peca;

/**
 * Created by Alisson on 09/11/2017.
 */

public class pecasAdapter extends RecyclerView.Adapter<pecasAdapter.ViewHolder> {

    private List<Peca> pecas = Collections.emptyList();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public pecasAdapter(Context context, List<Peca> pecas) {
        this.mInflater = LayoutInflater.from(context);
        this.pecas = pecas;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_item_pecas, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String imageBASE64      = pecas.get(position).getImagem();
        String descricaoPeca    = pecas.get(position).getDescricao();
        String valorPeca        = pecas.get(position).getPreco().toString();

        Bitmap btmImage = new otherFunctions().base64ToBitmap(imageBASE64);

        holder.imagemPeca.setImageBitmap(btmImage);
        holder.nomePeca.setText(descricaoPeca);
        holder.valorPeca.setText(valorPeca);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return pecas.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imagemPeca;
        public TextView  nomePeca;
        public TextView  valorPeca;

        public ViewHolder(View itemView) {

            super(itemView);
            imagemPeca  = itemView.findViewById(R.id.imagemPeca);
            nomePeca    = itemView.findViewById(R.id.txtNomePeca);
            valorPeca   = itemView.findViewById(R.id.txtValorPeca);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public Peca getItem(int id) {
        return pecas.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}