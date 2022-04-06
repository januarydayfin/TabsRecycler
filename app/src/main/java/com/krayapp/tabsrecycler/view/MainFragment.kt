package com.krayapp.tabsrecycler.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.tabsrecycler.R
import com.krayapp.tabsrecycler.databinding.MainFragmentBinding
import com.krayapp.tabsrecycler.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.main_fragment) {
    private val viewBinding: MainFragmentBinding by viewBinding()
    private val viewModel: MainViewModel by viewModel()

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeTimer()
        viewModel.getTimer()
    }

    private fun renderTimer(array: IntArray) {
        viewBinding.timer.days.text = array[0].toString()
        viewBinding.timer.hours.text = array[1].toString()
        viewBinding.timer.minute.text = array[2].toString()
        viewBinding.timer.seconds.text = array[3].toString()
    }

    private fun observeTimer() {
        viewModel.timerLiveData.observe(viewLifecycleOwner) { renderTimer(it) }
    }
}
