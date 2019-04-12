package br.org.venturus.starwarsapp.features.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.org.venturus.starwarsapp.R
import br.org.venturus.starwarsapp.databinding.ActivityCharacterListBinding
import br.org.venturus.starwarsapp.features.detail.CharacterDetailActivity

import kotlinx.android.synthetic.main.activity_character_list.*
import kotlinx.android.synthetic.main.content_character_list.*
import org.koin.android.ext.android.inject

class CharacterListActivity : AppCompatActivity() {

    private val mViewModel: CharacterListViewModel by inject()

    private lateinit var binding: ActivityCharacterListBinding

    private val layoutManager by lazy { LinearLayoutManager(applicationContext) }

    private lateinit var adapter: CharacterListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_character_list)

        setSupportActionBar(toolbar)

        binding.lifecycleOwner = this

        binding.viewModel = mViewModel

        adapter = CharacterListAdapter { character ->
            CharacterDetailActivity.startActivity(this, character.id)
        }

        characters_recycler_view.adapter = adapter
        characters_recycler_view.layoutManager = layoutManager

        mViewModel.loadCharacters()

        mViewModel.viewState.observe(this, Observer {
            it?.let { state -> adapter.setItems(it.charactersList) }
        })

    }

}
