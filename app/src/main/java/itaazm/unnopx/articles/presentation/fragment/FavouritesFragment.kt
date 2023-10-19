package itaazm.unnopx.articles.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import itaazm.unnopx.articles.adapters.FavoritesAdapter
import itaazm.unnopx.articles.databinding.FragmentFavouritesBinding
import itaazm.unnopx.articles.viewmodels.FavouriteViewModel
import itaazm.unnopx.articles.viewmodels.MyViewModel

class FavouritesFragment : Fragment() {
    private lateinit var binding: FragmentFavouritesBinding
    private lateinit var favoritesAdapter: FavoritesAdapter
    private val favouriteViewModel: FavouriteViewModel by viewModels()
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritesAdapter = FavoritesAdapter { favoriteItem ->
            myViewModel.delete(favoriteItem) {}
        }

        binding.recyclerViewFavorites.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = favoritesAdapter
        }

        favouriteViewModel.getAllBasics().observe(viewLifecycleOwner) { favoriteItems ->
            favoritesAdapter.submitList(favoriteItems)
        }
    }
}
