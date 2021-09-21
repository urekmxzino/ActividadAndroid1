package com.aravena.actividadevaluadanicolasaravena.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aravena.actividadevaluadanicolasaravena.R;
import com.aravena.actividadevaluadanicolasaravena.models.Receta;

import java.util.ArrayList;

public class RecetaAdapter extends RecyclerView.Adapter<RecetaAdapter.ViewHolder> {

    ArrayList<Receta> listaRecetas;
    public RecetaAdapter(ArrayList<Receta> lista){
        this.listaRecetas = lista;
    }

    @NonNull
    @Override
    public RecetaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecetaAdapter.ViewHolder holder, int position) {
        holder.cargarReceta(listaRecetas.get(position));
    }

    @Override
    public int getItemCount() {
        return listaRecetas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre,txtIngP,txtIng,txtBase,txtAlino,txtPrecio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtAlino = itemView.findViewById(R.id.txtAlino);
            txtBase = itemView.findViewById(R.id.txtBase);
            txtIng = itemView.findViewById(R.id.txtIng);
            txtIngP = itemView.findViewById(R.id.txtIngP);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
        }
        public void cargarReceta(Receta r){
            String ing = "";
            String[] ings = r.getIng();
            for (int i = 0; i<ings.length;i++ ){
                ing += ings[i]+" ";
            }

            String alinos = "";
            String[] als = r.getAlinos();
            for (int i = 0; i<als.length;i++){
                alinos += als[i]+" ";
            }

            txtNombre.setText(r.getNombre());
            txtAlino.setText(alinos);
            txtBase.setText(r.getBase());
            txtIng.setText(ing);
            txtIngP.setText(r.getIngP());
            txtPrecio.setText("$ "+ r.getPrecio());



        }
    }


}

