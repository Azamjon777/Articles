package itaazm.unnopx.articles.db.repository

import androidx.lifecycle.LiveData
import itaazm.unnopx.articles.db.dao.FavoriteItemDao
import itaazm.unnopx.articles.models.FavoriteItem

class FavouriteRepositoryRealization(private val favoriteItemDao: FavoriteItemDao) :
    FavouriteRepository {
    override val allBasicCourses: LiveData<List<FavoriteItem>>
        get() = favoriteItemDao.getAllBasicItems()

    override suspend fun insertBasicItem(basicItemModel: FavoriteItem, onSuccess: () -> Unit) {
        favoriteItemDao.insert(basicItemModel)
        onSuccess()
    }

    override suspend fun deleteBasicItem(basicItemModel: FavoriteItem, onSuccess: () -> Unit) {
        favoriteItemDao.delete(basicItemModel)
        onSuccess()
    }

    override fun checkItemExists(title: String): LiveData<Boolean> {
        return favoriteItemDao.checkItemExists(title)
    }

    override fun deleteAll() {
        favoriteItemDao.deleteAll()
    }
}