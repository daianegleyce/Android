package br.usjt.filaChamados;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ChamadoRecyclerViewAdapter extends RecyclerView.Adapter<ChamadoViewHolder> {
    private List<Chamado> chamados;

    public ChamadoRecyclerViewAdapter (List <Chamado> chamados){
        this.chamados = chamados;
    }

    @NonNull
    @Override
    public ChamadoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        //ViewHolder sendo criado pela primeira vez.
        //inflamos a view, criamos o viewHolder e devolvemos para o RecyclerView
        View raiz =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup,
                        false);
        return new ChamadoViewHolder(raiz);
    }
    @Override
    public void onBindViewHolder(@NonNull ChamadoViewHolder chamadoViewHolder, int i) {
        //view holder sendo vinculado
        //ele já existe, basta colocar os dados de interesse (eles estão na posição i da coleção)
        Chamado chamadoDaVez = chamados.get(i);
        chamadoViewHolder.filaIconImageView.setImageResource(chamadoDaVez.getFila().getIconId
                ());
        chamadoViewHolder.descricaoChamadoNaFilaTextView.setText(chamadoDaVez.getDescricao());
        chamadoViewHolder.statusChamadoNaFilaTextView.setText(chamadoDaVez.getStatus());
        chamadoViewHolder.dataAberturaChamadoNaFilaTextView.setText(DateHelper.format(
                chamadoDaVez.getDataAbertura()));
        if (chamados.get(i).getDataFechamento() != null){
            chamadoViewHolder.dataFechamentoChamadoNaFilaTextView.setText(DateHelper.format(
                    chamadoDaVez.getDataFechamento()));
        }
    }
    @Override
    public int getItemCount() {
        return chamados.size();
    }
}