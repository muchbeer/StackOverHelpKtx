package raum.muchbeer.stackoverhelpktx.viewmodel

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import raum.muchbeer.stackoverhelpktx.datastore.CountryPref
import java.lang.IllegalArgumentException

class FoodViewModel(private val foodPref: CountryPref) : ViewModel() {

    private val _displayFood = MutableLiveData<String>()

    val observeFoodEdtTxt = ObservableField<String>().apply {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                _displayFood.value = get()
               storeFood()
            }

        })
    }

    fun clearFood() {
        _displayFood.value = ""
    }

    fun storeFood() = viewModelScope.launch {
        foodPref.storeFood(_displayFood.value.toString())
    }
}

class FoodViewModelFactory(val foodPref: CountryPref) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodViewModel::class.java)) {
            return FoodViewModel(foodPref) as T
        }
        throw IllegalArgumentException("Unknown ViewMdoel")
    }

}