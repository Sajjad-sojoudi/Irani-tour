package ir.sajjad.iranitour.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
                    val fragment = EastAzarbaijanFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "WestAzarbaijanFragment" -> {
                    val fragment = WestAzarbaijanFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Ardabil" -> {
                    val fragment = ArdabilFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Esfahan" -> {
                    val fragment = EsfahanFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Alborz" -> {
                    val fragment = AlborzFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Ilam" -> {
                    val fragment = IlamFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Bushehr" -> {
                    val fragment = BushehrFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Tehran" -> {
                    val fragment = TehranFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "ChaharMahalBakhtiari" -> {
                    val fragment = ChaharMahalBakhtiariFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "SouthKhorasan" -> {
                    val fragment = SouthKhorasanFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "KhorasanRazavi" -> {
                    val fragment = KhorasanRazaviFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "NorthKhorasan" -> {
                    val fragment = NorthKhorasanFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "khozestan" -> {
                    val fragment = KhozestanFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Zanjan" -> {
                    val fragment = ZanjanFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Semnan" -> {
                    val fragment = SemnanFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "SistanBaluchistan" -> {
                    val fragment = SistanBaluchistanFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Fars" -> {
                    val fragment = FarsFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Qazvin" -> {
                    val fragment = QazvinFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Qom" -> {
                    val fragment = QomFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Kurdistan" -> {
                    val fragment = KurdistanFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }
                "Kerman" -> {
                    val fragment = KermanFragment()
                    transaction.replace(R.id.frameLayoutTest, fragment)
                    transaction.commit()
                }

            }

        }

    }
}