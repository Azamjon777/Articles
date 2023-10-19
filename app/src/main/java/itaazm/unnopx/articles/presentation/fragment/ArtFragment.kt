package itaazm.unnopx.articles.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import itaazm.unnopx.articles.R
import itaazm.unnopx.articles.adapters.ArtAdapter
import itaazm.unnopx.articles.databinding.FragmentArtBinding
import itaazm.unnopx.articles.models.FavoriteItem
import itaazm.unnopx.articles.models.ItemModel
import itaazm.unnopx.articles.presentation.ItemInfoActivity
import itaazm.unnopx.articles.viewmodels.DataViewModel
import itaazm.unnopx.articles.viewmodels.DataViewModelFactory
import itaazm.unnopx.articles.viewmodels.MyViewModel

class ArtFragment : Fragment(), ArtAdapter.OnItemClickListener, ArtAdapter.OnInsertClickListener {
    private lateinit var binding: FragmentArtBinding
    private lateinit var viewModel: DataViewModel
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArtBinding.inflate(inflater, container, false)
        val viewModelFactory = DataViewModelFactory(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory)[DataViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val artList = viewModel.categoryList[0]
        val recyclerView = binding.recyclerViewArt
        val adapter = ArtAdapter(artList.listOFEntities, this, this)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    override fun onItemClick(item: ItemModel) {
        val intent = Intent(requireContext(), ItemInfoActivity::class.java)
        intent.putExtra("item", item)
        startActivity(intent)
    }

    override fun onInsertClick(item: ItemModel) {
        myViewModel.insert(FavoriteItem(title = item.title, desc = item.desc, img = item.image)) {}
        Toast.makeText(requireActivity(), getString(R.string.added), Toast.LENGTH_SHORT).show()
    }
}
