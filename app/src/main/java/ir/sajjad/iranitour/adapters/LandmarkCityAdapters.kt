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
import ir.sajjad.iranitour.data.ItemLandmarkDetails
import ir.sajjad.iranitour.data.ItemPostCity
import ir.sajjad.iranitour.databinding.ItemIranlogyCityBinding

class LandmarkCityAdapters(private val data:ArrayList<ItemLandmarkDetails>):RecyclerView.Adapter<LandmarkCityAdapters.LandmarkCityViewHolder>() {
    lateinit var binding:ItemIranlogyCityBinding
    inner class LandmarkCityViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bindViews(itemLandmarkDetails: ItemLandmarkDetails) {

            binding.txtNameCity.text = itemLandmarkDetails.txtNameLmDetails

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
                .load(itemLandmarkDetails.imgUrlLmDetails)
                .placeholder(shimmerDrawable)
                .into(binding.imgCity)

//            binding.cardViewMain.setOnClickListener {
//                itemCityEvent.onItemClicked(itemPostCity)
//            }
//
//            binding.imgCity.setOnLongClickListener {
//                itemCityEvent.onImageLongCLiked(itemPostCity)
//                true
//            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkCityViewHolder {
        binding = ItemIranlogyCityBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarkCityViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size

    }

    override fun onBindViewHolder(holder: LandmarkCityViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.bindViews(data[position])
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.item_enter_anim)
        holder.itemView.startAnimation(animation)
    }
}