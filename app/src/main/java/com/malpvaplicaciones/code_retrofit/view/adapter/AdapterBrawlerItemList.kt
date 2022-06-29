package com.malpvaplicaciones.code_retrofit.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.malpvaplicaciones.code_retrofit.R
import com.malpvaplicaciones.code_retrofit.data.network.model.Brawler
import com.malpvaplicaciones.code_retrofit.databinding.ItemBrawlerBinding
import com.squareup.picasso.Picasso
import kotlin.random.Random

class AdapterBrawlerItemList (
    private val brawlerList: MutableList<Brawler>,
    //private val onItemBrawlerClickListener: OnItemBrawlerClickListener
): RecyclerView.Adapter<AdapterBrawlerItemList.ViewHolderItemBrawler>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemBrawler {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_brawler, parent, false)
        return  ViewHolderItemBrawler(view)
    }

    inner class ViewHolderItemBrawler(view: View): RecyclerView.ViewHolder(view) {
        val bindingItemBrawler = ItemBrawlerBinding.bind(view)
    }

    override fun onBindViewHolder(holder: ViewHolderItemBrawler, position: Int) {
        val brawler = brawlerList[position]

        with(holder){
            Picasso.get()
                .load(brawler.image)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(bindingItemBrawler.imgItemBrawler)
            
            val num = Random.nextInt(1,3)

            bindingItemBrawler.imgItemBrawlerFavorite
                .visibility = if (num == 2) View.VISIBLE else View.GONE

            bindingItemBrawler.imgItemBrawlerNotFavorite
                .visibility = if (num != 2) View.VISIBLE else View.GONE

            bindingItemBrawler.tvItemBrawlerName.text = brawler.name
            bindingItemBrawler.tvItemBrawlerType.text = brawler.type.name
        }
    }

    override fun getItemCount(): Int = brawlerList.size

    interface OnItemBrawlerClickListener {
        fun onItemClick()
    }
}