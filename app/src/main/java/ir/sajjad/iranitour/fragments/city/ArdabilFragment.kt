package ir.sajjad.iranitour.fragments.city

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.adapters.CityAdapters
import ir.sajjad.iranitour.data.ItemPostCity
import ir.sajjad.iranitour.databinding.FragmentArdabilBinding

class ArdabilFragment : Fragment() {
    lateinit var binding: FragmentArdabilBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentArdabilBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf<ItemPostCity>(
            ItemPostCity(
                1,
                resources.getString(R.string.ardabil),
                ""
            ),
            ItemPostCity(
                2,
                resources.getString(R.string.aslan_duz),
                ""
            ),
            ItemPostCity(
                3,
                resources.getString(R.string.ongut),
                ""
            ),
            ItemPostCity(
                4,
                resources.getString(R.string.bileh_savar),
                ""
            ),
            ItemPostCity(
                5,
                resources.getString(R.string.parsabad),
                ""
            ),
            ItemPostCity(
                6,
                resources.getString(R.string.khalkhal),
                ""
            ),
            ItemPostCity(
                7,
                resources.getString(R.string.sareyn),
                ""
            ),
            ItemPostCity(
                8,
                resources.getString(R.string.kowsar),
                ""
            ),
            ItemPostCity(
                9,
                resources.getString(R.string.germi),
                ""
            ),
            ItemPostCity(
                10,
                resources.getString(R.string.meshginshahr),
                ""
            ),
            ItemPostCity(
                11,
                resources.getString(R.string.namin),
                ""
            ),
            ItemPostCity(
                12,
                resources.getString(R.string.nir),
                ""
            )
            )
        val adaptersCity = CityAdapters(data)
        binding.recyclerArdabil.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.recyclerArdabil.adapter = adaptersCity
    }
}