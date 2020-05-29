package br.com.philippesis.viewbidingexpresso

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.philippesis.viewbidingexpresso.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private val names = mutableListOf<String>()
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.setMainAdapter()

        binding.buttonDoAction.setOnClickListener {
            names.add(binding.inputText.text.toString())
            binding.inputText.setText("")
            mainAdapter.notifyDataSetChanged()
        }

        binding.buttonClearList.setOnClickListener {
            names.clear()
            mainAdapter.notifyDataSetChanged()
        }

    }

    private fun setMainAdapter() {
        mainAdapter = MainAdapter(names)
        with(binding.recyclerNames) {
            setHasFixedSize(true)
            adapter = mainAdapter
        }
    }
}