package com.cse.mlchallenge.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.cse.mlchallenge.R
import com.cse.mlchallenge.adapters.ResultAdapter
import com.cse.mlchallenge.data.Results
import com.cse.mlchallenge.databinding.FragmentItemsBinding
import com.cse.mlchallenge.utils.Status


class ItemsFragment : Fragment(R.layout.fragment_items), ResultAdapter.OnItemClickListener {
    private var query: String? = null
    lateinit var binding: FragmentItemsBinding
    private val viewModel: MainViewModel by viewModels({requireActivity()})
    private lateinit var resultAdapter : ResultAdapter

    val args:ItemsFragmentArgs by navArgs()

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            query = it.getString(ARG_QUERY)
//        }
//    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemsBinding.bind(view)

        binding.tvTextParm.text = getString(R.string.search_for, viewModel.q)

        setupRecyclerView()

        viewModel.responseLiveData.observe(viewLifecycleOwner) {
            Log.d(TAG, "responseLiveData: ")
            it?.apply {
                Log.d(TAG, "responseLiveData : ${this.status}")
                if (this.status == Status.SUCCESS) {
                    resultAdapter.results = this.data!!
                    binding.mainItemsEmptyText.isVisible = false
                    if (this.data == null || this.data.isEmpty()) {
                        binding.mainItemsEmptyText.isVisible = true
                        binding.rvResults.isVisible = false
                    } else {
                        binding.mainItemsEmptyText.isVisible = false
                        binding.rvResults.isVisible = true
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.eventChannel.collect { event ->
                when (event) {
                    is MainViewModel.MainEvent.NavigateToItemsFragment -> {
                        Log.d(TAG, "event: NavigateToItemsFragment : ${event}")
                    }
                    is MainViewModel.MainEvent.NavigateToDetailsFragment -> {
                        Log.d(TAG, "event: NavigateToItemsFragment : ${event.results}")


                    }

                }

            }
        }
    }

    private fun setupRecyclerView() = binding.rvResults.apply {
        resultAdapter   = ResultAdapter(requireContext(), this@ItemsFragment)
        adapter = resultAdapter
        layoutManager   = LinearLayoutManager(this@ItemsFragment.context)
    }

    companion object {
        private const val TAG = "PlacesFragment"
        private const val ARG_QUERY = "param"

//        @JvmStatic
//        fun newInstance(param: String) =
//            ItemsFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_QUERY, param)
//                }
//            }
    }

    override fun onItemClick(results: Results) {
        Log.d(TAG, "onItemClick: $results")
        //viewModel.onItemDetailClick(result)
        val action = ItemsFragmentDirections.actionItemsFragmentToDetailFragment(results)
        findNavController().navigate(action)
    }
}