package raum.muchbeer.stackoverhelpktx.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import raum.muchbeer.stackoverhelpktx.R
import raum.muchbeer.stackoverhelpktx.databinding.FragmentFoodBinding
import raum.muchbeer.stackoverhelpktx.datastore.CountryPref
import raum.muchbeer.stackoverhelpktx.viewmodel.FoodViewModel
import raum.muchbeer.stackoverhelpktx.viewmodel.FoodViewModelFactory

class FoodFragment : Fragment() {

    private lateinit var binding : FragmentFoodBinding
    private val viewModel : FoodViewModel by viewModels {
        FoodViewModelFactory(CountryPref(requireContext()))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentFoodBinding.inflate(inflater)

        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_finalFragment)
            viewModel.clearFood()
        }

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }


}