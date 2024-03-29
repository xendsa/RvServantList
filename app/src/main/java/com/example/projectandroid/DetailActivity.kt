package com.example.projectandroid

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.projectandroid.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var heroData: Hero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        heroData = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("heroData", Hero::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("heroData")!!
            }

        binding.namechar.text = heroData.name
        binding.descchar.text = heroData.description
        binding.regionchar.text = heroData.Region
        Glide.with(this).load(heroData.photo).fitCenter().into(binding.imgchar)
    }
}