package itaazm.unnopx.articles.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import itaazm.unnopx.articles.REALISATION
import itaazm.unnopx.articles.models.FavoriteItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    fun insert(basicItemModel: FavoriteItem, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALISATION.insertBasicItem(basicItemModel) {
                onSuccess()
            }
        }

    fun delete(basicItemModel: FavoriteItem, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALISATION.deleteBasicItem(basicItemModel) {
                onSuccess()
            }
        }
}
