package itaazm.unnopx.articles.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import itaazm.unnopx.articles.R
import itaazm.unnopx.articles.REALISATION
import itaazm.unnopx.articles.db.FavouriteRoomDatabase
import itaazm.unnopx.articles.db.repository.FavouriteRepositoryRealization
import itaazm.unnopx.articles.models.CategoryModel
import itaazm.unnopx.articles.models.ItemModel

class DataViewModel(context: Context) : ViewModel() {
    init {
        val daoBasic = FavouriteRoomDatabase.getInstance(context).getBasicDao()
        REALISATION = FavouriteRepositoryRealization(daoBasic)
    }

    val categoryList = listOf(
        CategoryModel(
            R.drawable.category_img1, context.getString(R.string.art), listOf(
                ItemModel(
                    R.drawable.art1,
                    context.getString(R.string.atitle1),
                    context.getString(R.string.adesc1)
                ),
                ItemModel(
                    R.drawable.art2,
                    context.getString(R.string.atitle2),
                    context.getString(R.string.adesc2)
                ),
                ItemModel(
                    R.drawable.art3,
                    context.getString(R.string.atitle3),
                    context.getString(R.string.adesc3)
                ),
                ItemModel(
                    R.drawable.art4,
                    context.getString(R.string.atitle4),
                    context.getString(R.string.adesc4)
                )
            )
        ),
        CategoryModel(
            R.drawable.category_img2, context.getString(R.string.music), listOf(
                ItemModel(
                    R.drawable.music1,
                    context.getString(R.string.mtitle1),
                    context.getString(R.string.mdesc1)
                ),
                ItemModel(
                    R.drawable.music2,
                    context.getString(R.string.mtitle2),
                    context.getString(R.string.mdesc2)
                ),
                ItemModel(
                    R.drawable.music3,
                    context.getString(R.string.mtitle3),
                    context.getString(R.string.mdesc3)
                ),
                ItemModel(
                    R.drawable.music4,
                    context.getString(R.string.mtitle4),
                    context.getString(R.string.mdesc4)
                )
            )
        ),
        CategoryModel(
            R.drawable.category_img3, context.getString(R.string.sport), listOf(
                ItemModel(
                    R.drawable.sport1,
                    context.getString(R.string.stitle1),
                    context.getString(R.string.sdesc1)
                ),
                ItemModel(
                    R.drawable.sport2,
                    context.getString(R.string.stitle2),
                    context.getString(R.string.sdesc2)
                ),
                ItemModel(
                    R.drawable.sport3,
                    context.getString(R.string.stitle3),
                    context.getString(R.string.sdesc3)
                ),
                ItemModel(
                    R.drawable.sport4,
                    context.getString(R.string.stitle4),
                    context.getString(R.string.sdesc4)
                )
            )
        ),
        CategoryModel(
            R.drawable.category_img4, context.getString(R.string.literature), listOf(
                ItemModel(
                    R.drawable.lit1,
                    context.getString(R.string.ltitle1),
                    context.getString(R.string.ldesc1)
                ),
                ItemModel(
                    R.drawable.lit2,
                    context.getString(R.string.ltitle2),
                    context.getString(R.string.ldesc2)
                ),
                ItemModel(
                    R.drawable.lit3,
                    context.getString(R.string.ltitle3),
                    context.getString(R.string.ldesc3)
                ),
                ItemModel(
                    R.drawable.lit4,
                    context.getString(R.string.ltitle4),
                    context.getString(R.string.ldesc4)
                )
            )
        ),
        CategoryModel(
            R.drawable.category_img5, context.getString(R.string.mathematics), listOf(
                ItemModel(
                    R.drawable.math1,
                    context.getString(R.string.altitle1),
                    context.getString(R.string.aldesc1)
                ),
                ItemModel(
                    R.drawable.math2,
                    context.getString(R.string.altitle2),
                    context.getString(R.string.aldesc2)
                ),
                ItemModel(
                    R.drawable.math3,
                    context.getString(R.string.altitle3),
                    context.getString(R.string.aldesc3)
                ),
                ItemModel(
                    R.drawable.math4,
                    context.getString(R.string.altitle4),
                    context.getString(R.string.aldesc4)
                )
            )
        ),
        CategoryModel(
            R.drawable.category_img6, context.getString(R.string.history), listOf(
                ItemModel(
                    R.drawable.his1,
                    context.getString(R.string.htitle1),
                    context.getString(R.string.hdesc1)
                ),
                ItemModel(
                    R.drawable.his2,
                    context.getString(R.string.htitle2),
                    context.getString(R.string.hdesc2)
                ),
                ItemModel(
                    R.drawable.his3,
                    context.getString(R.string.htitle3),
                    context.getString(R.string.hdesc3)
                ),
                ItemModel(
                    R.drawable.his4,
                    context.getString(R.string.htitle4),
                    context.getString(R.string.hdesc4)
                )
            )
        )
    )
}