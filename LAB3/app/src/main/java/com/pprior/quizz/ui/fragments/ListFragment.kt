package com.pprior.quizz.ui.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.pprior.quizz.R
import com.pprior.quizz.databinding.FragmentListBinding
import com.pprior.quizz.ui.components.recyclerview.QuestionListAdapter
import com.pprior.quizz.ui.activities.QuestionTypeActivity
import com.pprior.quizz.ui.viewModels.QuestionViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ListFragment: Fragment() {

    private lateinit var viewModel: QuestionViewModel
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[QuestionViewModel::class.java]
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingApply()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getUpdates().collect { _ ->
                binding.fragmentListRecyclerView.adapter?.notifyDataSetChanged()
            }
        }

    }

    private fun bindingApply() {
        binding.apply {
            fab.setOnClickListener {
                startActivity(Intent(it.context, QuestionTypeActivity::class.java))
            }

            fragmentListRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, resources.getInteger(R.integer.column_number))
                adapter = QuestionListAdapter(viewModel)
            }
        }
    }

}