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

        with(binding) {

            buttonDoAction.setOnClickListener {
                if (binding.inputText.text.toString().isNotEmpty()) {
                    names.add(binding.inputText.text.toString())
                    binding.inputText.setText("")
                    errorMsg.text = ""
                    mainAdapter.notifyDataSetChanged()
                } else {
                    errorMsg.text = getString(R.string.error_mandatory_field)
                }
            }

            buttonClearList.setOnClickListener {
                names.clear()
                mainAdapter.notifyDataSetChanged()
            }

        }

    }

    private fun setMainAdapter() {
        mainAdapter = MainAdapter(names, this)
        with(binding.recyclerNames) {
            setHasFixedSize(true)
            adapter = mainAdapter
        }
    }
}