package ir.sajjad.iranitour.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.databinding.ActivityGuideBinding


class GuideActivity : AppCompatActivity() {
    lateinit var binding:ActivityGuideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // اینجا متن راهنما را می‌توانید به تناسب برنامه خود تغییر دهید
        val guideText = "در اینجا دستورالعمل‌های مربوط به برنامه خواهد آمد..."

        Handler(Looper.getMainLooper()).postDelayed({
            val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            binding.btnClose.startAnimation(fadeInAnimation)
            binding.btnClose.visibility = View.VISIBLE
        }, 2000)

        binding.btnClose.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, GuideActivity::class.java)
            context.startActivity(intent)
        }
    }

}
