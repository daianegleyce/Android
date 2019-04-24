package br.usjt.filaChamados;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalhesChamadoActivity extends AppCompatActivity {
    private TextView nomeFilaTextView, descricaoChamadoTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_chamado);
        Intent origemIntent = getIntent();
        Chamado chamadoSelecionado =
                (Chamado)
                        origemIntent.getSerializableExtra("chamado_selecionado");
        ImageView filaIconImageView =
                findViewById(R.id.filaIconImageView);
        TextView descricaoChamadoNaFilaTextView =
                findViewById(R.id.descricaoChamadoNaFilaTextView);
        TextView statusChamadoNaFilaTextView =
                findViewById(R.id.statusChamadoNaFilaTextView);
        TextView dataAberturaChamadoNaFilaTextView =
                findViewById(R.id.dataAberturaChamadoNaFilaTextView);
        TextView dataFechamentoChamadoNaFilaTextView =
                findViewById(R.id.dataFechamentoChamadoNaFilaTextView);
        filaIconImageView.setImageResource(chamadoSelecionado.getFila().getIconId());
        descricaoChamadoNaFilaTextView.setText(chamadoSelecionado.getDescricao());
        statusChamadoNaFilaTextView.setText(chamadoSelecionado.getStatus());
        dataAberturaChamadoNaFilaTextView.setText(
                DateHelper.format(chamadoSelecionado.getDataAbertura()));
        if (chamadoSelecionado.getDataFechamento() != null){
            dataFechamentoChamadoNaFilaTextView.setText(
                    DateHelper.format(chamadoSelecionado.getDataFechamento()));
        }
    }
}