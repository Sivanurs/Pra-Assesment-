package org.d3if4014.myapplication.fragment


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if4014.myapplication.MainActivity

import org.d3if4014.myapplication.R
import org.d3if4014.myapplication.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        title()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false)
        setHasOptionsMenu(true)
        binding.btnPersegiPjg.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_persegiPanjangFragment)
        }
        binding.btnSegetiga.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_segitigaFragment)
        }
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun title(){
        val getActivity = activity!! as MainActivity
        getActivity.supportActionBar?.title = "Home"
    }
}
