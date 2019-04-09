package br.com.bossini.usjt_ccp3anmca_lista_chamados_helpdesk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalhesChamadoActivity extends AppCompatActivity {

    private TextView nomeFilaTextView;
    private TextView descricaoChamadoTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_chamado);
        nomeFilaTextView = findViewById(R.id.nomeFilaTextView);
        descricaoChamadoTextView = findViewById(R.id.descricaoChamadoTextView);
        Intent origemIntent = getIntent();
        Chamado chamadoEscolhido = (Chamado)origemIntent.getSerializableExtra("chamado_escolhido");
        /*String [] partes = chamadoEscolhido.split(":");
        String nomeFila = partes[0];
        String descricaoChamado = partes[1];
        */
        nomeFilaTextView.setText(chamadoEscolhido.getFila().getNome());
        descricaoChamadoTextView.setText(chamadoEscolhido.getDescricao());

    }


}
