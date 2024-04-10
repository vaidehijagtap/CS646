package com.pprior.quizz.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pprior.quizz.databinding.FragmentHeadBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HeadFragment : Fragment() {

    private lateinit var binding: FragmentHeadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeadBinding.inflate(inflater, container, false)
        return binding.root
    }

}