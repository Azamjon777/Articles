package itaazm.unnopx.articles.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import itaazm.unnopx.articles.models.FavoriteItem

@Dao
interface FavoriteItemDao {
    @Query("SELECT EXISTS (SELECT 1 FROM basic_item_table WHERE title = :title)")
    fun checkItemExists(title: String): LiveData<Boolean>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(basicItemModel: FavoriteItem)

    @Delete
    suspend fun delete(basicItemModel: FavoriteItem)

    @Query("SELECT * FROM basic_item_table")
    fun getAllBasicItems(): LiveData<List<FavoriteItem>>

    @Query("DELETE FROM basic_item_table")
    fun deleteAll()
}