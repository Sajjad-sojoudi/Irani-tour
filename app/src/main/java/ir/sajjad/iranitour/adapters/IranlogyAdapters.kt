package ir.sajjad.iranitour.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.data.ItemPost
import ir.sajjad.iranitour.databinding.ItemIranlogyOstanBinding
import ir.sajjad.iranitour.interfaces.ItemEvents
import jp.wasabeef.transformers.glide.RoundedCornersTransformation

class IranlogyAdapters(private val data : ArrayList<ItemPost>, private val itemEvents: ItemEvents) : RecyclerView.Adapter<IranlogyAdapters.IranlogyViewHolder>() {
    lateinit var binding: ItemIranlogyOstanBinding
    inner class IranlogyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bindView(itemPost: ItemPost){
            binding.txtName.text = itemPost.txtName

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
                .load(itemPost.imgUrl)
                .placeholder(shimmerDrawable)
                .into(binding.imgOstan)

            binding.imgAboutUs.setOnClickListener {
                itemEvents.onImageClicked(itemPost)
            }

            binding.cardViewMain.setOnClickListener {
                itemEvents.onItemClicked(itemPost)
            }

            binding.imgOstan.setOnLongClickListener {
                itemEvents.onImageLongClicked(itemPost)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IranlogyViewHolder {
        binding = ItemIranlogyOstanBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return IranlogyViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: IranlogyViewHolder, position: Int) {
        holder.bindView(data[position])
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.item_enter_anim)
        holder.itemView.startAnimation(animation)
    }
}