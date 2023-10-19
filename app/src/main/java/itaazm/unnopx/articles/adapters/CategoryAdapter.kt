package itaazm.unnopx.articles.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import itaazm.unnopx.articles.databinding.ItemCategoryBinding
import itaazm.unnopx.articles.models.CategoryModel

class CategoryAdapter(
    private val categories: List<CategoryModel>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: CategoryModel) {
            binding.categoryImageView.setImageResource(category.image)
            binding.categoryNameTextView.text = category.categoryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(category)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
    interface OnItemClickListener {
        fun onItemClick(category: CategoryModel)
    }
}
