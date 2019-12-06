package com.example.homwowrk3


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.CheckBox
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.homwowrk3.databinding.FragmentRandomBinding
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_random.*
import kotlin.random.Random

class RandomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentRandomBinding>(inflater,R.layout.fragment_random,container,false)

        binding.buttonGotoDice.setOnClickListener {view: View->

            view.findNavController().navigate(RandomFragmentDirections.actionRandomFragmentToDiceFragment2())
        }




        //Random Generator
        val result = binding.textResult
        val low = binding.lowText
        val upper = binding.upperText
        val replacement = binding.checkBox
        val outNumbers: MutableList<Int> = ArrayList<Int>()

        binding.buttonGetNumber.setOnClickListener {view: View->

            val lowNum = low.text.toString().toInt()
            val upperNum = upper.text.toString().toInt()
            var rnds = -1;
            rnds = (lowNum..upperNum).random()
            if (replacement.isChecked) {
                while (outNumbers.indexOf(rnds) != -1) {
                    rnds = (lowNum..upperNum).random()
                }
                outNumbers.add(rnds)
            }
            result.text = rnds.toString()

        }




        // Inflate the layout for this fragment

        return binding.root

    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater?.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }







}
