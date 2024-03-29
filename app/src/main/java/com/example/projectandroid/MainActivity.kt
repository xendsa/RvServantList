package com.example.projectandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projectandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "FGO Chara"

        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about -> {
                val intentToAbout = Intent(this, AboutActivity::class.java)
                startActivity(intentToAbout)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showRecyclerList() {
        val listHeroAdapter = ListHeroAdapter()
        binding.rvHeroes.layoutManager = GridLayoutManager(this, 2)
        binding.rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.addHeroList(HeroData.heroList)
    }
}