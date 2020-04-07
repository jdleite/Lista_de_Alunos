package br.com.room2.asynctask;

import android.os.AsyncTask;

import java.util.List;

import br.com.room2.database.dao.TelefoneDAO;
import br.com.room2.model.Aluno;
import br.com.room2.model.Telefone;

public class BuscaTodosTelefonesDoAlunoTask extends AsyncTask<Void, Void, List<Telefone>> {
    private final TelefoneDAO telefoneDao;
    private final Aluno aluno;
    private final TelefonesDoAlunoEncontradosListener listener;

    public BuscaTodosTelefonesDoAlunoTask(TelefoneDAO telefoneDao, Aluno aluno, TelefonesDoAlunoEncontradosListener listener) {
        this.telefoneDao = telefoneDao;
        this.aluno = aluno;
        this.listener = listener;
    }

    @Override
    protected List<Telefone> doInBackground(Void... voids) {


        return telefoneDao.buscarTodosTelefonesDoAluno(aluno.getId());

    }

    @Override
    protected void onPostExecute(List<Telefone> telefones) {
        super.onPostExecute(telefones);
        listener.quandoEncontrados(telefones);

    }

    public interface TelefonesDoAlunoEncontradosListener {
        void quandoEncontrados(List<Telefone> telefones);
    }
}
