package ir.sajjad.iranitour.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.network.NetworkChecker
import ir.sajjad.iranitour.databinding.ActivityLoadingBinding

class LoadingActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoadingBinding
    var isVisble = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        binding.loading.playAnimation()
        binding.loading.repeatCount = 3


        checkInternetConnection()
    }

    fun checkInternetConnection() {
        if (NetworkChecker(this).isInternetConnected) {
            binding.txtRetry.visibility = View.INVISIBLE


            Handler().postDelayed({
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
                finish()
            }, 3000)

        } else {
            Toast.makeText(this, resources.getString(R.string.no_internet), Toast.LENGTH_SHORT).show()
            isVisble = true
            binding.txtRetry.visibility = View.VISIBLE
            binding.txtRetry.setOnClickListener {
                isVisble = false
                checkInternetConnection()

                binding.loading.playAnimation()
                binding.loading.repeatCount = 2

            }

        }
    }
}
