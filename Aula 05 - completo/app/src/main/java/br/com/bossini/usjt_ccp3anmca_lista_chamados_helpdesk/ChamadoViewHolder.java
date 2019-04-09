package br.com.bossini.usjt_ccp3anmca_lista_chamados_helpdesk;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChamadoViewHolder extends RecyclerView.ViewHolder {

    public ImageView filaIconImageView;
    public TextView statusChamadoNaFilaTextView;
    public TextView dataAberturaChamadoNaFilaTextView;
    public TextView dataFechamentoChamadoNaFilaTextView;
    public TextView descricaoChamadoNaFilaTextView;


    public ChamadoViewHolder(View v){
        super(v);
        filaIconImageView = v.findViewById(R.id.filaIconImageView);
        statusChamadoNaFilaTextView = v.findViewById(R.id.statusChamadoTextView);
        dataAberturaChamadoNaFilaTextView = v.findViewById(R.id.dataAberturaChamadoTextView);
        dataFechamentoChamadoNaFilaTextView = v.findViewById(R.id.dataFechamentoChamadoTextView);
        descricaoChamadoNaFilaTextView = v.findViewById(R.id.descricaoChamadoTextView);

    }
}
