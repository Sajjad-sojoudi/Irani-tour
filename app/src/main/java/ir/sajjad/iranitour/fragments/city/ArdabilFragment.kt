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
import ir.sajjad.iranitour.databinding.FragmentArdabilBinding
import ir.sajjad.iranitour.databinding.ItemImageShowBinding
import ir.sajjad.iranitour.interfaces.ItemCityEvent

class ArdabilFragment : Fragment(), ItemCityEvent {
    lateinit var binding: FragmentArdabilBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArdabilBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf<ItemPostCity>(
            ItemPostCity(
                1,
                resources.getString(R.string.ardabil),
                "https://s8.uupload.ir/files/shorabil_n1hl.jpg",
                "",
                false
            ),
            ItemPostCity(
                2,
                resources.getString(R.string.aslan_duz),
                "https://s8.uupload.ir/files/-2147483648_-231327_h3hb.jpg",
                "",
                false
            ),
            ItemPostCity(
                3,
                resources.getString(R.string.ongut),
                "https://s8.uupload.ir/files/معرفی-شهر-تازه-کند-انگوت-3_d59i.jpg",
                "",
                false
            ),
            ItemPostCity(
                4,
                resources.getString(R.string.bileh_savar),
                "https://s8.uupload.ir/files/-2147483648_-231329_3w0i.jpg",
                "",
                false
            ),
            ItemPostCity(
                5,
                resources.getString(R.string.parsabad),
                "https://s8.uupload.ir/files/-2147483648_-231334_rf8f.jpg",
                "",
                false
            ),
            ItemPostCity(
                6,
                resources.getString(R.string.khalkhal),
                "https://s8.uupload.ir/files/11cc2508-757b-433c-a030-43eb4a02ac25_qm3x.jpg",
                "",
                false
            ),
            ItemPostCity(
                7,
                resources.getString(R.string.sareyn),
                "https://s8.uupload.ir/files/b5d74cfc-fdc2-4bf3-9829-277e1fe031f2_xrs.jpg",
                "",
                false
            ),
            ItemPostCity(
                8,
                resources.getString(R.string.kowsar),
                "https://s8.uupload.ir/files/-2147483648_-231496_477i.jpg",
                "",
                false
            ),
            ItemPostCity(
                9,
                resources.getString(R.string.germi),
                "https://s8.uupload.ir/files/-2147483648_-231499_673w.jpg",
                "",
                false
            ),
            ItemPostCity(
                10,
                resources.getString(R.string.meshginshahr),
                "https://s8.uupload.ir/files/img_۲۰۲۴۰۴۱۸_۱۸۴۸۵۷_tyw1.jpg",
                "",
                false
            ),
            ItemPostCity(
                11,
                resources.getString(R.string.namin),
                "https://s8.uupload.ir/files/-2147483648_-231539_enrw.jpg",
                "",
                false
            ),
            ItemPostCity(
                12,
                resources.getString(R.string.nir),
                "https://s8.uupload.ir/files/img_۲۰۲۴۰۴۱۹_۰۹۳۲۵۹_efkk.jpg",
                "",
                false
            )
        )
        val adaptersCity = CityAdapters(data, this)
        binding.recyclerArdabil.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerArdabil.adapter = adaptersCity
        val animation = AnimationUtils.loadAnimation(context, R.anim.item_enter_anim)
        val controller = LayoutAnimationController(animation)
        binding.recyclerArdabil.layoutAnimation = controller
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