package ir.sajjad.iranitour.fragments.bottom.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.sajjad.iranitour.databinding.FragmentLandMarkBinding


class LandMarkFragment : Fragment() {
    lateinit var binding: FragmentLandMarkBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLandMarkBinding.inflate(layoutInflater)
        return binding.root
    }

}