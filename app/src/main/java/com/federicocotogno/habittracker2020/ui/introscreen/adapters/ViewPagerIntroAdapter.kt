package com.federicocotogno.habittracker2020.ui.introscreen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.federicocotogno.habittracker2020.R
import com.federicocotogno.habittracker2020.data.models.IntroView
import kotlinx.android.synthetic.main.intro_item_page.view.*

class ViewPagerIntroAdapter(introViews: List<IntroView>) :
    RecyclerView.Adapter<ViewPagerIntroAdapter.IntroViewHolder>() {

    private val list = introViews

    class IntroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        init {


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        return IntroViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.intro_item_page, parent, false))
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {

        val currentView = list[position]
        holder.itemView.iv_image_intro.setImageResource(currentView.image)
        holder.itemView.tv_description_intro.text = currentView.description

    }

    override fun getItemCount(): Int {
        return list.size
    }


}