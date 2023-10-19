package itaazm.unnopx.articles.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import itaazm.unnopx.articles.databinding.ItemFavoriteBinding
import itaazm.unnopx.articles.models.FavoriteItem

class FavoritesAdapter(
    private val onDeleteClickListener: (FavoriteItem) -> Unit
) : ListAdapter<FavoriteItem, FavoritesAdapter.FavoriteViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding =
            ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favoriteItem = getItem(position)
        holder.bind(favoriteItem)
    }

    inner class FavoriteViewHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(favoriteItem: FavoriteItem) {
            binding.itemTitle.text = favoriteItem.title
            binding.itemDescription.text = favoriteItem.desc
            binding.itemImage.setImageResource(favoriteItem.img)

            binding.delete.setOnClickListener {
                onDeleteClickListener(favoriteItem)
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<FavoriteItem>() {
            override fun areItemsTheSame(oldItem: FavoriteItem, newItem: FavoriteItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FavoriteItem, newItem: FavoriteItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}