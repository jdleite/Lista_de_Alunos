package br.com.room2.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.room2.model.Telefone;

@Dao
public interface TelefoneDAO {
    @Query("SELECT * FROM TELEFONE" +
            " WHERE alunoId = :alunoId LIMIT 1")
    Telefone BuscaPrimeiroTelefoneDoAluno(int alunoId);

    @Insert
    void salva(Telefone... telefones);

    @Query("SELECT * FROM TELEFONE" +
            " WHERE alunoId = :alunoId")
    List<Telefone> buscarTodosTelefonesDoAluno(int alunoId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void atualiza(Telefone... telefones);
}
