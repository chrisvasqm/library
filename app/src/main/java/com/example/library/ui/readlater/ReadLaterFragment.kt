package com.example.library.ui.readlater

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.library.databinding.FragmentReadLaterBinding

class ReadLaterFragment : Fragment() {

    private var _binding: FragmentReadLaterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val readLaterViewModel: ReadLaterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentReadLaterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textReadLater
        readLaterViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}