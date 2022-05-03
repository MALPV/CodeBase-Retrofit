package com.malpvaplicaciones.code_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.malpvaplicaciones.code_retrofit.data.network.model.Brawler
import com.malpvaplicaciones.code_retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    private val vm : MainVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val observerListBrawlers =
            Observer<MutableList<Brawler>>{ brawlers ->
                brawlers.forEach { brawler ->
                    Log.i(TAG, "__________________________BRAWLER___________________________")
                    Log.i(TAG, "id ${brawler.id} name ${brawler.name}")
                }
                Toast.makeText(this, "Cantidad de brawlers ${brawlers.size}", Toast.LENGTH_SHORT).show()
            }

        vm.brawlersList.observe(this, observerListBrawlers)

        val observerMessageError =
            Observer<String> { message ->
                Log.i(TAG, "__________________________ERROR___________________________")
                Log.i(TAG, message)
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }

        vm.messageError.observe(this, observerMessageError)

        binding.button.setOnClickListener {
            vm.getBrawlers()
        }
    }
}