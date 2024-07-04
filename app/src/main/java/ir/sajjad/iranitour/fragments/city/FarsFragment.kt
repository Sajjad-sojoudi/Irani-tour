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
import ir.sajjad.iranitour.databinding.FragmentFarsBinding
import ir.sajjad.iranitour.databinding.ItemImageShowBinding
import ir.sajjad.iranitour.interfaces.ItemCityEvent


class FarsFragment : Fragment(), ItemCityEvent {
    lateinit var binding: FragmentFarsBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = FragmentFarsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf<ItemPostCity>(
            ItemPostCity(
                1,
                resources.getString(R.string.abade),
                "",
                "",
                false
            ),
            ItemPostCity(
                2,
                resources.getString(R.string.arsenjan),
                "",
                "",
                false
            ),
            ItemPostCity(
                3,
                resources.getString(R.string.estahban),
                "",
                "",
                false
            ),
            ItemPostCity(
                4,
                resources.getString(R.string.eqlid),
                "",
                "",
                false
            ),
            ItemPostCity(
                5,
                resources.getString(R.string.evaz),
                "",
                "",
                false
            ),
            ItemPostCity(
                6,
                resources.getString(R.string.bakhtegan),
                "",
                "",
                false
            ),
            ItemPostCity(
                7,
                resources.getString(R.string.bavanat),
                "",
                "",
                false
            ),
            ItemPostCity(
                8,
                resources.getString(R.string.beyza),
                "",
                "",
                false
            ),
            ItemPostCity(
                9,
                resources.getString(R.string.pasargad),
                "",
                "",
                false
            ),
            ItemPostCity(
                10,
                resources.getString(R.string.joyom),
                "",
                "",
                false
            ),
            ItemPostCity(
                11,
                resources.getString(R.string.jahrom),
                "",
                "",
                false
            ),
            ItemPostCity(
                12,
                resources.getString(R.string.kharameh),
                "",
                "",
                false
            ),
            ItemPostCity(
                13,
                resources.getString(R.string.khorrambid),
                "",
                "",
                false
            ),
            ItemPostCity(
                14,
                resources.getString(R.string.khafr),
                "",
                "",
                false
            ),
            ItemPostCity(
                15,
                resources.getString(R.string.darab),
                "",
                "",
                false
            ),
            ItemPostCity(
                16,
                resources.getString(R.string.rostam),
                "",
                "",
                false
            ),
            ItemPostCity(
                17,
                resources.getString(R.string.zarqan),
                "",
                "",
                false
            ),
            ItemPostCity(
                18,
                resources.getString(R.string.zarrin_dasht),
                "",
                "",
                false
            ),
            ItemPostCity(
                19,
                resources.getString(R.string.sepidan),
                "",
                "",
                false
            ),
            ItemPostCity(
                20,
                resources.getString(R.string.sarchehan),
                "",
                "",
                false
            ),
            ItemPostCity(
                21,
                resources.getString(R.string.sarvestan),
                "",
                "",
                false
            ),
            ItemPostCity(
                22,
                resources.getString(R.string.shiraz),
                "",
                "",
                false
            ),
            ItemPostCity(
                23,
                resources.getString(R.string.farashband),
                "",
                "",
                false
            ),
            ItemPostCity(
                24,
                resources.getString(R.string.fasa),
                "",
                "",
                false
            ),
            ItemPostCity(
                25,
                resources.getString(R.string.firuzabad),
                "",
                "",
                false
            ),
            ItemPostCity(
                26,
                resources.getString(R.string.qir_and_karzin),
                "",
                "",
                false
            ),
            ItemPostCity(
                27,
                resources.getString(R.string.kazerun),
                "",
                "",
                false
            ),
            ItemPostCity(
                28,
                resources.getString(R.string.kuhsorkh),
                "",
                "",
                false
            ),
            ItemPostCity(
                29,
                resources.getString(R.string.kavar),
                "",
                "",
                false
            ),
            ItemPostCity(
                30,
                resources.getString(R.string.kuhchenar),
                "",
                "",
                false
            ),
            ItemPostCity(
                31,
                resources.getString(R.string.gerash),
                "",
                "",
                false
            ),
            ItemPostCity(
                32,
                resources.getString(R.string.larestan),
                "",
                "",
                false
            ),
            ItemPostCity(
                33,
                resources.getString(R.string.lamerd),
                "",
                "",
                false
            ),
            ItemPostCity(
                34,
                resources.getString(R.string.marvdasht),
                "",
                "",
                false
            ),
            ItemPostCity(
                35,
                resources.getString(R.string.mamasani),
                "",
                "",
                false
            ),
            ItemPostCity(
                36,
                resources.getString(R.string.mohr),
                "",
                "",
                false
            ),
            ItemPostCity(
                37,
                resources.getString(R.string.neyriz),
                "",
                "",
                false
            )
        )
        val adaptersCity = CityAdapters(data, this)
        binding.recyclerFars.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerFars.adapter = adaptersCity
        val animation = AnimationUtils.loadAnimation(context, R.anim.item_enter_anim)
        val controller = LayoutAnimationController(animation)
        binding.recyclerFars.layoutAnimation = controller
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
            .setBaseColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            ) // رنگ پایه (Base Color)
            .setHighlightColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.shimmer_highlight
                )
            ) // رنگ نور (Highlight Color)
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