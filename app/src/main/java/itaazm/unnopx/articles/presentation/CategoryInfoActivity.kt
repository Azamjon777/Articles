package itaazm.unnopx.articles.presentation

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import itaazm.unnopx.articles.R
import itaazm.unnopx.articles.databinding.ActivityCategoryInfoBinding
import itaazm.unnopx.articles.databinding.DialogItemSelectionBinding
import itaazm.unnopx.articles.models.CategoryModel
import itaazm.unnopx.articles.models.FavoriteItem
import itaazm.unnopx.articles.viewmodels.MyViewModel

class CategoryInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryInfoBinding
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemCategory = intent.getSerializableExtra("category") as? CategoryModel

        if (itemCategory != null) {
            val itemModelList = itemCategory.listOFEntities.map { it.title }.toTypedArray()

            selectItem(itemModelList, itemCategory)
        }

        binding.back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun selectItem(itemModelList: Array<String>, itemCategory: CategoryModel) {
        val builder = AlertDialog.Builder(this)
        val dialogBinding = DialogItemSelectionBinding.inflate(layoutInflater)
        val dialogView = dialogBinding.root

        dialogBinding.textViewDialogTitle.text = getString(R.string.select_item)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemModelList)
        dialogBinding.listViewItems.adapter = adapter

        builder.setView(dialogView)
        builder.setCancelable(false)

        val alertDialog = builder.create()

        dialogBinding.listViewItems.setOnItemClickListener { _, _, which, _ ->
            val selectedItem = itemCategory.listOFEntities[which]

            binding.title.text = selectedItem.title
            binding.desc.text = selectedItem.desc
            binding.img.setImageResource(selectedItem.image)

            binding.selectedImg.setOnClickListener {
                val favoriteItem = FavoriteItem(
                    title = selectedItem.title,
                    desc = selectedItem.desc,
                    img = selectedItem.image
                )

                myViewModel.insert(favoriteItem) {}
                Toast.makeText(this, getString(R.string.added), Toast.LENGTH_SHORT).show()
            }
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}