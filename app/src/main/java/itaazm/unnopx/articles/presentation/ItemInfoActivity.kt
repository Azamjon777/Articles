package itaazm.unnopx.articles.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import itaazm.unnopx.articles.databinding.ActivityItemInfoBinding
import itaazm.unnopx.articles.models.ItemModel

class ItemInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityItemInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = intent.getSerializableExtra("item") as? ItemModel

        if (item != null) {
            binding.itemImg.setImageResource(item.image)
            binding.itemTitle.text = item.title
            binding.itemDesc.text = item.desc
        }
    }
}