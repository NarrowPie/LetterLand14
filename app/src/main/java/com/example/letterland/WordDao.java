package com.example.letterland;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insert(WordEntry wordEntry);

    @Query("SELECT * FROM words WHERE player = :playerName")
    List<WordEntry> getAllWordsForProfile(String playerName);

    @Query("SELECT * FROM words WHERE word = :wordText AND player = :playerName LIMIT 1")
    WordEntry findWordForProfile(String wordText, String playerName);

    @Query("SELECT * FROM words WHERE isStarred = 1 AND player = :playerName")
    List<WordEntry> getStarredWordsForProfile(String playerName);

    @Query("UPDATE words SET isStarred = :isStarred WHERE word = :wordText AND player = :playerName")
    void updateStarStatus(String wordText, String playerName, boolean isStarred);

    @Query("DELETE FROM words WHERE word = :wordText AND player = :playerName")
    void deleteWord(String wordText, String playerName);

    @Query("UPDATE words SET player = :newName WHERE player = :oldName")
    void updatePlayerName(String oldName, String newName);
}