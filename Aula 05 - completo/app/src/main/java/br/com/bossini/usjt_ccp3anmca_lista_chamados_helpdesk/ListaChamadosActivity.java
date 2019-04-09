package br.com.bossini.usjt_ccp3anmca_lista_chamados_helpdesk;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaChamadosActivity extends AppCompatActivity {

    private RecyclerView chamadosRecyclerView;
    private static Activity instancia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instancia = this;
        setContentView(R.layout.activity_lista_chamados);
        chamadosRecyclerView = findViewById(R.id.chamadosRecyclerView);
        chamadosRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent origemIntent =
                getIntent();
        String nomeFila = origemIntent.getStringExtra("nome_fila");
        final List <Chamado> chamados = busca(nomeFila);
        ChamadoRecycleViewAdapter adapter =
                new ChamadoRecycleViewAdapter(chamados);
        chamadosRecyclerView.setAdapter(adapter);
        /*chamadosRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chamado chamado = chamados.get(position);
                Intent intent = new Intent (instancia, DetalhesChamadoActivity.class);
                intent.putExtra("chamado_escolhido", chamado);
                startActivity(intent);
            }
        });
        */

    }




    public List <Chamado> busca (String nomeFila){
        List <Chamado> baseDeDados =
                geraListaChamados();
        if (nomeFila == null || nomeFila.isEmpty())
            return baseDeDados;
        List <Chamado> resultadoParcial =
                new ArrayList<>();
        for (Chamado chamado: baseDeDados){
            if (chamado.getFila().getNome().toLowerCase().
                    contains(nomeFila.toLowerCase())){
                resultadoParcial.add(chamado);
            }
        }
        return resultadoParcial;
    }

    public List<Chamado> geraListaChamados(){
        List<Chamado> chamados = new ArrayList<>();
        chamados.add(
            new Chamado (
                    new Fila ("Desktops", R.drawable.ic_computer_black_24dp),
                    "Computador da secretária quebrado.",
                    new Date(),
                    null,
                    "Aberto"

            )
        );
        chamados.add(
                new Chamado (
                        new Fila ("Telefonia", R.drawable.ic_phone_in_talk_black_24dp),
                        "Telefone não funciona.",
                        new Date(),
                        null,
                        "Aberto"

                )
        );
        chamados.add(new Chamado (
                new Fila ("Redes",
                        R.drawable.ic_network_check_black_24dp),
                "Manutenção no proxy.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Servidores", R.drawable.ic_poll_black_24dp),
                "Lentidão generalizada.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable.ic_new_releases_black_24dp),
                "CRM",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable.ic_new_releases_black_24dp),
                "Gestão de Orçamento",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Redes",
                        R.drawable.ic_network_check_black_24dp),
                "Internet com lentidão",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable.ic_new_releases_black_24dp),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable.ic_new_releases_black_24dp),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
        return chamados;
    }
}
