package br.com.philippesis.viewbidingexpresso.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import br.com.philippesis.viewbidingexpresso.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private val names = mutableListOf<String>()
    private lateinit var mainAdapter: MainAdapter

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.setMainAdapter()

    }

    private fun setMainAdapter() {
        mainAdapter = MainAdapter(names)
            with(recyclerNames) {
                setHasFixedSize(true)
                adapter = mainAdapter
            }
    }

}