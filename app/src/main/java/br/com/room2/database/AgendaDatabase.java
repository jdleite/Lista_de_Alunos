package br.com.room2.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import android.content.Context;

import br.com.room2.database.converter.ConversorCalendar;
import br.com.room2.database.converter.ConversorTipoTelefone;
import br.com.room2.database.dao.AlunoDAO;
import br.com.room2.database.dao.TelefoneDAO;
import br.com.room2.model.Aluno;
import br.com.room2.model.Telefone;

import static br.com.room2.database.AgendaMigrations.TODAS_MIGRATIONS;


@Database(entities = {Aluno.class, Telefone.class}, version = 6, exportSchema = false)
@TypeConverters({ConversorCalendar.class, ConversorTipoTelefone.class})
public abstract class AgendaDatabase extends RoomDatabase {

    private static final String NOME_BANCO_DE_DADOS = "agenda.db";
    public abstract AlunoDAO getAlunoDAO();
    public abstract TelefoneDAO getTelefoneDAO();

    public static AgendaDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, AgendaDatabase.class, NOME_BANCO_DE_DADOS)
                .addMigrations(TODAS_MIGRATIONS)
                .build();
    }

}
