package br.com.philippesis.viewbidingexpresso

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.philippesis.viewbidingexpresso.databinding.SimpleNameListItemBinding
import org.jetbrains.annotations.NotNull

class MainAdapter(@NotNull var names: MutableList<String>, var mParent: MainActivity) : RecyclerView.Adapter<MainAdapter.VH>() {

    private lateinit var binding: SimpleNameListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        binding =
            SimpleNameListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun getItemCount() = names.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindText(names[position])

        holder.itemView.setOnClickListener {
            Toast.makeText(mParent, names[position], Toast.LENGTH_SHORT).show()
        }

    }

    class VH(binding: SimpleNameListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val nameText = binding.tfName

        fun bindText(name: String) {
            nameText.text = name
        }

    }

}