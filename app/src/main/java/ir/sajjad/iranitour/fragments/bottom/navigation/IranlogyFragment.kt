package ir.sajjad.iranitour.fragments.bottom.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.activity.CityActivity
import ir.sajjad.iranitour.adapters.IranlogyAdapters
import ir.sajjad.iranitour.data.ItemPost
import ir.sajjad.iranitour.databinding.FragmentIranlogyBinding
import ir.sajjad.iranitour.fragments.details.DetailsOstanFragment
import ir.sajjad.iranitour.interfaces.ItemEvents


class IranlogyFragment() : Fragment(),ItemEvents {
    lateinit var binding: FragmentIranlogyBinding
    lateinit var iranlogy : ArrayList<ItemPost>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentIranlogyBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences = requireContext().getSharedPreferences("iraniTour", Context.MODE_PRIVATE)

        showAllData()
    }

    private fun showAllData(){
        val data = arrayListOf<ItemPost>(
            ItemPost(
                id = 1,
                imgUrl = "https://s8.uupload.ir/files/-2147483648_-227984_talz.jpg",
                txtName = resources.getString(R.string.east_azarbaijan),
                txtDetails = resources.getString(R.string.east_azarbaijan_detail)
            ),
            ItemPost(
                id = 2,
                imgUrl = "https://s8.uupload.ir/files/-2147483648_-228004_qbxp.jpg",
                txtName = resources.getString(R.string.west_azarbaijan),
                txtDetails = resources.getString(R.string.west_azarbaijan_details)
            ),
            ItemPost(
                id = 3,
                imgUrl = "https://s8.uupload.ir/files/-2147483648_-228006_p379.jpg",
                txtName = resources.getString(R.string.ardabil),
                txtDetails = resources.getString(R.string.ardabil_details)
            ),
            ItemPost(
                id = 4,
                imgUrl = "https://s8.uupload.ir/files/-2147483648_-228008_pqgw.jpg",
                txtName = resources.getString(R.string.esfahan),
                txtDetails = resources.getString(R.string.esfahan_details)
            ),
            ItemPost(
                id = 5,
                imgUrl = "https://s8.uupload.ir/files/aqesht-castle-alborz_elxo.jpg",
                txtName = resources.getString(R.string.alborz),
                txtDetails = resources.getString(R.string.alborz_details)
            ),
            ItemPost(
                id = 6,
                imgUrl = "https://s8.uupload.ir/files/2wyfd41i5fk1pietaf6ll2ccqk0etl93g7sxt6cr_xmi.jpg",
                txtName = resources.getString(R.string.ilam),
                txtDetails = resources.getString(R.string.ilam_details)
            ),
            ItemPost(
                id = 7,
                imgUrl = "https://s8.uupload.ir/files/a-very-beautiful-image-of-the-salt-dome-of-hormozgan-island_h8tm.jpg",
                txtName = resources.getString(R.string.bushehr),
                txtDetails = resources.getString(R.string.bushehr_details)
            ),
            ItemPost(
                id = 8,
                imgUrl = "https://s8.uupload.ir/files/-2147483648_-227980_dab5.jpg",
                txtName = resources.getString(R.string.tehran),
                txtDetails = resources.getString(R.string.tehran_details)
            ),
            ItemPost(
                id = 9,
                imgUrl = "https://s8.uupload.ir/files/ww_jm1z.jpg",
                txtName = resources.getString(R.string.chahar_mahal_bakhtiari),
                txtDetails = resources.getString(R.string.chahar_mahal_bakhtiari_details)
            ),
            ItemPost(
                id = 10,
                imgUrl = "https://s8.uupload.ir/files/8064c4f58ac7b91147c9d4bc5f32012e_db2g.jpg",
                txtName = resources.getString(R.string.south_khorasan),
                txtDetails = resources.getString(R.string.south_khorasan_details)
            ),
            ItemPost(
                id = 11,
                imgUrl = "https://s8.uupload.ir/files/-2147483648_-228020_4nrh.jpg",
                txtName = resources.getString(R.string.khorasan_razavi),
                txtDetails = resources.getString(R.string.khorasan_razavi_details)
            ),
            ItemPost(
                id = 12,
                imgUrl = "https://s8.uupload.ir/files/ayeneh_khaneh_(1)_v2fs.jpg",
                txtName = resources.getString(R.string.north_khorasan),
                txtDetails = resources.getString(R.string.north_khorasan_details)
            ),
            ItemPost(
                id = 13,
                imgUrl = "https://s8.uupload.ir/files/ahvaz-white-bridge_604l.jpg",
                txtName = resources.getString(R.string.khozestan),
                txtDetails = resources.getString(R.string.khozestan_details)
            ),
            ItemPost(
                id = 14,
                imgUrl = "https://s8.uupload.ir/files/-2147483648_-228615_1j4j.jpg",
                txtName = resources.getString(R.string.zanjan),
                txtDetails = resources.getString(R.string.zanjan_details)
            ),
            ItemPost(
                id = 15,
                imgUrl = "https://s8.uupload.ir/files/-2147483648_-228617_5yls.jpg",
                txtName = resources.getString(R.string.semnan),
                txtDetails = resources.getString(R.string.semnan_details)
            ),
            ItemPost(
                id = 16,
                imgUrl = "https://s8.uupload.ir/files/بندر-چابهار-اصلی_2fme.png",
                txtName = resources.getString(R.string.sistan_baluchistan),
                txtDetails = resources.getString(R.string.sistan_baluchistan_details)
            ),
            ItemPost(
                id = 17,
                imgUrl = "https://s8.uupload.ir/files/-2147483648_-228627_8ejr.jpg",
                txtName = resources.getString(R.string.fars),
                txtDetails = resources.getString(R.string.fars_details)
            ),
            ItemPost(
                id = 18,
                imgUrl = "https://s8.uupload.ir/files/qazvin_g0mi.jpg",
                txtName = resources.getString(R.string.qazvin),
                txtDetails = resources.getString(R.string.qazvin_details)
            ),
            ItemPost(
                id = 19,
                imgUrl = "https://s8.uupload.ir/files/-2147483648_-228697_jmsk.jpg",
                txtName = resources.getString(R.string.qom),
                txtDetails = resources.getString(R.string.qom_details)
            ),
            ItemPost(
                id = 20,
                imgUrl = "https://s8.uupload.ir/files/0dbe053c-0873-4b41-8210-165c192faa95_xk30.jpg",
                txtName = resources.getString(R.string.kurdistan),
                txtDetails = resources.getString(R.string.kurdistan_datails)
            ),
            ItemPost(
                id = 21,
                imgUrl = "https://s8.uupload.ir/files/01-41_1ca6.jpg",
                txtName = resources.getString(R.string.kerman),
                txtDetails = resources.getString(R.string.kerman_details)
            ),
            ItemPost(
                id = 22,
                imgUrl = "https://s8.uupload.ir/files/cover_88tz.jpg",
                txtName = resources.getString(R.string.kermanshah),
                txtDetails = resources.getString(R.string.kermanshah_details)
            ),
            ItemPost(
                id = 23,
                imgUrl = "https://s8.uupload.ir/files/img_20240323_224658_470_dbvo.jpg",
                txtName = resources.getString(R.string.kohgiloyeh_and_boyerahmad),
                txtDetails = resources.getString(R.string.kohgiloyeh_and_boyerahmad_details)
            ),
            ItemPost(
                id = 24,
                imgUrl = "https://s8.uupload.ir/files/kaboodwall-waterfall_orln.jpg",
                txtName = resources.getString(R.string.golestan),
                txtDetails = resources.getString(R.string.golestan_details)
            ),
            ItemPost(
                id = 25,
                imgUrl = "https://s8.uupload.ir/files/snnfvuihlkiyicsyj3wxx6mx2zntbulzk3lz57yx_8csk.jpg",
                txtName = resources.getString(R.string.gilan),
                txtDetails = resources.getString(R.string.gilan_details)
            ),
            ItemPost(
                id = 26,
                imgUrl = "https://s8.uupload.ir/files/falak_-ol_-_aflak_castle_1._khoramabad-_lorestan_8iht.jpg",
                txtName = resources.getString(R.string.lorestan),
                txtDetails = resources.getString(R.string.lorestan_details)
            ),
            ItemPost(
                id = 27,
                imgUrl = "https://s8.uupload.ir/files/جاهای_دیدنی_جنگل_دالخانی_چیست؟_tasnim_1_lvao.jpg",
                txtName = resources.getString(R.string.mazandaran),
                txtDetails = resources.getString(R.string.mazandaran_details)
            ),
            ItemPost(
                id = 28,
                imgUrl = "https://s8.uupload.ir/files/-2147483648_-228701_148h.jpg",
                txtName = resources.getString(R.string.markazi),
                txtDetails = resources.getString(R.string.markazi_details)
            ),
            ItemPost(
                id = 29,
                imgUrl = "https://s8.uupload.ir/files/6-15_olj6.jpg",
                txtName = resources.getString(R.string.hormozgan),
                txtDetails = resources.getString(R.string.hormozgan_details)
            ),
            ItemPost(
                id = 30,
                imgUrl = "https://s8.uupload.ir/files/mausoleum-of-avicenna-1000x670_8zkg.jpg",
                txtName = resources.getString(R.string.hamedan),
                txtDetails = resources.getString(R.string.hamedan_details)
            ),
            ItemPost(
                id = 31,
                imgUrl = "https://s8.uupload.ir/files/place_81_1_kleb.jpg",
                txtName = resources.getString(R.string.yazd),
                txtDetails = resources.getString(R.string.yazd_details)
            )


        )
        val myAdapter = IranlogyAdapters (data,this)
        binding.recyclerIranlogy.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding.recyclerIranlogy.adapter = myAdapter
        binding.recyclerIranlogy.setHasFixedSize(true)
        binding.recyclerIranlogy.setItemViewCacheSize(30)

    }



    override fun onImageClicked(itemPost: ItemPost) {
        val bundle = Bundle()
        bundle.putString("sendImg",itemPost.imgUrl)
        bundle.putString("sendName", itemPost.txtName)
        bundle.putString("SendDetails", itemPost.txtDetails)

        val fragment = DetailsOstanFragment()
        fragment.arguments = bundle
        fragment.show(parentFragmentManager, "bottomSheet")
    }

    override fun onItemClicked(itemPost: ItemPost) {
        val intent = Intent(context, CityActivity::class.java)
        val fragmentName = when (itemPost.txtName) {
            resources.getString(R.string.east_azarbaijan) -> "EastAzarbaijanFragment"
            resources.getString(R.string.west_azarbaijan) -> "WestAzarbaijanFragment"
            resources.getString(R.string.ardabil) -> "Ardabil"
            resources.getString(R.string.esfahan) -> "Esfahan"
            resources.getString(R.string.alborz) -> "Alborz"
            resources.getString(R.string.ilam) -> "Ilam"
            resources.getString(R.string.bushehr) -> "Bushehr"
            resources.getString(R.string.tehran) -> "Tehran"
            resources.getString(R.string.chahar_mahal_bakhtiari) -> "ChaharMahalBakhtiari"
            resources.getString(R.string.south_khorasan) -> "SouthKhorasan"
            resources.getString(R.string.khorasan_razavi) -> "KhorasanRazavi"
            resources.getString(R.string.north_khorasan) -> "NorthKhorasan"
            resources.getString(R.string.khozestan) -> "Khozestan"
            resources.getString(R.string.zanjan) -> "Zanjan"
            resources.getString(R.string.semnan) -> "Semnan"
            resources.getString(R.string.sistan_baluchistan) -> "SistanBaluchistan"
            resources.getString(R.string.fars) -> "Fars"
            resources.getString(R.string.qazvin) -> "Qazvin"
            resources.getString(R.string.qom) -> "Qom"
            resources.getString(R.string.kurdistan) -> "Kurdistan"
            resources.getString(R.string.kerman) -> "Kerman"

            else -> null
        }

        fragmentName?.let {// برای نال نبودن استفاده کردم
            intent.putExtra("fragmentName", it)
            startActivity(intent)
        }


    }
}
