package raum.muchbeer.stackoverhelpktx.viewmodel

import android.text.Editable
import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import raum.muchbeer.stackoverhelpktx.datastore.CountryPref
import java.lang.IllegalArgumentException

class CountryViewModel(private val countryPref: CountryPref) : ViewModel() {

    // The data source required by the Spinner Adapter
     var liveItems = mutableListOf<String>()

    private var _txtDisplyaCounties = MutableLiveData<String>()
    val txtDisplayCountry : LiveData<String>
        get() = _txtDisplyaCounties

    private var _hideText = MutableLiveData<Boolean>()
    val hideText : LiveData<Boolean>
        get() = _hideText

    private var _addCountries = MutableLiveData<String?>()


    val observeCountry = ObservableField<String>().apply {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                _addCountries.value = get()
                Log.d("TAG", "List of observed country added is : ${get()}")
            }

        })
    }

    val cityOfUser = ObservableField<String>().apply {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                get()
                _txtDisplyaCounties.value = get()
                 saveCountryData()
            }
        })
    }

    init {
        liveItems = mutableListOf("Wales", "England", "Scotland", "Northen Ireland", "Tanzania")
        _hideText.value= true
    }

    fun saveCountryData() = viewModelScope.launch {
        countryPref.storeCountry(_txtDisplyaCounties.value.toString())
    }

    fun addCountry() {
        liveItems.add(_addCountries.value!!)
        _hideText.value = true
    }

}
class CountryViewModelFactory(val countryPref: CountryPref) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            return CountryViewModel(countryPref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

}