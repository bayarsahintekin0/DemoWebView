package com.bayarsahintekin.demowebview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bayarsahintekin.demowebview.databinding.ActivityMainBinding
import com.bayarsahintekin.stars.view.IStarView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vStar.addStarInterface(object :IStarView{
            override fun bigStarButtonSelected() {

            }

            override fun smallStarButtonSelected() {

            }
        })

    }
}
