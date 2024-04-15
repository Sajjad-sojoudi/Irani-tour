package ir.sajjad.iranitour.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.sajjad.iranitour.fragments.city.GilanFragment
import ir.sajjad.iranitour.fragments.city.GolestanFragment
import ir.sajjad.iranitour.fragments.city.HamedanFragment
import ir.sajjad.iranitour.fragments.city.HormozganFragment
import ir.sajjad.iranitour.fragments.city.KermanshahFragment
import ir.sajjad.iranitour.fragments.city.KohgiloyehAndBoyerahmadFragment
import ir.sajjad.iranitour.fragments.city.LorestanFragment
import ir.sajjad.iranitour.fragments.city.MarkaziFragment
import ir.sajjad.iranitour.fragments.city.MazandaranFragment
import ir.sajjad.iranitour.fragments.city.FarsFragment
import ir.sajjad.iranitour.fragments.city.KermanFragment
import ir.sajjad.iranitour.fragments.city.KurdistanFragment
import ir.sajjad.iranitour.fragments.city.QazvinFragment
import ir.sajjad.iranitour.fragments.city.QomFragment
import ir.sajjad.iranitour.fragments.city.KhozestanFragment
import ir.sajjad.iranitour.fragments.city.NorthKhorasanFragment
import ir.sajjad.iranitour.fragments.city.BushehrFragment
import ir.sajjad.iranitour.fragments.city.IlamFragment
import ir.sajjad.iranitour.fragments.city.AlborzFragment
import ir.sajjad.iranitour.fragments.city.ArdabilFragment
import ir.sajjad.iranitour.fragments.city.EastAzarbaijanFragment
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.fragments.city.YazdFragment
import ir.sajjad.iranitour.fragments.city.SemnanFragment
import ir.sajjad.iranitour.fragments.city.SistanBaluchistanFragment
import ir.sajjad.iranitour.fragments.city.ZanjanFragment
import ir.sajjad.iranitour.fragments.city.ChaharMahalBakhtiariFragment
import ir.sajjad.iranitour.fragments.city.KhorasanRazaviFragment
import ir.sajjad.iranitour.fragments.city.SouthKhorasanFragment
import ir.sajjad.iranitour.fragments.city.WestAzarbaijanFragment
import ir.sajjad.iranitour.databinding.ActivityCityBinding
import ir.sajjad.iranitour.fragments.city.EsfahanFragment
import ir.sajjad.iranitour.fragments.city.TehranFragment

class CityActivity : AppCompatActivity() {
    lateinit var binding : ActivityCityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarMain)

        binding.btnHome.setOnClickListener {
            val intentHome = Intent(this, MainActivity::class.java)
            startActivity(intentHome)
        }

        val fragmentName = intent.getStringExtra("fragmentName")

        if (fragmentName != null) {
            val transaction = supportFragmentManager.beginTransaction()
            when (fragmentName) {
                "EastAzarbaijanFragment" -> {
                    transaction.replace(R.id.frameLayoutCity, EastAzarbaijanFragment())
                    transaction.commit()
                }
                "WestAzarbaijanFragment" -> {
                    transaction.replace(R.id.frameLayoutCity, WestAzarbaijanFragment())
                    transaction.commit()
                }
                "Ardabil" -> {
                    transaction.replace(R.id.frameLayoutCity, ArdabilFragment())
                    transaction.commit()
                }
                "Esfahan" -> {
                    transaction.replace(R.id.frameLayoutCity, EsfahanFragment())
                    transaction.commit()
                }
                "Alborz" -> {
                    transaction.replace(R.id.frameLayoutCity, AlborzFragment())
                    transaction.commit()
                }
                "Ilam" -> {
                    transaction.replace(R.id.frameLayoutCity, IlamFragment())
                    transaction.commit()
                }
                "Bushehr" -> {
                    transaction.replace(R.id.frameLayoutCity, BushehrFragment())
                    transaction.commit()
                }
                "Tehran" -> {
                    transaction.replace(R.id.frameLayoutCity, TehranFragment())
                    transaction.commit()
                }
                "ChaharMahalBakhtiari" -> {
                    transaction.replace(R.id.frameLayoutCity, ChaharMahalBakhtiariFragment())
                    transaction.commit()
                }
                "SouthKhorasan" -> {
                    transaction.replace(R.id.frameLayoutCity, SouthKhorasanFragment())
                    transaction.commit()
                }
                "KhorasanRazavi" -> {
                    transaction.replace(R.id.frameLayoutCity, KhorasanRazaviFragment())
                    transaction.commit()
                }
                "NorthKhorasan" -> {
                    transaction.replace(R.id.frameLayoutCity, NorthKhorasanFragment())
                    transaction.commit()
                }
                "Khozestan" -> {
                    transaction.replace(R.id.frameLayoutCity, KhozestanFragment())
                    transaction.commit()
                }
                "Zanjan" -> {
                    transaction.replace(R.id.frameLayoutCity, ZanjanFragment())
                    transaction.commit()
                }
                "Semnan" -> {
                    transaction.replace(R.id.frameLayoutCity, SemnanFragment())
                    transaction.commit()
                }
                "SistanBaluchistan" -> {
                    transaction.replace(R.id.frameLayoutCity, SistanBaluchistanFragment())
                    transaction.commit()
                }
                "Fars" -> {
                    transaction.replace(R.id.frameLayoutCity, FarsFragment())
                    transaction.commit()
                }
                "Qazvin" -> {
                    transaction.replace(R.id.frameLayoutCity, QazvinFragment())
                    transaction.commit()
                }
                "Qom" -> {
                    transaction.replace(R.id.frameLayoutCity, QomFragment())
                    transaction.commit()
                }
                "Kurdistan" -> {
                    transaction.replace(R.id.frameLayoutCity, KurdistanFragment())
                    transaction.commit()
                }
                "Kerman" -> {
                    transaction.replace(R.id.frameLayoutCity, KermanFragment())
                    transaction.commit()
                }
                "Kermanshah" -> {
                    transaction.replace(R.id.frameLayoutCity, KermanshahFragment())
                    transaction.commit()
                }
                "KohgiloyehAndBoyerahmad" -> {
                    transaction.replace(R.id.frameLayoutCity, KohgiloyehAndBoyerahmadFragment())
                    transaction.commit()
                }
                "Golestan" -> {
                    transaction.replace(R.id.frameLayoutCity, GolestanFragment())
                    transaction.commit()
                }
                "Gilan" -> {
                    transaction.replace(R.id.frameLayoutCity, GilanFragment())
                    transaction.commit()
                }
                "Lorestan" -> {
                    transaction.replace(R.id.frameLayoutCity, LorestanFragment())
                    transaction.commit()
                }
                "Mazandaran" -> {
                    transaction.replace(R.id.frameLayoutCity, MazandaranFragment())
                    transaction.commit()
                }
                "Markazi" -> {
                    transaction.replace(R.id.frameLayoutCity, MarkaziFragment())
                    transaction.commit()
                }
                "Hormozgan" -> {
                    transaction.replace(R.id.frameLayoutCity, HormozganFragment())
                    transaction.commit()
                }
                "Hamedan" -> {
                    transaction.replace(R.id.frameLayoutCity, HamedanFragment())
                    transaction.commit()
                }
                "Yazd" -> {
                    transaction.replace(R.id.frameLayoutCity, YazdFragment())
                    transaction.commit()
                }
                else -> null

            }

        }

    }
}