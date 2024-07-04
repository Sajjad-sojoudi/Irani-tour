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
import ir.sajjad.iranitour.databinding.FragmentWestAzarbaijanBinding
import ir.sajjad.iranitour.databinding.ItemImageShowBinding
import ir.sajjad.iranitour.interfaces.ItemCityEvent


class WestAzarbaijanFragment : Fragment(),ItemCityEvent {
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
                "https://s8.uupload.ir/files/-2147483648_-228002_zd9p.jpg",
                "",
                false
            ),
            ItemPostCity(
                2,
                resources.getString(R.string.oshnavieh),
                "https://s8.uupload.ir/files/-2147483648_-230621_lyl0.jpg",
                "",
                false
            ),
            ItemPostCity(
                3,
                resources.getString(R.string.bokan),
                "https://s8.uupload.ir/files/simine-rood-bokan-3_0ael.jpg",
                "",
                false
            ),
            ItemPostCity(
                4,
                resources.getString(R.string.baroq),
                "https://s8.uupload.ir/files/untitled-1_rm9x.jpg",
                "",
                false
            ),
            ItemPostCity(
                5,
                resources.getString(R.string.piranshahr),
                "https://s8.uupload.ir/files/-2147483648_-230628_fak9.jpg",
                "",
                false
            ),
            ItemPostCity(
                6,
                resources.getString(R.string.poldasht),
                "https://s8.uupload.ir/files/ae193771-0dc2-4a86-906e-a355e4bb533a_vauy.jpg",
                "",
                false
            ),
            ItemPostCity(
                7,
                resources.getString(R.string.takab),
                "https://s8.uupload.ir/files/-2147483648_-230711_558u.jpg",
                "",
                false
            ),
            ItemPostCity(
                8,
                resources.getString(R.string.khoy),
                "https://s8.uupload.ir/files/3_9rd.jpg",
                "",
                false
            ),
            ItemPostCity(
                9,
                resources.getString(R.string.chaldoran),
                "https://s8.uupload.ir/files/1683356301_911_قره_کلیسای_آذربایجان_غربی_yut1.jpg",
                "",
                false
            ),
            ItemPostCity(
                10,
                resources.getString(R.string.chaharborj),
                "https://s8.uupload.ir/files/-2147483648_-230786_d61.jpg",
                "",
                false
            ),
            ItemPostCity(
                11,
                resources.getString(R.string.chaypareh),
                "https://s8.uupload.ir/files/-2147483648_-230718_qhwp.jpg",
                "",
                false
            ),
            ItemPostCity(
                12,
                resources.getString(R.string.shut),
                "https://s8.uupload.ir/files/-2147483648_-230721_dbbf.jpg",
                "",
                false
            ),

            ItemPostCity(
                13,
                resources.getString(R.string.sardasht),
                "https://s8.uupload.ir/files/۳چشمه-کانی-گراوان_dph.jpg",
                "",
                false
            ),
            ItemPostCity(
                14,
                resources.getString(R.string.salmas),
                "https://s8.uupload.ir/files/-2147483648_-230770_g2ij.jpg",
                "",
                false
            ),
            ItemPostCity(
                15,
                resources.getString(R.string.shahin_dej),
                "https://s8.uupload.ir/files/-2147483648_-230775_obed.jpg",
                "",
                false
            ),
            ItemPostCity(
                16,
                resources.getString(R.string.maku),
                "https://s8.uupload.ir/files/bagche_jog_hvot.jpg",
                "",
                false
            ),
            ItemPostCity(
                17,
                resources.getString(R.string.mahabad),
                "https://s8.uupload.ir/files/-2147483648_-230778_oiox.jpg",
                "",
                false
            ),
            ItemPostCity(
                18,
                resources.getString(R.string.miandoab),
                "https://s8.uupload.ir/files/حمام_طبیعی_حیدر_باغی_چشمه_دوه_اوچان_5jr.jpg",
                "",
                false
            ),
            ItemPostCity(
                19,
                resources.getString(R.string.naqadeh),
                "https://s8.uupload.ir/files/-2147483648_-230781_3mgz.jpg",
                "",
                false
            ),

            )
        val adaptersCity = CityAdapters(data,this)
        binding.recyclerWestAzarbaijan.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerWestAzarbaijan.setHasFixedSize(true)
        binding.recyclerWestAzarbaijan.adapter = adaptersCity
        val animation = AnimationUtils.loadAnimation(context, R.anim.item_enter_anim)
        val controller = LayoutAnimationController(animation)
        binding.recyclerWestAzarbaijan.layoutAnimation = controller

    }

    override fun onItemClicked(itemPostCity: ItemPostCity) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra(SEND_CITY_DATA_TO_ACTIVITY_DETAILS,itemPostCity)
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