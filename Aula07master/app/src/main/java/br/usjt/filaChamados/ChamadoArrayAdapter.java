package br.usjt.filaChamados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChamadoArrayAdapter extends ArrayAdapter<Chamado> {
    public ChamadoArrayAdapter(Context context, List<Chamado> chamados) {
        super(context, -1, chamados);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Chamado chamadoDaVez = getItem(position);
        Fila filaDaVez = chamadoDaVez.getFila();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        ViewHolder vh = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.list_item, parent,
                    false);
            vh = new ViewHolder();
            vh.filaIconImageView =
                    convertView.findViewById(R.id.filaIconImageView);
            vh.descricaoChamadoNaFilaTextView =
                    convertView.findViewById(R.id.descricaoChamadoNaFilaTextView);
            vh.statusChamadoNaFilaTextView =
                    convertView.findViewById(R.id.statusChamadoNaFilaTextView);
            vh.dataAberturaChamadoNaFilaTextView =
                    convertView.findViewById(R.id.dataAberturaChamadoNaFilaTextView);
            vh.dataFechamentoChamadoNaFilaTextView =
                    convertView.findViewById(R.id.dataFechamentoChamadoNaFilaTextView);
            convertView.setTag(vh);
        }
        vh = (ViewHolder) convertView.getTag();
        vh.filaIconImageView.setImageResource(filaDaVez.getIconId());
        vh.descricaoChamadoNaFilaTextView.setText(chamadoDaVez.getDescricao(
        ));
        vh.statusChamadoNaFilaTextView.setText(chamadoDaVez.getStatus());
        vh.dataAberturaChamadoNaFilaTextView.setText(DateHelper.format(chamadoDaVez.getDataAbertura()));
        if (chamadoDaVez.getDataFechamento() != null){
            vh.dataFechamentoChamadoNaFilaTextView.setText(DateHelper.format(chamadoDaVez.getDataFechamento()));
        }
        return convertView;
    }

    private class ViewHolder {
        public ImageView filaIconImageView;
        public TextView statusChamadoNaFilaTextView;
        public TextView dataAberturaChamadoNaFilaTextView;
        public TextView dataFechamentoChamadoNaFilaTextView;
        public TextView descricaoChamadoNaFilaTextView;
    }
}