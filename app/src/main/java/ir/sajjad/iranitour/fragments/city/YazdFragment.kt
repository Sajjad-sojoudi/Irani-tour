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
import ir.sajjad.iranitour.databinding.FragmentYazdBinding
import ir.sajjad.iranitour.databinding.ItemImageShowBinding
import ir.sajjad.iranitour.interfaces.ItemCityEvent

class YazdFragment : Fragment(), ItemCityEvent {
    lateinit var binding:FragmentYazdBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentYazdBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf<ItemPostCity>(
            ItemPostCity(
                1,
                resources.getString(R.string.abarkuh),
                "",
                "",
                false
            ),
            ItemPostCity(
                2,
                resources.getString(R.string.ardakan),
                "",
                "",
                false
            ),
            ItemPostCity(
                3,
                resources.getString(R.string.ashkezar),
                "",
                "",
                false
            ),
            ItemPostCity(
                4,
                resources.getString(R.string.bafg),
                "",
                "",
                false
            ),
            ItemPostCity(
                5,
                resources.getString(R.string.behabad),
                "",
                "",
                false
            ),
            ItemPostCity(
                6,
                resources.getString(R.string.taft),
                "",
                "",
                false
            ),
            ItemPostCity(
                7,
                resources.getString(R.string.zarach),
                "",
                "",
                false
            ),
            ItemPostCity(
                8,
                resources.getString(R.string.marvast),
                "",
                "",
                false
            ),
            ItemPostCity(
                9,
                resources.getString(R.string.mehriz),
                "",
                "",
                false
            ),
            ItemPostCity(
                10,
                resources.getString(R.string.meybod),
                "",
                "",
                false
            ),
            ItemPostCity(
                11,
                resources.getString(R.string.harat),
                "",
                "",
                false
            )
        )

        val adaptersCity = CityAdapters(data, this)
        binding.recyclerYazd.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerYazd.adapter = adaptersCity
        val animation = AnimationUtils.loadAnimation(context, R.anim.item_enter_anim)
        val controller = LayoutAnimationController(animation)
        binding.recyclerYazd.layoutAnimation = controller
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