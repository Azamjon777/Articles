package itaazm.unnopx.articles.models

import java.io.Serializable

data class CategoryModel(
    val image: Int,
    val categoryName: String,
    val listOFEntities: List<ItemModel>
) : Serializable