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
import ir.sajjad.iranitour.databinding.FragmentKhorasanRrazaviBinding
import ir.sajjad.iranitour.databinding.ItemImageShowBinding
import ir.sajjad.iranitour.interfaces.ItemCityEvent


class KhorasanRazaviFragment : Fragment(), ItemCityEvent {
    lateinit var binding: FragmentKhorasanRrazaviBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKhorasanRrazaviBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf<ItemPostCity>(
            ItemPostCity(
                1,
                resources.getString(R.string.bakharz),
                "",
                "",
                false
            ),
            ItemPostCity(
                2,
                resources.getString(R.string.bajestan),
                "",
                "",
                false
            ),
            ItemPostCity(
                3,
                resources.getString(R.string.bardaskan),
                "",
                "",
                false
            ),
            ItemPostCity(
                4,
                resources.getString(R.string.taybad),
                "",
                "",
                false
            ),
            ItemPostCity(
                5,
                resources.getString(R.string.torbat_e_jam),
                "",
                "",
                false
            ),
            ItemPostCity(
                6,
                resources.getString(R.string.torbat_e_heydariyeh),
                "",
                "",
                false
            ),
            ItemPostCity(
                7,
                resources.getString(R.string.joghatay),
                "",
                "",
                false
            ),
            ItemPostCity(
                8,
                resources.getString(R.string.joveyn),
                "",
                "",
                false
            ),
            ItemPostCity(
                9,
                resources.getString(R.string.chenaran),
                "",
                "",
                false
            ),
            ItemPostCity(
                10,
                resources.getString(R.string.khalil_abad),
                "",
                "",
                false
            ),
            ItemPostCity(
                11,
                resources.getString(R.string.khaf),
                "",
                "",
                false
            ),
            ItemPostCity(
                12,
                resources.getString(R.string.khoshab),
                "",
                "",
                false
            ),
            ItemPostCity(
                13,
                resources.getString(R.string.davarzan),
                "",
                "",
                false
            ),
            ItemPostCity(
                14,
                resources.getString(R.string.dargaz),
                "",
                "",
                false
            ),
            ItemPostCity(
                15,
                resources.getString(R.string.roshtkhar),
                "",
                "",
                false
            ),
            ItemPostCity(
                16,
                resources.getString(R.string.zaveh),
                "",
                "",
                false
            ),
            ItemPostCity(
                17,
                resources.getString(R.string.zeberkhan),
                "",
                "",
                false
            ),
            ItemPostCity(
                18,
                resources.getString(R.string.sabzevar),
                "",
                "",
                false
            ),
            ItemPostCity(
                19,
                resources.getString(R.string.sarakhs),
                "",
                "",
                false
            ),
            ItemPostCity(
                20,
                resources.getString(R.string.sheshtamad),
                "",
                "",
                false
            ),
            ItemPostCity(
                21,
                resources.getString(R.string.salehabad),
                "",
                "",
                false
            ),
            ItemPostCity(
                22,
                resources.getString(R.string.torghabe_shandiz),
                "",
                "",
                false
            ),
            ItemPostCity(
                23,
                resources.getString(R.string.fariman),
                "",
                "",
                false
            ),
            ItemPostCity(
                24,
                resources.getString(R.string.firuzeh),
                "",
                "",
                false
            ),
            ItemPostCity(
                25,
                resources.getString(R.string.quchan),
                "",
                "",
                false
            ),
            ItemPostCity(
                26,
                resources.getString(R.string.kashmar),
                "",
                "",
                false
            ),
            ItemPostCity(
                27,
                resources.getString(R.string.kalat),
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
                resources.getString(R.string.gonabad),
                "",
                "",
                false
            ),
            ItemPostCity(
                30,
                resources.getString(R.string.mashhad),
                "",
                "",
                false
            ),
            ItemPostCity(
                31,
                resources.getString(R.string.mahvelat),
                "",
                "",
                false
            ),
            ItemPostCity(
                32,
                resources.getString(R.string.miyan_jolgeh),
                "",
                "",
                false
            ),
            ItemPostCity(
                33,
                resources.getString(R.string.neyshabur),
                "",
                "",
                false
            )
        )
        val adaptersCity = CityAdapters(data, this)
        binding.recyclerKhorasanRazavi.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerKhorasanRazavi.adapter = adaptersCity
        val animation = AnimationUtils.loadAnimation(context, R.anim.item_enter_anim)
        val controller = LayoutAnimationController(animation)
        binding.recyclerKhorasanRazavi.layoutAnimation = controller
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