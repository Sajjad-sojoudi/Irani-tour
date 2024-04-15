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
import ir.sajjad.iranitour.databinding.FragmentEsfahanBinding


class EsfahanFragment : Fragment() {
    lateinit var binding: FragmentEsfahanBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEsfahanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf<ItemPostCity>(
            ItemPostCity(
                1,
                resources.getString(R.string.aran_and_bidgol),
                ""
            ),
            ItemPostCity(
                2,
                resources.getString(R.string.ardestan),
                ""
            ),
            ItemPostCity(
                3,
                resources.getString(R.string.esfahan),
                ""
            ),
            ItemPostCity(
                4,
                resources.getString(R.string.borkhar),
                ""
            ),
            ItemPostCity(
                5,
                resources.getString(R.string.bueen_and_miyandasht),
                ""
            ),
            ItemPostCity(
                6,
                resources.getString(R.string.tiran_and_korun),
                ""
            ),
            ItemPostCity(
                7,
                resources.getString(R.string.chadegan),
                ""
            ),
            ItemPostCity(
                8,
                resources.getString(R.string.khomeyni_shahr),
                ""
            ),
            ItemPostCity(
                9,
                resources.getString(R.string.khansar),
                ""
            ),
            ItemPostCity(
                10,
                resources.getString(R.string.khur_and_biabanak),
                ""
            ),
            ItemPostCity(
                11,
                resources.getString(R.string.semirom),
                ""
            ),
            ItemPostCity(
                12,
                resources.getString(R.string.shahin_Shahr_and_meymeh),
                ""
            ),
            ItemPostCity(
                13,
                resources.getString(R.string.shahreza),
                ""
            ),
            ItemPostCity(
                14,
                resources.getString(R.string.dehaqan),
                ""
            ),
            ItemPostCity(
                15,
                resources.getString(R.string.faridan),
                ""
            ),
            ItemPostCity(
                16,
                resources.getString(R.string.fereydun_shahr),
                ""
            ),
            ItemPostCity(
                17,
                resources.getString(R.string.falavarjan),
                ""
            ),
            ItemPostCity(
                18,
                resources.getString(R.string.kashan),
                ""
            ),
            ItemPostCity(
                19,
                resources.getString(R.string.golpayegan),
                ""
            ),
            ItemPostCity(
                20,
                resources.getString(R.string.lenjan),
                ""
            ),
            ItemPostCity(
                21,
                resources.getString(R.string.mobarakeh),
                ""
            ),
            ItemPostCity(
                22,
                resources.getString(R.string.naeen),
                ""
            ),
            ItemPostCity(
                23,
                resources.getString(R.string.najafabad),
                ""
            ),
            ItemPostCity(
                24,
                resources.getString(R.string.natanz),
                ""
            )
        )
        val adaptersCity = CityAdapters(data)
        binding.recyclerEsfahan.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.recyclerEsfahan.adapter = adaptersCity
    }

}