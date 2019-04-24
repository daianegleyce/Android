package br.usjt.filaChamados;

import android.provider.BaseColumns;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HelpDeskContract {

    private static List<Fila> filas;
    private static List<Chamado> chamados;

    static {
        //Inicio das filas
        filas = new ArrayList<>();
        filas.add(new Fila(1, "Desktops", R.drawable.ic_computer_black_24dp));
        filas.add(new Fila(2, "Telefonia", R.drawable.ic_phone_in_talk_black_24dp));
        filas.add(new Fila(3, "Redes", R.drawable.ic_network_check_black_24dp));
        filas.add(new Fila(4, "Servidores", R.drawable.ic_poll_black_24dp));
        filas.add(new Fila(5, "Novos projetos", R.drawable.ic_new_releases_black_24dp));
    }

    static {
        //Inicio dos chamados
        chamados = new ArrayList<>();
        chamados.add(new Chamado (
                1, filas.get(0),
                "Computador da secretária quebrado.",
                new Date(),
                null,
                "Aberto"
        ));
        chamados.add(new Chamado (
                2,
                filas.get(1),
                "Telefone não funciona.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                3,
                filas.get(2),
                "Manutenção no proxy.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                4,
                filas.get(3),
                "Lentidão generalizada.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (5,
                filas.get(4),
                "CRM",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                6,
                filas.get(4),
                "Gestão de Orçamento",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                7,
                filas.get(2),
                "Internet com lentidão",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                8,
                filas.get(4),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                9,
                filas.get(4),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
    }

    private HelpDeskContract() { }

    public static String insertFilas () {
        String template = "INSERT INTO %s (%s, %s, %s) VALUES (%d, '%s' , %d);";
        StringBuilder sb = new StringBuilder ("");
        for (Fila fila : filas){
            sb.append(
                    String.format(
                            Locale.getDefault(),
                            template,
                            FilaContract.TABLE_NAME,
                            FilaContract.COLUMN_NAME_ID,
                            FilaContract.COLUMN_NAME_NOME,
                            FilaContract.COLUMN_NAME_ICON_ID,
                            fila.getId(),
                            fila.getNome(),
                            fila.getIconId()
                    )
            );
        }
        return sb.toString();
    }

    public static String insertChamados () {
        String template = "INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (%d, '%s', %d, %d, '%s', %d); ";
        StringBuilder sb = new StringBuilder("");
        for (Chamado chamado : chamados) {
            sb.append(
                    String.format(
                            Locale.getDefault(),
                            template,
                            ChamadoContract.TABLE_NAME,
                            ChamadoContract.COLUMN_NAME_ID,
                            ChamadoContract.COLUMN_NAME_DESCRICAO,
                            ChamadoContract.COLUMN_NAME_DATA_ABERTURA,
                            ChamadoContract.COLUMN_NAME_DATA_FECHAMENTO,
                            ChamadoContract.COLUMN_NAME_STATUS,
                            FilaContract.COLUMN_NAME_ID,
                            chamado.getId(),
                            chamado.getDescricao(),
                            chamado.getDataAbertura().getTime(),
                            chamado.getDataFechamento() != null ?
                                    chamado.getDataFechamento().getTime() : 0,
                            chamado.getStatus(),
                            chamado.getFila().getId()
                    )
            );
        }
        return sb.toString();
    }

    public static class FilaContract implements BaseColumns {
        public static final String TABLE_NAME = "tb_fila";
        public static final String COLUMN_NAME_ID = "id_fila";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_ICON_ID = "icon_id";

        public static final String DROP_TABLE = String.format("DROP TABLE %s;", FilaContract.TABLE_NAME);
    }

    public static class ChamadoContract implements BaseColumns {
        public static final String TABLE_NAME = "tb_chamado";
        public static final String COLUMN_NAME_ID = "id_chamado";
        public static final String COLUMN_NAME_DESCRICAO = "descricao";
        public static final String COLUMN_NAME_STATUS = "status";
        public static final String COLUMN_NAME_DATA_ABERTURA = "dt_abertura";
        public static final String COLUMN_NAME_DATA_FECHAMENTO = "dt_fechamento";

        public static final String DROP_TABLE = String.format("DROP TABLE %s;", ChamadoContract.TABLE_NAME);
    }

    public static String createTableFila() {
        return String.format(
                Locale.getDefault(),
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER);",
                FilaContract.TABLE_NAME,
                FilaContract.COLUMN_NAME_ID,
                FilaContract.COLUMN_NAME_NOME,
                FilaContract.COLUMN_NAME_ICON_ID
        );
    }

    public static String createTableChamados() {
        return String.format(
                Locale.getDefault(),
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s INTEGER, %s INTEGER, %s INTEGER, FOREIGN KEY (%s) REFERENCES %s (%s));",
                ChamadoContract.TABLE_NAME,
                ChamadoContract.COLUMN_NAME_ID,
                ChamadoContract.COLUMN_NAME_DESCRICAO,
                ChamadoContract.COLUMN_NAME_STATUS,
                ChamadoContract.COLUMN_NAME_DATA_ABERTURA,
                ChamadoContract.COLUMN_NAME_DATA_FECHAMENTO,
                FilaContract.COLUMN_NAME_ID,
                FilaContract.COLUMN_NAME_ID,
                FilaContract.TABLE_NAME,
                FilaContract.COLUMN_NAME_ID
        );
    }
}
