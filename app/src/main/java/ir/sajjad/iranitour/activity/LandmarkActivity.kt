package ir.sajjad.iranitour.activity

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.databinding.ActivityLandmarkBinding
import ir.sajjad.iranitour.fragments.city.AlborzFragment
import ir.sajjad.iranitour.fragments.city.ArdabilFragment
import ir.sajjad.iranitour.fragments.city.BushehrFragment
import ir.sajjad.iranitour.fragments.city.ChaharMahalBakhtiariFragment
import ir.sajjad.iranitour.fragments.city.EastAzarbaijanFragment
import ir.sajjad.iranitour.fragments.city.EsfahanFragment
import ir.sajjad.iranitour.fragments.city.FarsFragment
import ir.sajjad.iranitour.fragments.city.GilanFragment
import ir.sajjad.iranitour.fragments.city.GolestanFragment
import ir.sajjad.iranitour.fragments.city.HamedanFragment
import ir.sajjad.iranitour.fragments.city.HormozganFragment
import ir.sajjad.iranitour.fragments.city.IlamFragment
import ir.sajjad.iranitour.fragments.city.KermanFragment
import ir.sajjad.iranitour.fragments.city.KermanshahFragment
import ir.sajjad.iranitour.fragments.city.KhorasanRazaviFragment
import ir.sajjad.iranitour.fragments.city.KhozestanFragment
import ir.sajjad.iranitour.fragments.city.KohgiloyehAndBoyerahmadFragment
import ir.sajjad.iranitour.fragments.city.KurdistanFragment
import ir.sajjad.iranitour.fragments.city.LorestanFragment
import ir.sajjad.iranitour.fragments.city.MarkaziFragment
import ir.sajjad.iranitour.fragments.city.MazandaranFragment
import ir.sajjad.iranitour.fragments.city.NorthKhorasanFragment
import ir.sajjad.iranitour.fragments.city.QazvinFragment
import ir.sajjad.iranitour.fragments.city.QomFragment
import ir.sajjad.iranitour.fragments.city.SemnanFragment
import ir.sajjad.iranitour.fragments.city.SistanBaluchistanFragment
import ir.sajjad.iranitour.fragments.city.SouthKhorasanFragment
import ir.sajjad.iranitour.fragments.city.TehranFragment
import ir.sajjad.iranitour.fragments.city.WestAzarbaijanFragment
import ir.sajjad.iranitour.fragments.city.YazdFragment
import ir.sajjad.iranitour.fragments.city.ZanjanFragment

class LandmarkActivity : AppCompatActivity() {
    lateinit var binding: ActivityLandmarkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBarLandmrk)

        binding.btnHome.setOnClickListener {
            val intentHome = Intent(this, MainActivity::class.java)
            val bundleAnimation = ActivityOptions.makeCustomAnimation(
                this,
                R.anim.slide_in_right,  // انیمیشن ورودی
                R.anim.slide_out_left   // انیمیشن خروجی
            ).toBundle()
            startActivity(intentHome, bundleAnimation)

        }
        val fragmentName = intent.getStringExtra("fragmentName")
        if (fragmentName != null) {
            val transaction = supportFragmentManager.beginTransaction()
            when (fragmentName) {
                "EastAzarbaijanFragment" -> {
                    transaction.replace(R.id.frameLayoutLanmark, EastAzarbaijanFragment())
                    transaction.commit()
                }
                "WestAzarbaijanFragment" -> {
                    transaction.replace(R.id.frameLayoutLanmark, WestAzarbaijanFragment())
                    transaction.commit()
                }
                "Ardabil" -> {
                    transaction.replace(R.id.frameLayoutLanmark, ArdabilFragment())
                    transaction.commit()
                }
                "Esfahan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, EsfahanFragment())
                    transaction.commit()
                }
                "Alborz" -> {
                    transaction.replace(R.id.frameLayoutLanmark, AlborzFragment())
                    transaction.commit()
                }
                "Ilam" -> {
                    transaction.replace(R.id.frameLayoutLanmark, IlamFragment())
                    transaction.commit()
                }
                "Bushehr" -> {
                    transaction.replace(R.id.frameLayoutLanmark, BushehrFragment())
                    transaction.commit()
                }
                "Tehran" -> {
                    transaction.replace(R.id.frameLayoutLanmark, TehranFragment())
                    transaction.commit()
                }
                "ChaharMahalBakhtiari" -> {
                    transaction.replace(R.id.frameLayoutLanmark, ChaharMahalBakhtiariFragment())
                    transaction.commit()
                }
                "SouthKhorasan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, SouthKhorasanFragment())
                    transaction.commit()
                }
                "KhorasanRazavi" -> {
                    transaction.replace(R.id.frameLayoutLanmark, KhorasanRazaviFragment())
                    transaction.commit()
                }
                "NorthKhorasan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, NorthKhorasanFragment())
                    transaction.commit()
                }
                "Khozestan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, KhozestanFragment())
                    transaction.commit()
                }
                "Zanjan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, ZanjanFragment())
                    transaction.commit()
                }
                "Semnan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, SemnanFragment())
                    transaction.commit()
                }
                "SistanBaluchistan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, SistanBaluchistanFragment())
                    transaction.commit()
                }
                "Fars" -> {
                    transaction.replace(R.id.frameLayoutLanmark, FarsFragment())
                    transaction.commit()
                }
                "Qazvin" -> {
                    transaction.replace(R.id.frameLayoutLanmark, QazvinFragment())
                    transaction.commit()
                }
                "Qom" -> {
                    transaction.replace(R.id.frameLayoutLanmark, QomFragment())
                    transaction.commit()
                }
                "Kurdistan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, KurdistanFragment())
                    transaction.commit()
                }
                "kerman" -> {
                    transaction.replace(R.id.frameLayoutLanmark, KermanFragment())
                    transaction.commit()
                }
                "Kermanshah" -> {
                    transaction.replace(R.id.frameLayoutLanmark, KermanshahFragment())
                    transaction.commit()
                }
                "KohgiloyehAndBoyerahmad" -> {
                    transaction.replace(R.id.frameLayoutLanmark, KohgiloyehAndBoyerahmadFragment())
                    transaction.commit()
                }
                "Golestan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, GolestanFragment())
                    transaction.commit()
                }
                "Gilan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, GilanFragment())
                    transaction.commit()
                }
                "Lorestan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, LorestanFragment())
                    transaction.commit()
                }
                "Mazandaran" -> {
                    transaction.replace(R.id.frameLayoutLanmark, MazandaranFragment())
                    transaction.commit()
                }
                "Markazi" -> {
                    transaction.replace(R.id.frameLayoutLanmark, MarkaziFragment())
                    transaction.commit()
                }
                "Hormozgan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, HormozganFragment())
                    transaction.commit()
                }
                "Hamedan" -> {
                    transaction.replace(R.id.frameLayoutLanmark, HamedanFragment())
                    transaction.commit()
                }
                "Yazd" -> {
                    transaction.replace(R.id.frameLayoutLanmark, YazdFragment())
                    transaction.commit()
                }
                else -> null

            }

        }



    }
}