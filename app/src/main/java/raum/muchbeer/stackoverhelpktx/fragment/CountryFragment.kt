package raum.muchbeer.stackoverhelpktx.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import raum.muchbeer.stackoverhelpktx.R
import raum.muchbeer.stackoverhelpktx.databinding.FragmentCountryBinding
import raum.muchbeer.stackoverhelpktx.databinding.FragmentFoodBinding
import raum.muchbeer.stackoverhelpktx.datastore.CountryPref
import raum.muchbeer.stackoverhelpktx.viewmodel.CountryViewModel
import raum.muchbeer.stackoverhelpktx.viewmodel.CountryViewModelFactory

class CountryFragment : Fragment() {

    val viewModel : CountryViewModel by viewModels {
        CountryViewModelFactory(CountryPref(requireContext()))
    }
    private lateinit var binding : FragmentCountryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = FragmentCountryBinding.inflate(inflater)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.view_Pager)
        binding.countryNext.setOnClickListener {
            viewPager.currentItem = 1
        }

        return binding.root

    }
}