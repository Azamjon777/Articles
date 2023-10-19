package itaazm.unnopx.articles.models

import java.io.Serializable

data class ItemModel(
    val image: Int,
    val title: String,
    val desc: String
) : Serializable