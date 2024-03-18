package ir.sajjad.iranitour.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.sajjad.iranitour.databinding.FragmentSavedLocationBinding


class SavedLocationFragment : Fragment() {
    lateinit var binding: FragmentSavedLocationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSavedLocationBinding.inflate(layoutInflater)
        return binding.root
    }


}