package com.example.resourceswin.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.resourceswin.R;
import com.example.resourceswin.model.tblrecursos;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<tblrecursos> listaAdapter;

    public Adapter(List<tblrecursos> lista) {
        this.listaAdapter = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {

        tblrecursos tblRecursos = listaAdapter.get(position);

        float ramColor = Float.parseFloat(tblRecursos.getMemoria_ram());
        float cpuColor = Float.parseFloat(tblRecursos.getCpu());
        float discoColor = Float.parseFloat(tblRecursos.getDisco());

        //Exibição dos itens
        holder.id.setText(tblRecursos.getId());
        holder.data_tmp.setText(tblRecursos.getData_tmp());

        //Verifica RAM para setar cor
        holder.memoria_ram.setText(tblRecursos.getMemoria_ram() + "%");
        if (ramColor >= 75) {
            holder.memoria_ram.setTextColor(Color.RED);
        }

        //Verifica CPU para setar cor
        holder.cpu.setText(tblRecursos.getCpu() + "%");
        if (cpuColor >= 75) {
            holder.cpu.setTextColor(Color.RED);
        }

        //Verifica DISCO para setar cor
        holder.disco.setText(tblRecursos.getDisco() + "%");
        if (discoColor <= 15) {
            holder.disco.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return listaAdapter.size();
    }

 

    public class MyViewHolder extends RecyclerView.ViewHolder { //Guarda os dados antes de exibir na tela
        TextView id;
        TextView memoria_ram;
        TextView cpu;
        TextView disco;
        TextView data_tmp;

        public MyViewHolder( View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.txtId);
            data_tmp = itemView.findViewById(R.id.txtData);
            memoria_ram = itemView.findViewById(R.id.txtRam);
            cpu = itemView.findViewById(R.id.txtCpu);
            disco = itemView.findViewById(R.id.txtDisco);

        }
    }

    public List<tblrecursos> getListaAdapter() {
        return listaAdapter;
    }

    public void setListaAdapter(List<tblrecursos> listaAdapter) {
        this.listaAdapter = listaAdapter;
    }
}
