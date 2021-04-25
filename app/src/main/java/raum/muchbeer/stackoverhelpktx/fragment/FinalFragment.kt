package raum.muchbeer.stackoverhelpktx.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import raum.muchbeer.stackoverhelpktx.R
import raum.muchbeer.stackoverhelpktx.databinding.FragmentFinalBinding
import raum.muchbeer.stackoverhelpktx.datastore.CountryPref
import raum.muchbeer.stackoverhelpktx.viewmodel.FinalViewModel
import raum.muchbeer.stackoverhelpktx.viewmodel.FinalViewModelFactory

class FinalFragment : Fragment() {

    private lateinit var binding : FragmentFinalBinding
    private val viewModel : FinalViewModel by viewModels {
        FinalViewModelFactory(CountryPref(requireContext()))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentFinalBinding.inflate(inflater)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}