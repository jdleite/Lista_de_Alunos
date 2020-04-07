package br.com.room2.asynctask;

import android.os.AsyncTask;

import java.util.List;

import br.com.room2.database.dao.AlunoDAO;
import br.com.room2.model.Aluno;
import br.com.room2.ui.adapter.ListaAlunosAdapter;

public class BuscaAlunoTask extends AsyncTask<Void,Void,List<Aluno>> {
    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;

    public BuscaAlunoTask(AlunoDAO dao, ListaAlunosAdapter adapter) {
        this.dao = dao;
        this.adapter = adapter;
    }

    @Override
    protected List<Aluno> doInBackground(Void[] objects) {
       return dao.todos();
    }

    @Override
    protected void onPostExecute(List<Aluno> todosAlunos) {
        super.onPostExecute(todosAlunos);

        adapter.atualiza(todosAlunos);
    }
}
