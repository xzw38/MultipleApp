package com.example.homwowrk3


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.homwowrk3.databinding.FragmentTipBinding
import kotlinx.android.synthetic.main.fragment_random.*
import kotlinx.android.synthetic.main.fragment_tip.*
import kotlin.math.roundToLong

class TipFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTipBinding>(
            inflater,
            R.layout.fragment_tip,
            container,
            false
        )
        //Random Generator
        val result = binding.TipResult
        val total = binding.TotalResult
        val number = binding.lowText

        val onefive = binding.checkBox15
        val oneeight = binding.checkBox18
        val twozero = binding.checkBox20

        binding.buttonGetNumber.setOnClickListener {view: View->
            val num = number.text.toString().toInt()

            if (onefive.isChecked){
              val num1 = num * 0.15
                 result.text = num1.toString()
                val sum1 = num1+num
                total.text = sum1.toString()
            }
            else if (oneeight.isChecked){
              val num2 = num * 0.18
                 result.text = num2.toString()
                val sum2 = num2+num
                total.text = sum2.toString()
            }
            else if (twozero.isChecked){
              val num3 = num * 0.2
                 result.text = num3.toString()
                val sum3 = num3+num
                total.text = sum3.toString()
            }
            else{
            val num = ""
            result.text = num.toString()
          }

        }


        setHasOptionsMenu(true)


        // Inflate the layout for this fragment

        return binding.root
    }


    // Creating our Share Intent
    private fun getShareIntent() : Intent {

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/html")
        shareIntent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "The total amount and tip will be .");
        shareIntent.putExtra(Intent.EXTRA_TEXT, TotalResult.text);
        shareIntent.putExtra(Intent.EXTRA_TEXT, TipResult.text);


        return shareIntent
    }

    // Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    // Showing the Share Menu Item Dynamically
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }

    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }




}
