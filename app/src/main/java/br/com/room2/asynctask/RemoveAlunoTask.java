package br.com.room2.asynctask;

import android.os.AsyncTask;

import br.com.room2.database.dao.AlunoDAO;
import br.com.room2.model.Aluno;
import br.com.room2.ui.adapter.ListaAlunosAdapter;

public class RemoveAlunoTask extends AsyncTask {
    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;
    private final Aluno aluno;
    public RemoveAlunoTask(AlunoDAO dao, ListaAlunosAdapter adapter,Aluno aluno) {

        this.dao = dao;
        this.adapter = adapter;
        this.aluno = aluno;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        dao.remove(aluno);
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        adapter.remove(aluno);
    }
}
