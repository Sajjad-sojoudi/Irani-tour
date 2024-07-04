package ir.sajjad.iranitour.activity

import android.graphics.Typeface
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.data.ItemPostCity
import ir.sajjad.iranitour.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarMainDetails)

        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val dataCityPost =
            intent.getParcelableExtra<ItemPostCity>(SEND_CITY_DATA_TO_ACTIVITY_DETAILS)

        if (dataCityPost != null) {
            showData(dataCityPost)
        }

    }

    private fun showData(itemPostCity: ItemPostCity) {

        val shimmer = Shimmer.ColorHighlightBuilder()
            .setDuration(1500)
            .setDuration(1500)
            .setBaseAlpha(0.7f)
            .setHighlightAlpha(0.6f)
            .setBaseColor(ContextCompat.getColor(this, R.color.white)) // رنگ پایه (Base Color)
            .setHighlightColor(
                ContextCompat.getColor(
                    this,
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
            .with(this)
            .load(itemPostCity.imgCity)
            .placeholder(shimmerDrawable)
            .into(binding.imgDatailsCity)

        binding.txtCityName.text = itemPostCity.txtCity
        binding.sparkButton.isActivated = itemPostCity.isSave
        binding.sparkButton.pressOnTouch(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}