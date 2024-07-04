package ir.sajjad.iranitour.fragments.bottom.navigation

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.activity.LandmarkActivity
import ir.sajjad.iranitour.adapters.LandmarkAdapters
import ir.sajjad.iranitour.data.ItemPostLandMark
import ir.sajjad.iranitour.databinding.FragmentLandMarkBinding
import ir.sajjad.iranitour.databinding.ItemImageShowBinding
import ir.sajjad.iranitour.interfaces.ItemEventLm


class LandMarkFragment : Fragment(), ItemEventLm {
    lateinit var binding: FragmentLandMarkBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLandMarkBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showAllData()
    }

    private fun showAllData(){
        val data = arrayListOf<ItemPostLandMark>(
            ItemPostLandMark(
                id = 1,
                imgUrlOstLm = "https://s8.uupload.ir/files/-2147483648_-227984_talz.jpg",
                txtNameOstLm = resources.getString(R.string.east_azarbaijan),
            ),
            ItemPostLandMark(
                id = 2,
                imgUrlOstLm = "https://s8.uupload.ir/files/-2147483648_-228004_qbxp.jpg",
                txtNameOstLm = resources.getString(R.string.west_azarbaijan),
            ),
            ItemPostLandMark(
                id = 3,
                imgUrlOstLm = "https://s8.uupload.ir/files/-2147483648_-228006_p379.jpg",
                txtNameOstLm = resources.getString(R.string.ardabil),
            ),
            ItemPostLandMark(
                id = 4,
                imgUrlOstLm = "https://s8.uupload.ir/files/-2147483648_-228008_pqgw.jpg",
                txtNameOstLm = resources.getString(R.string.esfahan),
            ),
            ItemPostLandMark(
                id = 5,
                imgUrlOstLm = "https://s8.uupload.ir/files/aqesht-castle-alborz_elxo.jpg",
                txtNameOstLm = resources.getString(R.string.alborz),
            ),
            ItemPostLandMark(
                id = 6,
                imgUrlOstLm = "https://s8.uupload.ir/files/2wyfd41i5fk1pietaf6ll2ccqk0etl93g7sxt6cr_xmi.jpg",
                txtNameOstLm = resources.getString(R.string.ilam),
            ),
            ItemPostLandMark(
                id = 7,
                imgUrlOstLm = "https://s8.uupload.ir/files/a-very-beautiful-image-of-the-salt-dome-of-hormozgan-island_h8tm.jpg",
                txtNameOstLm = resources.getString(R.string.bushehr),
            ),
            ItemPostLandMark(
                id = 8,
                imgUrlOstLm  = "https://s8.uupload.ir/files/-2147483648_-227980_dab5.jpg",
                txtNameOstLm = resources.getString(R.string.tehran),
            ),
            ItemPostLandMark(
                id = 9,
                imgUrlOstLm = "https://s8.uupload.ir/files/ww_jm1z.jpg",
                txtNameOstLm = resources.getString(R.string.chahar_mahal_bakhtiari),
            ),
            ItemPostLandMark(
                id = 10,
                imgUrlOstLm = "https://s8.uupload.ir/files/8064c4f58ac7b91147c9d4bc5f32012e_db2g.jpg",
                txtNameOstLm = resources.getString(R.string.south_khorasan),
            ),
            ItemPostLandMark(
                id = 11,
                imgUrlOstLm = "https://s8.uupload.ir/files/-2147483648_-228020_4nrh.jpg",
                txtNameOstLm = resources.getString(R.string.khorasan_razavi),
            ),
            ItemPostLandMark(
                id = 12,
                imgUrlOstLm = "https://s8.uupload.ir/files/ayeneh_khaneh_(1)_v2fs.jpg",
                txtNameOstLm = resources.getString(R.string.north_khorasan),
            ),
            ItemPostLandMark(
                id = 13,
                imgUrlOstLm = "https://s8.uupload.ir/files/ahvaz-white-bridge_604l.jpg",
                txtNameOstLm = resources.getString(R.string.khozestan),
            ),
            ItemPostLandMark(
                id = 14,
                imgUrlOstLm = "https://s8.uupload.ir/files/-2147483648_-228615_1j4j.jpg",
                txtNameOstLm = resources.getString(R.string.zanjan),
            ),
            ItemPostLandMark(
                id = 15,
                imgUrlOstLm = "https://s8.uupload.ir/files/-2147483648_-228617_5yls.jpg",
                txtNameOstLm = resources.getString(R.string.semnan),
            ),
            ItemPostLandMark(
                id = 16,
                imgUrlOstLm = "https://s8.uupload.ir/files/بندر-چابهار-اصلی_2fme.png",
                txtNameOstLm = resources.getString(R.string.sistan_baluchistan),
            ),
            ItemPostLandMark(
                id = 17,
                imgUrlOstLm = "https://s8.uupload.ir/files/-2147483648_-228627_8ejr.jpg",
                txtNameOstLm = resources.getString(R.string.fars),
            ),
            ItemPostLandMark(
                id = 18,
                imgUrlOstLm = "https://s8.uupload.ir/files/qazvin_g0mi.jpg",
                txtNameOstLm = resources.getString(R.string.qazvin),
            ),
            ItemPostLandMark(
                id = 19,
                imgUrlOstLm = "https://s8.uupload.ir/files/-2147483648_-228697_jmsk.jpg",
                txtNameOstLm = resources.getString(R.string.qom),
            ),
            ItemPostLandMark(
                id = 20,
                imgUrlOstLm = "https://s8.uupload.ir/files/0dbe053c-0873-4b41-8210-165c192faa95_xk30.jpg",
                txtNameOstLm = resources.getString(R.string.kurdistan),
            ),
            ItemPostLandMark(
                id = 21,
                imgUrlOstLm = "https://s8.uupload.ir/files/01-41_1ca6.jpg",
                txtNameOstLm = resources.getString(R.string.kerman),
            ),
            ItemPostLandMark(
                id = 22,
                imgUrlOstLm = "https://s8.uupload.ir/files/cover_88tz.jpg",
                txtNameOstLm = resources.getString(R.string.kermanshah),
            ),
            ItemPostLandMark(
                id = 23,
                imgUrlOstLm = "https://s8.uupload.ir/files/img_20240323_224658_470_dbvo.jpg",
                txtNameOstLm = resources.getString(R.string.kohgiloyeh_and_boyerahmad),
            ),
            ItemPostLandMark(
                id = 24,
                imgUrlOstLm = "https://s8.uupload.ir/files/kaboodwall-waterfall_orln.jpg",
                txtNameOstLm = resources.getString(R.string.golestan),
            ),
            ItemPostLandMark(
                id = 25,
                imgUrlOstLm = "https://s8.uupload.ir/files/snnfvuihlkiyicsyj3wxx6mx2zntbulzk3lz57yx_8csk.jpg",
                txtNameOstLm = resources.getString(R.string.gilan),
            ),
            ItemPostLandMark(
                id = 26,
                imgUrlOstLm = "https://s8.uupload.ir/files/falak_-ol_-_aflak_castle_1._khoramabad-_lorestan_8iht.jpg",
                txtNameOstLm = resources.getString(R.string.lorestan),
            ),
            ItemPostLandMark(
                id = 27,
                imgUrlOstLm = "https://s8.uupload.ir/files/جاهای_دیدنی_جنگل_دالخانی_چیست؟_tasnim_1_lvao.jpg",
                txtNameOstLm = resources.getString(R.string.mazandaran),
            ),
            ItemPostLandMark(
                id = 28,
                imgUrlOstLm = "https://s8.uupload.ir/files/-2147483648_-228701_148h.jpg",
                txtNameOstLm = resources.getString(R.string.markazi),
            ),
            ItemPostLandMark(
                id = 29,
                imgUrlOstLm = "https://s8.uupload.ir/files/6-15_olj6.jpg",
                txtNameOstLm = resources.getString(R.string.hormozgan),
            ),
            ItemPostLandMark(
                id = 30,
                imgUrlOstLm = "https://s8.uupload.ir/files/mausoleum-of-avicenna-1000x670_8zkg.jpg",
                txtNameOstLm = resources.getString(R.string.hamedan),
            ),
            ItemPostLandMark(
                id = 31,
                imgUrlOstLm = "https://s8.uupload.ir/files/place_81_1_kleb.jpg",
                txtNameOstLm = resources.getString(R.string.yazd),
            )


        )
        val myAdapter = LandmarkAdapters (data,this)
        binding.recyclerLandmark.layoutManager = LinearLayoutManager(context,
            RecyclerView.VERTICAL,false)
        binding.recyclerLandmark.adapter = myAdapter
        val animation = AnimationUtils.loadAnimation(context, R.anim.item_enter_anim)
        val controller = LayoutAnimationController(animation)
        binding.recyclerLandmark.layoutAnimation = controller

        binding.recyclerLandmark.setHasFixedSize(true)
        binding.recyclerLandmark.setItemViewCacheSize(30)

    }

    override fun onItemLmClicked(itemPostLandMark: ItemPostLandMark) {
        val intent = Intent(context, LandmarkActivity::class.java)
        val fragmentName = when (itemPostLandMark.txtNameOstLm) {
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
            resources.getString(R.string.kerman) -> "kerman"
            resources.getString(R.string.kermanshah) -> "Kermanshah"
            resources.getString(R.string.kohgiloyeh_and_boyerahmad) -> "KohgiloyehAndBoyerahmad"
            resources.getString(R.string.golestan) -> "Golestan"
            resources.getString(R.string.gilan) -> "Gilan"
            resources.getString(R.string.lorestan) -> "Lorestan"
            resources.getString(R.string.mazandaran) -> "Mazandaran"
            resources.getString(R.string.markazi) -> "Markazi"
            resources.getString(R.string.hormozgan) -> "Hormozgan"
            resources.getString(R.string.hamedan) -> "Hamedan"
            resources.getString(R.string.yazd) -> "Yazd"

            else -> null
        }

        fragmentName?.let {// برای نال نبودن استفاده کردم
            intent.putExtra("fragmentName", it)
            startActivity(intent)
        }

    }

    override fun onImageLmLongClicked(itemPostLandMark: ItemPostLandMark) {
        val dialog = AlertDialog.Builder(context).create()
        val dialogImageShow = ItemImageShowBinding.inflate(layoutInflater)
        dialog.setView(dialogImageShow.root)
        dialog.show()

        val shimmer = Shimmer.ColorHighlightBuilder()
            .setDuration(1500)
            .setDuration(1500)
            .setBaseAlpha(0.7f)
            .setHighlightAlpha(0.6f)
            .setBaseColor(ContextCompat.getColor(requireContext(), R.color.white)) // رنگ پایه (Base Color)
            .setHighlightColor(ContextCompat.getColor(requireContext(), R.color.shimmer_highlight)) // رنگ نور (Highlight Color)
            .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
            .setAutoStart(true)
            .build()


        val shimmerDrawable = ShimmerDrawable().apply {
            setShimmer(shimmer)
        }

        Glide
            .with(dialogImageShow.root)
            .load(itemPostLandMark.imgUrlOstLm)
            .placeholder(shimmerDrawable)
            .into(dialogImageShow.imageShow)
    }


}