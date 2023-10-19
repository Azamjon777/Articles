package itaazm.unnopx.articles.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import itaazm.unnopx.articles.databinding.ItemArtBinding
import itaazm.unnopx.articles.models.ItemModel

class ArtAdapter(
    private val artList: List<ItemModel>,
    private val itemClickListener: OnItemClickListener,
    private val deleteClickListener: OnInsertClickListener
) : RecyclerView.Adapter<ArtAdapter.ArtViewHolder>() {

    inner class ArtViewHolder(private val binding: ItemArtBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemModel) {
            binding.imageViewArt.setImageResource(item.image)
            binding.textViewArtTitle.text = item.title

            binding.root.setOnClickListener {
                itemClickListener.onItemClick(item)
            }

            binding.selected.setOnClickListener {
                deleteClickListener.onInsertClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        val binding =
            ItemArtBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        val item = artList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return artList.size
    }

    interface OnItemClickListener {
        fun onItemClick(item: ItemModel)
    }

    interface OnInsertClickListener {
        fun onInsertClick(item: ItemModel)
    }
}

