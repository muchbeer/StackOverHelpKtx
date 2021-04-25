package raum.muchbeer.stackoverhelpktx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import raum.muchbeer.stackoverhelpktx.databinding.ActivityHomeBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        supportActionBar?.hide()
    }
}