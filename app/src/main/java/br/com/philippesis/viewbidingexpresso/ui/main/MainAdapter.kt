package br.com.philippesis.viewbidingexpresso.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.philippesis.viewbidingexpresso.R
import kotlinx.android.synthetic.main.simple_name_list_item.view.*
import org.jetbrains.annotations.NotNull

class MainAdapter(@NotNull var names: MutableList<String>) : RecyclerView.Adapter<MainAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(parent)

    override fun getItemCount() = names.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindText(names[position])
    }

    class VH(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.simple_name_list_item, parent,false)
    ) {

        fun bindText(name: String) = with(itemView) {
            tfName.text = name
        }

    }

}