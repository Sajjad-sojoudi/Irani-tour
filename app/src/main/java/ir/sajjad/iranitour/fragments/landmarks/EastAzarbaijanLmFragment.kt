package ir.sajjad.iranitour.fragments.landmarks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.databinding.FragmentEastAzarbaijanLmBinding


class EastAzarbaijanLmFragment : Fragment() {
    lateinit var binding:FragmentEastAzarbaijanLmBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEastAzarbaijanLmBinding.inflate(layoutInflater)
        return binding.root
    }


}