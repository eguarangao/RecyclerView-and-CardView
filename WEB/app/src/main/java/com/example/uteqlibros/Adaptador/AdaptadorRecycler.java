package com.example.uteqlibros.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.uteqlibros.Modelo.ListaLibrosUteq;
import com.example.uteqlibros.R;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

    private Context m_context;
    private ArrayList<ListaLibrosUteq> milista;
public AdaptadorRecycler(Context context, ArrayList<ListaLibrosUteq> lista){
    m_context=context;
    milista=lista;
}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View vista = LayoutInflater.from(m_context).inflate
            (R.layout.contenedor_libros,parent,false);

    return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
      /*ListaLibrosUteq actual = milista.get(position);
      String urlImg=actual.getCover();
      String issue_id =actual.getIssue_id();
      String volume = actual.getVolume();
      String number = actual.getNumber();
      String year = actual.getYear();
      String date_published = actual.getDate_published();
      String title = actual.getTitle();
      String doi= actual.getDoi();
      holder.Tissue_id.setText(issue_id);
      holder.Tvolume.setText(volume);
      holder.Tnumber.setText(number);
      holder.Tyear.setText(year);
      holder.Tdate_published.setText(date_published);
      holder.Ttitle.setText(title);
      holder.Tdoi.setText(doi);
      Picasso.with(m_context).load(urlImg).into(holder.Tcover);
*/
        holder.Tissue_id.setText(" Id: "+milista.get(position).getIssue_id());
        holder.Tvolume.setText(" Volumen: "+milista.get(position).getVolume());
        holder.Tnumber.setText(" Numero: "+milista.get(position).getNumber());
        holder.Tdate_published.setText(" Fecha: "+milista.get(position).getDate_published());
        holder.Tyear.setText(" Año: "+milista.get(position).getYear());
        holder.Ttitle.setText(milista.get(position).getTitle());
        holder.Tdoi.setText(milista.get(position).getDoi());
        Glide.with(m_context).load(milista.get(position).getCover())
        .into(holder.Tcover);

    }

    @Override
    public int getItemCount() {
        return milista.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView Tcover;
        public TextView Tissue_id;
        public TextView Tvolume;
        public TextView Tnumber;
        public TextView Tyear;
        public TextView Tdate_published;
        public TextView Ttitle;
        public TextView Tdoi;
        //public TextView Tcover;
     public ViewHolder(View itemView){
         super(itemView);
         Tcover= itemView.findViewById(R.id.imgUsr);
         Tissue_id=itemView.findViewById(R.id.issue_id);
         Tvolume=itemView.findViewById(R.id.volume);
         Tnumber=itemView.findViewById(R.id.number);
         Tyear=itemView.findViewById(R.id.year);
         Tdate_published=itemView.findViewById(R.id.date_published);
         Ttitle=itemView.findViewById(R.id.title);
         Tdoi=itemView.findViewById(R.id.doi);
     }

 }
}
