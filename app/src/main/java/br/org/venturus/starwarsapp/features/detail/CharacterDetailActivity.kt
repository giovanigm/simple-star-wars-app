package br.org.venturus.starwarsapp.features.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.org.venturus.starwarsapp.R
import br.org.venturus.starwarsapp.databinding.ActivityCharacterDetailBinding

import org.koin.android.ext.android.inject

class CharacterDetailActivity : AppCompatActivity() {

    private val mViewModel: CharacterDetailViewModel by inject()

    private lateinit var binding: ActivityCharacterDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_character_detail)
        setSupportActionBar(binding.toolbar)
        binding.viewModel = mViewModel
        binding.lifecycleOwner = this

        supportActionBar?.title = ""

        mViewModel.loadCharacter(intent?.extras?.getInt(EXTRA_CHARACTER_ID)!!)
    }

    companion object {

        private const val EXTRA_CHARACTER_ID = "extra_id"

        fun startActivity(activity: Activity, characterId: Int) {
            val intent = Intent(activity, CharacterDetailActivity::class.java)
            intent.putExtra(EXTRA_CHARACTER_ID, characterId)
            activity.startActivity(intent)
        }

    }

}
