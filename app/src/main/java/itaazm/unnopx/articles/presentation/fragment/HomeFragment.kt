package itaazm.unnopx.articles.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import itaazm.unnopx.articles.R
import itaazm.unnopx.articles.databinding.FragmentHomeBinding
import itaazm.unnopx.articles.viewmodels.DataViewModel
import itaazm.unnopx.articles.viewmodels.DataViewModelFactory

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val viewModelFactory = DataViewModelFactory(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory)[DataViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val pagerAdapter = MyPagerAdapter(childFragmentManager)

        viewPager.adapter = pagerAdapter

        tabLayout.setupWithViewPager(viewPager)
    }

    private inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getCount(): Int {
            return 2
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> ArtFragment()
                1 -> MusicFragment()
                else -> throw IllegalArgumentException("Invalid position: $position")
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> getString(R.string.art)
                1 -> getString(R.string.music)
                else -> null
            }
        }
    }
}
