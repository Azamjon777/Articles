package itaazm.unnopx.articles.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import itaazm.unnopx.articles.adapters.CategoryAdapter
import itaazm.unnopx.articles.databinding.FragmentCategoryBinding
import itaazm.unnopx.articles.models.CategoryModel
import itaazm.unnopx.articles.presentation.CategoryInfoActivity
import itaazm.unnopx.articles.viewmodels.DataViewModel
import itaazm.unnopx.articles.viewmodels.DataViewModelFactory

class CategoryFragment : Fragment(), CategoryAdapter.OnItemClickListener {
    private lateinit var binding: FragmentCategoryBinding
    private lateinit var viewModel: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val viewModelFactory = DataViewModelFactory(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory)[DataViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerView
        val layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.layoutManager = layoutManager

        val adapter = CategoryAdapter(viewModel.categoryList, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(itemCategory: CategoryModel) {
        val intent = Intent(requireContext(), CategoryInfoActivity::class.java)
        intent.putExtra("category", itemCategory)
        startActivity(intent)
    }
}