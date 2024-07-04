package ir.sajjad.iranitour.activity

import android.content.Context
import android.content.Intent
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

var isRegistered = false
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBarMain)
        val sharedPreferencesFileName = "data"
        val sharedPreferences = getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)
        isRegistered = sharedPreferences.getBoolean("isRegistered", false)

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

                        }else{
                        }
                    }
                }

                R.id.menu_exit -> {
                   finishAffinity()
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
                    if(!isRegistered){
                        findNavController(R.id.fragmentContainerView).navigate(R.id.registerFragment)
                        sharedPreferences.edit().putBoolean("isRegistered",true).apply()
                        //isRegistered = true
                    }else{
                        findNavController(R.id.fragmentContainerView).navigate(R.id.profileFragment)
                           isRegistered = true
                    }
                }
            }
            true
        }

    }






}