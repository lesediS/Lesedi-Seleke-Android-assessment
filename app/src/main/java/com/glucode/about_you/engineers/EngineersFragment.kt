package com.glucode.about_you.engineers

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.glucode.about_you.R
import com.glucode.about_you.databinding.FragmentEngineersBinding
import com.glucode.about_you.engineers.models.Engineer
import com.glucode.about_you.mockdata.MockData

class EngineersFragment : Fragment() {
    private lateinit var binding: FragmentEngineersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEngineersBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        setUpEngineersList(MockData.engineers)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_engineers, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_years -> {
                sortEngineers("years")
                true
            }
            R.id.action_coffees -> {
                sortEngineers("coffees")
                true
            }
            R.id.action_bugs -> {
                sortEngineers("bugs")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //Sorting the engineers...
    private fun sortEngineers(criteria: String) {
        val sortedEngineers = MockData.sortEngineersBy(criteria) //... according to criteria data from MockData file
        setUpEngineersList(sortedEngineers)
    }

    private fun setUpEngineersList(engineers: List<Engineer>) {
        binding.list.adapter = EngineersRecyclerViewAdapter(engineers) {
            goToAbout(it)
        }
        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.list.addItemDecoration(dividerItemDecoration)
    }

    private fun goToAbout(engineer: Engineer) {
        val bundle = Bundle().apply {
            putString("name", engineer.name)
        }
        findNavController().navigate(R.id.action_engineersFragment_to_aboutFragment, bundle)
    }
}