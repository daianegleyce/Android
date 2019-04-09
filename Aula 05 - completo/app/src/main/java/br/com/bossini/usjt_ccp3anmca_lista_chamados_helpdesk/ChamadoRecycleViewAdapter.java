package br.com.bossini.usjt_ccp3anmca_lista_chamados_helpdesk;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ChamadoRecycleViewAdapter extends RecyclerView.Adapter<ChamadoViewHolder> {

    private List<Chamado> chamados;

    public ChamadoRecycleViewAdapter (List <Chamado> chamado){
        this.chamados = chamados;
    }

    @Override
    public int getItemCount() {
        return chamados.size();
    }
    @NonNull
    @Override
    public ChamadoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View raiz = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.list_item, viewGroup,false);
        return new ChamadoViewHolder(raiz);
    }

    @Override
    public void onBindViewHolder(@NonNull ChamadoViewHolder chamadoViewHolder, int i) {
        Chamado chamadoDaVez = chamados.get(i);
        chamadoViewHolder.filaIconImageView.setImageResource(chamadoDaVez.getFila().getIconId());
        chamadoViewHolder.descricaoChamadoNaFilaTextView.setText(chamadoDaVez.getDescricao());
        chamadoViewHolder.statusChamadoNaFilaTextView.setText(chamadoDaVez.getStatus());
        chamadoViewHolder.dataAberturaChamadoNaFilaTextView.
                setText(DateHelper.format(chamadoDaVez.getDataAbertura()));
        if (chamados.get(i).getDataFechamento() != null) {

            chamadoViewHolder.dataFechamentoChamadoNaFilaTextView.
                    setText(DateHelper.format(chamadoDaVez.getDataFechamento()));

        }
    }
}
