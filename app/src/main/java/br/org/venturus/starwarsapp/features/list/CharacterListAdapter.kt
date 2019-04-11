package br.org.venturus.starwarsapp.features.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.org.venturus.domain.characters.CharacterEntity
import br.org.venturus.starwarsapp.R
import br.org.venturus.starwarsapp.core.databinding.BindingHolder
import br.org.venturus.starwarsapp.databinding.ItemCharacterBinding

class CharacterListAdapter(private val onClick: (CharacterEntity) -> Unit?) :
    RecyclerView.Adapter<BindingHolder<ItemCharacterBinding>>()
{

    private val mCharactersList: MutableList<CharacterEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<ItemCharacterBinding> {
        val binding = DataBindingUtil.inflate<ItemCharacterBinding>(
            LayoutInflater.from(parent.context), R.layout.item_character, parent, false
        )

        return BindingHolder(binding)
    }

    override fun getItemCount(): Int = mCharactersList.size

    override fun onBindViewHolder(holder: BindingHolder<ItemCharacterBinding>, position: Int) {
        val binding = holder.binding

        binding.character = mCharactersList[position]
    }

    fun setItems(characters: Collection<CharacterEntity>) {
        characters.forEach { character ->
            mCharactersList.add(character)
            notifyItemInserted(mCharactersList.size)
        }
    }
}