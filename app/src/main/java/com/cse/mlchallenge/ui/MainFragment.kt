package com.cse.mlchallenge.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.cse.mlchallenge.R
import com.cse.mlchallenge.databinding.MainFragmentBinding
import com.cse.mlchallenge.utils.Status
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment)  {
    companion object {
        private const val TAG = "MainFragment"
        fun newInstance() = MainFragment()
    }
    private val viewModel: MainViewModel by viewModels({requireActivity()})
    private var searchQuery : String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = MainFragmentBinding.bind(view)

        binding.venueSearchEditText.setOnKeyListener { view, keyCode, _ ->  handleKeyEvent(view, keyCode) }

        binding.btnSearch.setOnClickListener {
            val query : String = binding.venueSearchEditText.text.toString()
            if (query.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Error: Please insert a place to search!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            Log.d(TAG, "setOnClickListener: ")
            viewModel.onSearchClicked(query)
        }

        viewModel.responseLiveData.observe(viewLifecycleOwner) {
            Log.d(TAG, "responseLiveData.observe: ")
            it?.apply {
                if (this.status == Status.ERROR) {
                    binding.progressBar.isVisible = false
                    Toast.makeText(requireContext(), "Error: ${this.message}", Toast.LENGTH_LONG)
                        .show()
                    return@observe
                } else if (this.status == Status.LOADING) {
                    binding.progressBar.isVisible = true
                } else if (this.status == Status.SUCCESS) {
                    binding.progressBar.isVisible = false
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.eventChannel.collect { event ->
                when (event) {
                    is MainViewModel.MainEvent.NavigateToItemsFragment -> {
                        Log.d(TAG, "event: NavigateToItemsFragment : ${event}")
                        requireActivity().supportFragmentManager.commit {
                            val action = MainFragmentDirections.actionMainFragmentToItemsFragment(searchQuery?:"")
                            findNavController().navigate(action)
                        }
                    }
                    is MainViewModel.MainEvent.NavigateToDetailsFragment -> {
                        Log.d(TAG, "event: NavigateToItemsFragment : ${event.results}")
                    }

                }

            }
        }
    }

    private fun handleKeyEvent(view: View, keyCode:Int):Boolean {
        searchQuery = (view as TextInputEditText).text.toString()
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE)  as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false

    }
}
