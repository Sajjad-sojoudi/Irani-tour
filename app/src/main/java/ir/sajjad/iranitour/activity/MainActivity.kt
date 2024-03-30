package ir.sajjad.iranitour.activity

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import com.google.android.material.materialswitch.MaterialSwitch
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBarMain)



        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolBarMain,
            R.string.open_drawer,
            R.string.close_drawer
        )

        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        binding.navigationViewMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_save_locations -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.savedLocationFragment)
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_setting -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.settingFragment)
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_about_us -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.aboutUsFragment)
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_change_theme -> {
                    val switch =findViewById<MaterialSwitch>(R.id.change_theme)
                    switch.setOnCheckedChangeListener { _, isChecked ->
                        if (isChecked){
                            setLocale("en")
                        }else{
                            setLocale("en")
                        }
                    }
                }

                R.id.menu_exit -> {
                    finish()
                }
            }
            true
        }

        binding.bottomNavigationMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_iranology -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.iranlogyFragment)
                }

                R.id.menu_landmark -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.landMarkFragment)
                }

                R.id.menu_profile -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.profileFragment)
                }
            }
            true
        }

    }

    fun changeLanguage(view: android.view.View) {
        // فراخوانی متد تغییر زبان با کلیک روی دکمه
        setLocale("fa")
    }

    private fun setLocale(lang: String) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val resources: Resources = resources
        val configuration: Configuration = resources.configuration
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
        recreate()
    }

}