package com.example.RecyclerViewOnClickListenerUseListenerLambda

import RecyclerViewOnClickListenerUseListenerLambda.databinding.ItemSuperheroBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class HeroAdapter (private val SuperHero:List<SuperHero>, private val listener: (SuperHero) -> Unit): RecyclerView.Adapter<HeroAdapter.HeroHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val  binding =
            ItemSuperheroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(SuperHero[position],listener)


    }

    override fun getItemCount(): Int =SuperHero.size

    class HeroHolder(val binding: ItemSuperheroBinding):RecyclerView.ViewHolder(binding.root)
    {

        fun render(superHero: SuperHero, listener: (SuperHero) -> Unit) {
            binding.tvRealName.text=superHero.realName
            binding.tvSuperHeroName.text=superHero.superHeroName
            binding.tvPublisher.text=superHero.publisher
            Picasso.get().load(superHero.image).into(binding.ivHero)
           binding.root.setOnClickListener{listener(superHero)}

        }


    }
}