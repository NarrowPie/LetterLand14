package com.example.letterland;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuizRecordDao {

    @Insert
    void insertRecord(QuizRecord record);

    @Query("SELECT * FROM quiz_records WHERE player = :playerName ORDER BY timestamp DESC")
    List<QuizRecord> getRecordsForProfile(String playerName);

    @Query("DELETE FROM quiz_records WHERE player = :playerName")
    void deleteRecordsForProfile(String playerName);

    @Query("UPDATE quiz_records SET player = :newName WHERE player = :oldName")
    void updatePlayerName(String oldName, String newName);
}