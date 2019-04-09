package br.com.bossini.usjt_ccp3anmca_lista_chamados_helpdesk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ChamadoArrayAdapter extends
        ArrayAdapter <Chamado> {

    public ChamadoArrayAdapter (Context context, List<Chamado> chamados){
        super(context, -1, chamados);
    }
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        ViewHolder vh = null;

        if (convertView == null){
            Context context = getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            vh = new ViewHolder();
            vh.filaIconImageView = convertView.findViewById(R.id.filaIconImageView);
            vh.descricaoChamadoNaFilaTextView =
                    convertView.findViewById(R.id.descricaoChamadoTextView);
            vh.dataAberturaChamadoNaFilaTextView =
                    convertView.findViewById(R.id.dataAberturaChamadoTextView);
            vh.dataFechamentoChamadoNaFilaTextView =
                    convertView.findViewById(R.id.dataFechamentoChamadoTextView);
            vh.statusChamadoNaFilaTextView = convertView.findViewById(R.id.statusChamadoTextView);

            convertView.setTag(vh);
        }
        vh = (ViewHolder) convertView.getTag();
        Chamado caraDaVez = getItem (position);

        vh.filaIconImageView.setImageResource(caraDaVez.getFila().getIconId());
        vh.descricaoChamadoNaFilaTextView.setText(caraDaVez.getDescricao());
        vh.dataAberturaChamadoNaFilaTextView.setText(
                DateHelper.format(
                        caraDaVez.getDataAbertura()
                ));
        if (caraDaVez.getDataFechamento() != null){
            vh.dataFechamentoChamadoNaFilaTextView.setText(
                    DateHelper.format(
                            caraDaVez.getDataFechamento()
                    )
            );
        }
        vh.statusChamadoNaFilaTextView.setText(
                caraDaVez.getStatus()
        );

        return convertView;
    }
    private class ViewHolder{
        public ImageView filaIconImageView;
        public TextView statusChamadoNaFilaTextView;
        public TextView dataAberturaChamadoNaFilaTextView;
        public TextView dataFechamentoChamadoNaFilaTextView;
        public TextView descricaoChamadoNaFilaTextView;
    }
}
