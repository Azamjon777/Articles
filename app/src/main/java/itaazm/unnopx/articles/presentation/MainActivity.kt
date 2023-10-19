package itaazm.unnopx.articles.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import itaazm.unnopx.articles.R
import itaazm.unnopx.articles.databinding.ActivityMainBinding
import itaazm.unnopx.articles.presentation.fragment.CategoryFragment
import itaazm.unnopx.articles.presentation.fragment.FavouritesFragment
import itaazm.unnopx.articles.presentation.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val initialFragment = CategoryFragment()
        replaceFragment(initialFragment)

        binding.bottomNavView.selectedItemId = R.id.categoryFragment
        binding.bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    val homeFragment = HomeFragment()
                    replaceFragment(homeFragment)
                    true
                }

                R.id.categoryFragment -> {
                    val categoryFragment = CategoryFragment()
                    replaceFragment(categoryFragment)
                    true
                }

                R.id.favouritesFragment -> {
                    val favouritesFragment = FavouritesFragment()
                    replaceFragment(favouritesFragment)
                    true
                }

                else -> false
            }
        }
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentMainContainer.id, fragment)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }
}
