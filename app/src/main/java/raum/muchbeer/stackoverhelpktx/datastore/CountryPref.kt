package raum.muchbeer.stackoverhelpktx.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Singleton

private const val TAG = "CountryPref"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "country_pref")

@Singleton
class CountryPref(val context: Context) {

    companion object {
        val PREF_KEY_COUNTRY = stringPreferencesKey("country_name")
        val PREF_KEY_FOOD = stringPreferencesKey("food_name")
    }

    suspend fun storeCountry(country: String) {
        context.dataStore.edit {
            it[PREF_KEY_COUNTRY] = country
        }
    }

    suspend fun storeFood(foodName: String) {
        context.dataStore.edit {
            it[PREF_KEY_FOOD] = foodName
        }
    }

    val read_country: Flow<String> = context.dataStore.data
        .map {

            it[PREF_KEY_COUNTRY] ?: "Tanzania"
        }.catch { exception ->
            if (exception is IOException) {
                Log.e(TAG, "Error reading preferences", exception)
                //   emit(emptyPreferences())
            } else {
                throw exception
            }
        }

    val read_food : Flow<String> = context.dataStore.data
        .map {
            it[PREF_KEY_FOOD] ?: "Ugali"
        }

}