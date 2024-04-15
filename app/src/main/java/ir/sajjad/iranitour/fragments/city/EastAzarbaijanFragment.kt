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
import ir.sajjad.iranitour.databinding.FragmentEastAzarbaijanBinding

class EastAzarbaijanFragment : Fragment() {
    lateinit var binding: FragmentEastAzarbaijanBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEastAzarbaijanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf<ItemPostCity>(
            ItemPostCity(
                1,
                resources.getString(R.string.azar_shahr),
                "https://s8.uupload.ir/files/mabade-sakhreiye-azarshahr1_agsc.jpg"
            ),
            ItemPostCity(
                2,
                resources.getString(R.string.osku),
                "https://s8.uupload.ir/files/کندوان_rc27.jpg"
            ),
            ItemPostCity(
                3,
                resources.getString(R.string.ahar),
                "https://s8.uupload.ir/files/aharnews-13990812-01_l4sa.jpg"
            ),
            ItemPostCity(
                4,
                resources.getString(R.string.bostan_abad),
                "https://s8.uupload.ir/files/-2147483648_-230239_aix3.jpg"
            ),
            ItemPostCity(
                5,
                resources.getString(R.string.bonab),
                "https://s8.uupload.ir/files/ت1-20_q26l.jpg"
            ),
            ItemPostCity(
                6,
                resources.getString(R.string.tabriz),
                "https://s8.uupload.ir/files/-2147483648_-227986_zx4m.jpg"
            ),
            ItemPostCity(
                7,
                resources.getString(R.string.jolfa),
                "https://s8.uupload.ir/files/6f021c1d2698f56ca16a053a_obrl.jpg"
            ),
            ItemPostCity(
                8,
                resources.getString(R.string.charavimaq),
                "https://s8.uupload.ir/files/untitled0_zfeo.jpg"
            ),
            ItemPostCity(
                10,
                resources.getString(R.string.khoda_afarin),
                "https://s8.uupload.ir/files/aynalo_h6l8.jpg"
            ),
            ItemPostCity(
                11,
                resources.getString(R.string.sarab),
                "https://s8.uupload.ir/files/9e4adc9b-a1b9-4683-8c14-b94cef7922e6_kxld.jpg"
            ),
            ItemPostCity(
                12,
                resources.getString(R.string.shabestar),
                "https://s8.uupload.ir/files/1200px-sohraghe_front_view_67tz.jpg"
            ),
            ItemPostCity(
                13,
                resources.getString(R.string.ajab_shir),
                "https://s8.uupload.ir/files/img_20240405_171509_724_imag.jpg"
            ),
            ItemPostCity(
                14,
                resources.getString(R.string.kalibar),
                "https://s8.uupload.ir/files/chaparpersiantravel-2_92lr.jpg"
            ),
            ItemPostCity(
                15,
                resources.getString(R.string.maragheh),
                "https://s8.uupload.ir/files/d9d46c611dbf4d4a941820dd24d9c121-ei_1655377598936_rb0j.jpg"
            ),
            ItemPostCity(
                16,
                resources.getString(R.string.marand),
                "https://s8.uupload.ir/files/-2147483648_-230393_dyau.jpg"
            ),
            ItemPostCity(
                17,
                resources.getString(R.string.malekan),
                "https://s8.uupload.ir/files/-2147483648_-230406_r0z3.jpg"
            ),
            ItemPostCity(
                18,
                resources.getString(R.string.miyaneh),
                "https://s8.uupload.ir/files/miyanehglem_nvqb.jpg"
            ),
            ItemPostCity(
                19,
                resources.getString(R.string.varzeqan),
                "https://s8.uupload.ir/files/golakhvor-waterfall_rezw.jpg"
            ),
            ItemPostCity(
                20,
                resources.getString(R.string.heris),
                "https://s8.uupload.ir/files/-230418_temp_s6rt.jpg"
            ),
            ItemPostCity(
                21,
                resources.getString(R.string.hashtrud),
                "https://s8.uupload.ir/files/554b264b-4289-435f-9e3drrr510c758f813b_smen.jpg"
            ),
            ItemPostCity(
                22,
                resources.getString(R.string.hurand),
                "https://s8.uupload.ir/files/unnamed-12_3bto.jpg"
            )

        )
        val adaptersCity = CityAdapters(data)
        binding.recyclerEastAzarbaijan.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding.recyclerEastAzarbaijan.adapter = adaptersCity
    }

}