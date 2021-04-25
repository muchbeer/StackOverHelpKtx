package raum.muchbeer.stackoverhelpktx.fragment

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import raum.muchbeer.stackoverhelpktx.R
import raum.muchbeer.stackoverhelpktx.adapter.ViewPagerAdapter
import raum.muchbeer.stackoverhelpktx.databinding.FragmentViewPagerBinding


class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(inflater)

        val fragmentList = arrayListOf(
            CountryFragment(),
            FoodFragment(),
            FinalFragment()
        )

        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        return binding.root
    }

}