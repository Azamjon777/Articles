package itaazm.unnopx.articles.db.repository

import androidx.lifecycle.LiveData
import itaazm.unnopx.articles.models.FavoriteItem

interface FavouriteRepository {
    val allBasicCourses: LiveData<List<FavoriteItem>>

    suspend fun insertBasicItem(basicItemModel: FavoriteItem, onSuccess: () -> Unit)
    suspend fun deleteBasicItem(basicItemModel: FavoriteItem, onSuccess: () -> Unit)
    fun checkItemExists(title: String): LiveData<Boolean>

    fun deleteAll()
}
