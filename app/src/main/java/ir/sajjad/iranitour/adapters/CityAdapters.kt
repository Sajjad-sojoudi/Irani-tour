package ir.sajjad.iranitour.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.data.ItemPostCity
import ir.sajjad.iranitour.databinding.ItemIranlogyCityBinding

class CityAdapters(private val data: ArrayList<ItemPostCity>) :
    RecyclerView.Adapter<CityAdapters.CityViewHolder>() {
    lateinit var binding: ItemIranlogyCityBinding

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViews(itemPostCity: ItemPostCity) {

            binding.txtNameCity.text = itemPostCity.txtCity

            val shimmer = Shimmer.ColorHighlightBuilder()
                .setDuration(1500)
                .setDuration(1500)
                .setBaseAlpha(0.7f)
                .setHighlightAlpha(0.6f)
                .setBaseColor(ContextCompat.getColor(itemView.context, R.color.white)) // رنگ پایه (Base Color)
                .setHighlightColor(ContextCompat.getColor(itemView.context, R.color.shimmer_highlight)) // رنگ نور (Highlight Color)
                .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
                .setAutoStart(true)
                .build()


            val shimmerDrawable = ShimmerDrawable().apply {
                setShimmer(shimmer)
            }

            Glide
                .with(itemView.context)
                .load(itemPostCity.imgCity)
                .placeholder(shimmerDrawable)
                .into(binding.imgCity)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        binding =
            ItemIranlogyCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding.root)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.bindViews(data[position])

    }
}