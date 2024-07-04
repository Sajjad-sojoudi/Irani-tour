package ir.sajjad.iranitour.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.Switch
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.databinding.ActivityMainBinding

var isRegistered = false

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBarMain)
        sharedPreferences = getSharedPreferences("ThemePref", Context.MODE_PRIVATE)

        // Set the theme based on SharedPreferences
        if (sharedPreferences.getBoolean("isDarkMode", false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolBarMain,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navigationViewMain.setNavigationItemSelectedListener { menuItem ->
            handleNavigationItemSelected(menuItem)
            true
        }

        // Initialize the theme switch
        val headerView = binding.navigationViewMain.getHeaderView(0)
        val themeSwitch = headerView.findViewById<Switch>(R.id.change_theme)
        themeSwitch.isChecked = sharedPreferences.getBoolean("isDarkMode", false)
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPreferences.edit().putBoolean("isDarkMode", true).apply()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPreferences.edit().putBoolean("isDarkMode", false).apply()
            }
        }

        val sharedPreferencesFileName = "data"
        val userPreferences = getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)
        isRegistered = userPreferences.getBoolean("isRegistered", false)

        binding.bottomNavigationMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_iranology -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.iranlogyFragment)
                }

                R.id.menu_landmark -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.landMarkFragment)
                }

                R.id.menu_profile -> {
                    if (!isRegistered) {
                        findNavController(R.id.fragmentContainerView).navigate(R.id.registerFragment)
                        userPreferences.edit().putBoolean("isRegistered", true).apply()
                        isRegistered = true
                    } else {
                        findNavController(R.id.fragmentContainerView).navigate(R.id.profileFragment)
                    }
                }
            }
            true
        }
    }

    private fun handleNavigationItemSelected(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.menu_save_locations -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.savedLocationFragment)
                binding.drawerLayoutMain.closeDrawers()
            }
            R.id.menu_setting -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.settingFragment)
                binding.drawerLayoutMain.closeDrawers()
            }
            R.id.menu_about_us -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.aboutUsFragment)
                binding.drawerLayoutMain.closeDrawers()
            }
            R.id.menu_exit -> {
                finishAffinity()
            }
        }
    }
}
