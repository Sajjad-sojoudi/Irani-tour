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
import ir.sajjad.iranitour.databinding.FragmentKhozestanBinding
import ir.sajjad.iranitour.databinding.ItemImageShowBinding
import ir.sajjad.iranitour.interfaces.ItemCityEvent

class KhozestanFragment : Fragment(),ItemCityEvent {

    lateinit var binding: FragmentKhozestanBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKhozestanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf<ItemPostCity>(
            ItemPostCity(
                1,
                resources.getString(R.string.abadan),
                "",
                "",
                false
            ),
            ItemPostCity(
                2,
                resources.getString(R.string.omidiyeh),
                "",
                "",
                false
            ),
            ItemPostCity(
                3,
                resources.getString(R.string.andika),
                "",
                "",
                false
            ),
            ItemPostCity(
                4,
                resources.getString(R.string.andimeshk),
                "",
                "",
                false
            ),
            ItemPostCity(
                5,
                resources.getString(R.string.ahvaz),
                "",
                "",
                false
            ),
            ItemPostCity(
                6,
                resources.getString(R.string.izeh),
                "",
                "",
                false
            ),
            ItemPostCity(
                7,
                resources.getString(R.string.baghmalek),
                "",
                "",
                false
            ),
            ItemPostCity(
                8,
                resources.getString(R.string.bavi),
                "",
                "",
                false
            ),
            ItemPostCity(
                9,
                resources.getString(R.string.behbahan),
                "",
                "",
                false
            ),
            ItemPostCity(
                10,
                resources.getString(R.string.khorramshahr),
                "",
                "",
                false
            ),
            ItemPostCity(
                11,
                resources.getString(R.string.dezpart),
                "",
                "",
                false
            ),
            ItemPostCity(
                12,
                resources.getString(R.string.dezful),
                "",
                "",
                false
            ),
            ItemPostCity(
                13,
                resources.getString(R.string.dasht_e_azadegan),
                "",
                "",
                false
            ),
            ItemPostCity(
                14,
                resources.getString(R.string.ramshir),
                "",
                "",
                false
            ),
            ItemPostCity(
                15,
                resources.getString(R.string.ramhormoz),
                "",
                "",
                false
            ),
            ItemPostCity(
                16,
                resources.getString(R.string.shadegan),
                "",
                "",
                false
            ),
            ItemPostCity(
                17,
                resources.getString(R.string.shush),
                "",
                "",
                false
            ),
            ItemPostCity(
                18,
                resources.getString(R.string.shushtar),
                "",
                "",
                false
            ),
            ItemPostCity(
                19,
                resources.getString(R.string.gotvand),
                "",
                "",
                false
            ),
            ItemPostCity(
                20,
                resources.getString(R.string.lally),
                "",
                "",
                false
            ),
            ItemPostCity(
                21,
                resources.getString(R.string.mahshahr),
                "",
                "",
                false
            ),
            ItemPostCity(
                22,
                resources.getString(R.string.masjed_soleyman),
                "",
                "",
                false
            ),
            ItemPostCity(
                23,
                resources.getString(R.string.haftgel),
                "",
                "",
                false
            ),
            ItemPostCity(
                24,
                resources.getString(R.string.hendijan),
                "",
                "",
                false
            ),
            ItemPostCity(
                25,
                resources.getString(R.string.hoveyzeh),
                "",
                "",
                false
            )
        )
        val adaptersCity = CityAdapters(data,this)
        binding.recyclerKhozestan.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.recyclerKhozestan.adapter = adaptersCity
        val animation = AnimationUtils.loadAnimation(context, R.anim.item_enter_anim)
        val controller = LayoutAnimationController(animation)
        binding.recyclerKhozestan.layoutAnimation = controller
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