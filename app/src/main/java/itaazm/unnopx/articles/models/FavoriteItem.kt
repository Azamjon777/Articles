package itaazm.unnopx.articles.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "basic_item_table")
data class FavoriteItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val desc: String,
    val img: Int
)