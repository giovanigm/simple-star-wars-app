package br.org.venturus.data.api

import br.org.venturus.data.data.CharacterData
import com.google.gson.annotations.SerializedName

class CharactersListResult {

    @SerializedName("characters")
    lateinit var characters: List<CharacterData>
}