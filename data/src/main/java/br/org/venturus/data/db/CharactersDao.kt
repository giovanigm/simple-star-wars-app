package br.org.venturus.data.db

import androidx.room.*
import br.org.venturus.data.data.CharacterData
import io.reactivex.Single

@Dao
interface CharactersDao {

    @Query("SELECT * FROM characters")
    fun getCharacters(): Single<List<CharacterData>>

    @Query("SELECT * FROM characters WHERE id=:characterId")
    fun get(characterId: Int): Single<CharacterData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCharacter(character: CharacterData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllCharacters(characters: List<CharacterData>)

    @Delete
    fun removeCharacter(character: CharacterData)

    @Query("DELETE FROM characters")
    fun clear()
}