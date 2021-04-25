package raum.muchbeer.stackoverhelpktx.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import raum.muchbeer.stackoverhelpktx.datastore.CountryPref
import java.lang.IllegalArgumentException

class FinalViewModel( finalPref: CountryPref) : ViewModel() {

    val read_country = finalPref.read_country.asLiveData(
        Dispatchers.Default + viewModelScope.coroutineContext
    )

    val read_food = finalPref.read_food.asLiveData(
        Dispatchers.Default + viewModelScope.coroutineContext
    )

}

class FinalViewModelFactory(private val finalPref: CountryPref) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FinalViewModel::class.java)) {
            return FinalViewModel(finalPref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

}