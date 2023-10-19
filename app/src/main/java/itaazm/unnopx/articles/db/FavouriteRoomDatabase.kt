package itaazm.unnopx.articles.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import itaazm.unnopx.articles.db.dao.FavoriteItemDao
import itaazm.unnopx.articles.models.FavoriteItem

@Database(entities = [FavoriteItem::class], version = 1)
abstract class FavouriteRoomDatabase : RoomDatabase() {

    abstract fun getBasicDao(): FavoriteItemDao

    companion object {
        private var database: FavouriteRoomDatabase? = null

        fun getInstance(context: Context): FavouriteRoomDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context, FavouriteRoomDatabase::class.java, "db")
                    .build()
                database as FavouriteRoomDatabase
            } else {
                database as FavouriteRoomDatabase
            }
        }
    }
}