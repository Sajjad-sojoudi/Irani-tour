package ir.sajjad.iranitour.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.data.ItemPostLandMark
import ir.sajjad.iranitour.databinding.ItemIranlogyCityBinding
import ir.sajjad.iranitour.interfaces.ItemEventLm

class LandmarkAdapters(private val data : ArrayList<ItemPostLandMark>, private val itemEventLm: ItemEventLm) : RecyclerView.Adapter<LandmarkAdapters.LandmarkViewHolder>() {
    lateinit var binding: ItemIranlogyCityBinding
    inner class LandmarkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(itemPostLandMark: ItemPostLandMark) {
            binding.txtNameCity.text = itemPostLandMark.txtNameOstLm

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
                .with(binding.root)
                .load(itemPostLandMark.imgUrlOstLm)
                .placeholder(shimmerDrawable)
                .into(binding.imgCity)



            binding.cardViewMain.setOnClickListener {
                itemEventLm.onItemLmClicked(itemPostLandMark)
            }

            binding.imgCity.setOnLongClickListener {
                itemEventLm.onImageLmLongClicked(itemPostLandMark)
                true
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkViewHolder {
        binding = ItemIranlogyCityBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarkViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: LandmarkViewHolder, position: Int) {
        holder.bindView(data[position])
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.item_enter_anim)
        holder.itemView.startAnimation(animation)
    }

}