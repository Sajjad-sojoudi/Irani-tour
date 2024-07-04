package ir.sajjad.iranitour.fragments.city

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.activity.DetailsActivity
import ir.sajjad.iranitour.activity.SEND_CITY_DATA_TO_ACTIVITY_DETAILS
import ir.sajjad.iranitour.adapters.CityAdapters
import ir.sajjad.iranitour.data.ItemPostCity
import ir.sajjad.iranitour.databinding.FragmentEsfahanBinding
import ir.sajjad.iranitour.databinding.ItemImageShowBinding
import ir.sajjad.iranitour.interfaces.ItemCityEvent


class EsfahanFragment : Fragment(), ItemCityEvent {
    lateinit var binding: FragmentEsfahanBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEsfahanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf<ItemPostCity>(
            ItemPostCity(
                1,
                resources.getString(R.string.aran_and_bidgol),
                "https://s8.uupload.ir/files/-2147483648_-232909_4w0c.jpg",
                "",
                false
            ),
            ItemPostCity(
                2,
                resources.getString(R.string.ardestan),
                "https://s8.uupload.ir/files/کاخ_dzgl.jpg",
                "",
                false
            ),
            ItemPostCity(
                3,
                resources.getString(R.string.esfahan),
                "https://s8.uupload.ir/files/-2147483648_-232823_yilt.jpg",
                "",
                false
            ),
            ItemPostCity(
                4,
                resources.getString(R.string.borkhar),
                "https://s8.uupload.ir/files/-2147483648_-232918_cfke.jpg",
                "",
                false
            ),
            ItemPostCity(
                5,
                resources.getString(R.string.bueen_and_miyandasht),
                "https://s8.uupload.ir/files/575_449_kvhd.jpg",
                "",
                false
            ),
            ItemPostCity(
                6,
                resources.getString(R.string.tiran_and_korun),
                "https://s8.uupload.ir/files/-2147483648_-232963_5rdp.jpg",
                "",
                false
            ),
            ItemPostCity(
                7,
                resources.getString(R.string.chadegan),
                "https://s8.uupload.ir/files/abececee-5519-4a1d-b323-619c5f6e75ce_uavd.jpg",
                "",
                false
            ),
            ItemPostCity(
                8,
                resources.getString(R.string.khomeyni_shahr),
                "https://s8.uupload.ir/files/2024-01-14_o4mj.jpg",
                "",
                false
            ),
            ItemPostCity(
                9,
                resources.getString(R.string.khansar),
                "https://s8.uupload.ir/files/-2147483648_-232967_pidv.jpg",
                "",
                false
            ),
            ItemPostCity(
                10,
                resources.getString(R.string.khur_and_biabanak),
                "https://s8.uupload.ir/files/-2147483648_-232969_94z.jpg",
                "",
                false
            ),
            ItemPostCity(
                11,
                resources.getString(R.string.semirom),
                "https://s8.uupload.ir/files/076664fe-645d-4a21-a4c8-5b69b36e5487_gt58.jpg",
                "",
                false
            ),
            ItemPostCity(
                12,
                resources.getString(R.string.shahin_Shahr_and_meymeh),
                "https://s8.uupload.ir/files/-2147483648_-232972_4imh.jpg",
                "",
                false
            ),
            ItemPostCity(
                13,
                resources.getString(R.string.shahreza),
                "https://s8.uupload.ir/files/49487021658990224_750x450_s9fk.jpg",
                "",
                false
            ),
            ItemPostCity(
                14,
                resources.getString(R.string.dehaqan),
                "https://s8.uupload.ir/files/-2147483648_-232974_07jo.jpg",
                "",
                false
            ),
            ItemPostCity(
                15,
                resources.getString(R.string.faridan),
                "https://s8.uupload.ir/files/-2147483648_-232976_9jku.jpg",
                "",
                false
            ),
            ItemPostCity(
                16,
                resources.getString(R.string.fereydun_shahr),
                "https://s8.uupload.ir/files/آبشار-پونه-زار3_9xfy.png",
                "",
                false
            ),
            ItemPostCity(
                17,
                resources.getString(R.string.falavarjan),
                "https://s8.uupload.ir/files/1518813938_bkw5.jpg",
                "",
                false
            ),
            ItemPostCity(
                18,
                resources.getString(R.string.kashan),
                "https://s8.uupload.ir/files/abasian-1_ltgi.jpg",
                "",
                false
            ),
            ItemPostCity(
                19,
                resources.getString(R.string.golpayegan),
                "https://s8.uupload.ir/files/-2147483648_-232985_b2hg.jpg",
                "",
                false
            ),
            ItemPostCity(
                20,
                resources.getString(R.string.lenjan),
                "https://s8.uupload.ir/files/-2147483648_-232988_2ge8.jpg",
                "",
                false
            ),
            ItemPostCity(
                21,
                resources.getString(R.string.mobarakeh),
                "https://s8.uupload.ir/files/-2147483648_-232991_93b.jpg",
                "",
                false
            ),
            ItemPostCity(
                22,
                resources.getString(R.string.naeen),
                "https://s8.uupload.ir/files/1625387117_naein-10_guol.jpg",
                "",
                false
            ),
            ItemPostCity(
                23,
                resources.getString(R.string.najafabad),
                "https://s8.uupload.ir/files/noriyan-768x5120-1_(1)_of2n.jpg",
                "",
                false
            ),
            ItemPostCity(
                24,
                resources.getString(R.string.natanz),
                "https://s8.uupload.ir/files/غار-پریان_3jgq.jpg",
                "",
                false
            )
        )
        val adaptersCity = CityAdapters(data, this)
        binding.recyclerEsfahan.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerEsfahan.adapter = adaptersCity
        val animation = AnimationUtils.loadAnimation(context, R.anim.item_enter_anim)
        val controller = LayoutAnimationController(animation)
        binding.recyclerEsfahan.layoutAnimation = controller
    }

    override fun onItemClicked(itemPostCity: ItemPostCity) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra(SEND_CITY_DATA_TO_ACTIVITY_DETAILS, itemPostCity)
        startActivity(intent)
    }

    override fun onImageLongCLiked(itemPostCity: ItemPostCity) {
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
            .load(itemPostCity.imgCity)
            .placeholder(shimmerDrawable)
            .into(dialogImageShow.imageShow)
    }

}