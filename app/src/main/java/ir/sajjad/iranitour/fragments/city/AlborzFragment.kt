package ir.sajjad.iranitour.fragments.city

import android.app.AlertDialog
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
import ir.sajjad.iranitour.adapters.CityAdapters
import ir.sajjad.iranitour.data.ItemPostCity
import ir.sajjad.iranitour.databinding.FragmentAlborzBinding
import ir.sajjad.iranitour.databinding.ItemImageShowBinding
import ir.sajjad.iranitour.interfaces.ItemCityEvent

class AlborzFragment : Fragment(), ItemCityEvent {
    lateinit var binding: FragmentAlborzBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlborzBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf<ItemPostCity>(
            ItemPostCity(
                1,
                resources.getString(R.string.eshtehard),
                "",
                "",
                false
            ),
            ItemPostCity(
                2,
                resources.getString(R.string.charbagh),
                "",
                "",
                false
            ),
            ItemPostCity(
                3,
                resources.getString(R.string.savojbolagh),
                "",
                "",
                false
            ),
            ItemPostCity(
                4,
                resources.getString(R.string.taleqan),
                "",
                "",
                false
            ),
            ItemPostCity(
                5,
                resources.getString(R.string.fardis),
                "",
                "",
                false
            ),
            ItemPostCity(
                6,
                resources.getString(R.string.karaj),
                "",
                "",
                false
            ),
            ItemPostCity(
                7,
                resources.getString(R.string.nazarabad),
                "",
                "",
                false
            )

            )
        val adaptersCity = CityAdapters(data, this)
        binding.recyclerAlborz.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerAlborz.setHasFixedSize(true)
        binding.recyclerAlborz.adapter = adaptersCity
        val animation = AnimationUtils.loadAnimation(context, R.anim.item_enter_anim)
        val controller = LayoutAnimationController(animation)
        binding.recyclerAlborz.layoutAnimation = controller

    }

    override fun onItemClicked(itemPostCity: ItemPostCity) {
        Toast.makeText(context, itemPostCity.txtCity, Toast.LENGTH_SHORT).show()
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