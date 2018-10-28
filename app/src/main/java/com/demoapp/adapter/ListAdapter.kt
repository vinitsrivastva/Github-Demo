package com.demoapp.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demoapp.R
import com.demoapp.model.RepoData
import com.demoapp.ui.list.ListActivityMVP
import com.demoapp.util.StringUtil
import kotlinx.android.synthetic.main.item_layout.view.*

class ListAdapter(private val context: Context, private val list: List<RepoData>, fragment: Fragment,
                  private var itemView: ListActivityMVP.View) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            var post = list[position]

            holder.author.setText(post.author)
            holder.name.setText(post.name)
            holder.description.setText(post.description)
            holder.stars.setText(post.stars + " Stars")
            holder.starsToday.setText(post.currentPeriodStars + " stars today")
            holder.forks.setText(post.forks + " Forks")
            holder.language.setText(post.language)
            if (StringUtil.isEmpty(post.language))
                holder.language.visibility = View.GONE
            else
                holder.language.visibility = View.VISIBLE

            holder.layout!!.setOnClickListener {
                itemView.onItemSelected(post)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_layout, parent, false))
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val layout = view.itemLayout
        val author = view.txtAuthor
        val name = view.txtName
        val description = view.txtPostDesc
        val stars = view.txtStars
        val forks = view.txtForks
        val starsToday = view.txtStarsToday
        val language = view.txtLanguage
    }

    }