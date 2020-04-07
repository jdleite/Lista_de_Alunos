package br.com.room2.asynctask;

import br.com.room2.database.dao.AlunoDAO;
import br.com.room2.database.dao.TelefoneDAO;
import br.com.room2.model.Aluno;
import br.com.room2.model.Telefone;

public class SalvaAlunoTask extends BaseAlunoComTelefoneTask{

    private final AlunoDAO alunoDAO;
    private final Aluno aluno;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;
    private final TelefoneDAO telefoneDao;

    public SalvaAlunoTask(AlunoDAO alunoDAO,
                          Aluno aluno,
                          Telefone telefoneFixo,
                          Telefone telefoneCelular,
                          TelefoneDAO telefoneDao,
                          FinalizadaListener listener) {
        super(listener);
        this.alunoDAO = alunoDAO;
        this.aluno = aluno;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.telefoneDao = telefoneDao;
    }



    @Override
    protected Void doInBackground(Void... voids) {
        int alunoId = alunoDAO.salva(aluno).intValue();
        vinculaAlunoComTelefone(alunoId, telefoneFixo, telefoneCelular);
        telefoneDao.salva(telefoneFixo, telefoneCelular);
        return null;
    }




}
