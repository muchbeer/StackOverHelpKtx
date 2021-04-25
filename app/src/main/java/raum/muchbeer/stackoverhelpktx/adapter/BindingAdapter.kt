package raum.muchbeer.stackoverhelpktx.adapter

import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField

@BindingAdapter("clicks")
fun listenClicks(spinner: AppCompatSpinner, result: ObservableField<String>) {
    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {

        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            result.set(parent?.getItemAtPosition(position) as String)
        }
    }
}

@BindingAdapter("country")
fun listenValue(editText: EditText, result: ObservableField<String>) {
     result.set(editText.text.toString())
}

@BindingAdapter("hideText")
fun hideEditText(editText: EditText, isText : Boolean) {
    if(isText) {
        editText.text.clear()
    }
}

@BindingAdapter("hideButton")
fun hideButton(button: Button, valueEntered: ObservableField<String>) {
    if(valueEntered.get().isNullOrEmpty()) {
        button.visibility=View.GONE
    } else
        button.visibility = View.VISIBLE
}

@BindingAdapter("food")
fun listenFoodValue(editText: EditText, observableField: ObservableField<String>) {
    observableField.set(editText.text.toString())
}
