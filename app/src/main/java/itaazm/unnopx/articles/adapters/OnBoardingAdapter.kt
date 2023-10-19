package itaazm.unnopx.articles.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import itaazm.unnopx.articles.R
import itaazm.unnopx.articles.models.OnBoardingItem

class OnBoardingAdapter(private val onBoardingItems: List<OnBoardingItem>) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingItemViewHolder {
        return OnBoardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.onboarding_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return onBoardingItems.size
    }

    override fun onBindViewHolder(holder: OnBoardingItemViewHolder, position: Int) {
        holder.bind(onBoardingItems[position])
    }

    inner class OnBoardingItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageOnBoarding = view.findViewById<ImageView>(R.id.imageOnBoarding)
        private val textTitle = view.findViewById<TextView>(R.id.text_title)
        private val textDesc = view.findViewById<TextView>(R.id.text_description)

        fun bind(onBoardingItem: OnBoardingItem) {
            imageOnBoarding.setImageResource(onBoardingItem.onBoardingImage)
            textTitle.text = onBoardingItem.title
            textDesc.text = onBoardingItem.description
        }
    }
}