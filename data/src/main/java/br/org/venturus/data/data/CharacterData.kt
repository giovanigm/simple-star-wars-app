package br.org.venturus.data.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters")
data class CharacterData(
    @PrimaryKey
    var id: Int = -1,
    var name : String = "",
    var height : String = "",
    var mass : String = "",

    @SerializedName("hair_color")
    var hairColor : String = "",

    @SerializedName("skin_color")
    var skinColor : String = "",

    @SerializedName("eye_color")
    var eyeColor : String = "",

    @SerializedName("birth_year")
    var birthYear : String = "",

    var gender : String = "",
    var homeworld : String = ""
)