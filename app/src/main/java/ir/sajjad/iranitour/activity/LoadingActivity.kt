package ir.sajjad.iranitour.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import ir.sajjad.iranitour.databinding.ActivityLoadingBinding

class LoadingActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        val splashJson = binding.loading.playAnimation()
        binding.loading.repeatCount = 3

        Handler().postDelayed({
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 3000)
    }
}