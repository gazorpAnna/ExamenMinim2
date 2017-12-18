package edu.upc.eetac.dsa.examenminim2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import edu.upc.eetac.dsa.examenminim2.R;
import edu.upc.eetac.dsa.examenminim2.model.Producto;

/**
 * Created by annag on 18/12/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private List<Producto> productos;
    private int rowLayout;
    private Context context;

    public ProductAdapter(List<Producto> productos, int rowLayout, Context context) {
        this.productos = productos;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.nombre.setText(productos.get(position).getNombreProd());
        holder.precio.setText(productos.get(position).getPrecio());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView nombre;
        TextView precio;

        public ProductViewHolder(View itemView) {
            super(itemView);
            this.linearLayout = (LinearLayout) itemView.findViewById(R.id.list_item);
            this.nombre = (TextView) itemView.findViewById(R.id.nombre);
            this.precio = (TextView) itemView.findViewById(R.id.precio);
        }
    }
}
