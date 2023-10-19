package itaazm.unnopx.articles.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import itaazm.unnopx.articles.REALISATION
import itaazm.unnopx.articles.models.FavoriteItem
import kotlinx.coroutines.launch

class FavouriteViewModel : ViewModel() {
    fun getAllBasics(): LiveData<List<FavoriteItem>> {
        return REALISATION.allBasicCourses
    }

    fun deleteAll() {
        viewModelScope.launch {
            REALISATION.deleteAll()
        }
    }
}