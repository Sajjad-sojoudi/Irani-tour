package ir.sajjad.iranitour.activity

import android.os.Bundle
import android.text.Layout
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.databinding.ActivityMainBinding

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
            when(it.itemId){
                R.id.menu_save_locations ->{
                    findNavController(R.id.fragmentContainerView).navigate(R.id.savedLocationFragment)
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_setting ->{
                }
                R.id.menu_about_us ->{}

                R.id.menu_exit ->{
                    finish()
                }
            }
            true
        }

        binding.bottomNavigationMain.setOnItemSelectedListener{
            when(it.itemId){
                R.id.menu_iranology ->{
                    findNavController(R.id.fragmentContainerView).navigate(R.id.iranlogyFragment)
                }

                R.id.menu_landmark ->{
                    findNavController(R.id.fragmentContainerView).navigate(R.id.landMarkFragment)
                }

                R.id.menu_profile ->{
                    findNavController(R.id.fragmentContainerView).navigate(R.id.profileFragment)
                }
            }
            true
        }
    }
}