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
import ir.sajjad.iranitour.databinding.FragmentWestAzarbaijanBinding


class WestAzarbaijanFragment : Fragment() {
    lateinit var binding: FragmentWestAzarbaijanBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWestAzarbaijanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf<ItemPostCity>(
            ItemPostCity(
                1,
                resources.getString(R.string.urmia),
                "https://s8.uupload.ir/files/-2147483648_-228002_zd9p.jpg"
            ),
            ItemPostCity(
                2,
                resources.getString(R.string.oshnavieh),
                "https://s8.uupload.ir/files/-2147483648_-230621_lyl0.jpg"
            ),
            ItemPostCity(
                3,
                resources.getString(R.string.bokan),
                "https://s8.uupload.ir/files/simine-rood-bokan-3_0ael.jpg"
            ),
            ItemPostCity(
                4,
                resources.getString(R.string.baroq),
                "https://s8.uupload.ir/files/untitled-1_rm9x.jpg"
            ),
            ItemPostCity(
                5,
                resources.getString(R.string.piranshahr),
                "https://s8.uupload.ir/files/-2147483648_-230628_fak9.jpg"
            ),
            ItemPostCity(
                6,
                resources.getString(R.string.poldasht),
                "https://s8.uupload.ir/files/ae193771-0dc2-4a86-906e-a355e4bb533a_vauy.jpg"
            ),
            ItemPostCity(
                7,
                resources.getString(R.string.takab),
                "https://s8.uupload.ir/files/-2147483648_-230711_558u.jpg"
            ),
            ItemPostCity(
                8,
                resources.getString(R.string.khoy),
                "https://s8.uupload.ir/files/3_9rd.jpg"
            ),
            ItemPostCity(
                9,
                resources.getString(R.string.chaldoran),
                "https://s8.uupload.ir/files/1683356301_911_قره_کلیسای_آذربایجان_غربی_yut1.jpg"
            ),
            ItemPostCity(
                10,
                resources.getString(R.string.chaharborj),
                "https://s8.uupload.ir/files/-2147483648_-230786_d61.jpg"
            ),
            ItemPostCity(
                11,
                resources.getString(R.string.chaypareh),
                "https://s8.uupload.ir/files/-2147483648_-230718_qhwp.jpg"
            ),
            ItemPostCity(
                12,
                resources.getString(R.string.shut),
                "https://s8.uupload.ir/files/-2147483648_-230721_dbbf.jpg"
            ),

            ItemPostCity(
                13,
                resources.getString(R.string.sardasht),
                "https://s8.uupload.ir/files/۳چشمه-کانی-گراوان_dph.jpg"
            ),
            ItemPostCity(
                14,
                resources.getString(R.string.salmas),
                "https://s8.uupload.ir/files/-2147483648_-230770_g2ij.jpg"
            ),
            ItemPostCity(
                15,
                resources.getString(R.string.shahin_dej),
                "https://s8.uupload.ir/files/-2147483648_-230775_obed.jpg"
            ),
            ItemPostCity(
                16,
                resources.getString(R.string.maku),
                "https://s8.uupload.ir/files/bagche_jog_hvot.jpg"
            ),
            ItemPostCity(
                17,
                resources.getString(R.string.mahabad),
                "https://s8.uupload.ir/files/-2147483648_-230778_oiox.jpg"
            ),
            ItemPostCity(
                18,
                resources.getString(R.string.miandoab),
                "https://s8.uupload.ir/files/حمام_طبیعی_حیدر_باغی_چشمه_دوه_اوچان_5jr.jpg"
            ),
            ItemPostCity(
                19,
                resources.getString(R.string.naqadeh),
                "https://s8.uupload.ir/files/-2147483648_-230781_3mgz.jpg"
            ),

            )
        val adaptersCity = CityAdapters(data)
        binding.recyclerWestAzarbaijan.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerWestAzarbaijan.setHasFixedSize(true)
        binding.recyclerWestAzarbaijan.adapter = adaptersCity

    }
}