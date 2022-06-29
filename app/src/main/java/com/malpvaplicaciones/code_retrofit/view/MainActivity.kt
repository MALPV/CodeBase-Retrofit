package com.malpvaplicaciones.code_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.malpvaplicaciones.code_retrofit.data.network.model.Brawler
import com.malpvaplicaciones.code_retrofit.databinding.ActivityMainBinding
import com.malpvaplicaciones.code_retrofit.view.adapter.AdapterBrawlerItemList

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    private val vm : MainVM by viewModels()

    private lateinit var adapterBrawler: AdapterBrawlerItemList
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        linearLayoutManager = LinearLayoutManager(this)

        val observerListBrawlers =
            Observer<MutableList<Brawler>>{ brawlers ->
                populateRecyclerView(brawlers)
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

        binding.btnRefresh.setOnClickListener {
            vm.getBrawlers()
        }
    }

    private fun populateRecyclerView(brawlers: MutableList<Brawler>){
        adapterBrawler = AdapterBrawlerItemList(brawlers)
        binding.listBrawlers.apply {
            layoutManager = linearLayoutManager
            adapter = adapterBrawler
        }
    }
}