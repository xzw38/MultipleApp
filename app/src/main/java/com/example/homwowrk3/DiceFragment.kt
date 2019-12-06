package com.example.homwowrk3


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.homwowrk3.databinding.FragmentDiceBinding
import java.util.*


class DiceFragment : Fragment() {
    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDiceBinding>(
            inflater,
            R.layout.fragment_dice,
            container,
            false
        )

        binding.buttonGotoTip.setOnClickListener { view: View ->

            view.findNavController()
                .navigate(DiceFragmentDirections.actionDiceFragmentToTipFragment())
        }

        diceImage = binding.diceImage
        diceImage2 = binding.diceImage2

        binding.rollButton.setOnClickListener { view: View ->

            rollDice()
            rollDice2()
        }


        // Inflate the layout for this fragment

        return binding.root
    }

    private fun rollDice() {

        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        diceImage.setImageResource(drawableResource)
    }
    private fun rollDice2() {

        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        diceImage2.setImageResource(drawableResource)
    }
}