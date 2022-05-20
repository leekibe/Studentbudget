package com.example.studentbudget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.studentbudget.data.Budget
import com.example.studentbudget.databinding.FragmentExpensesBinding
import com.example.studentbudget.model.BudgetViewModel
import com.example.studentbudget.model.BudgetViewModelFactory

class ExpensesFragment : Fragment() {

    lateinit var budget: Budget

    private val viewModel: BudgetViewModel by activityViewModels {
        BudgetViewModelFactory(
            (activity?.application as BudgetApplication).database
                .budgetDao()
        )

    }


    private var binding: FragmentExpensesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentExpensesBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }


    fun totalExpenses():Double {
        val stringInAccommodationField = binding?.accommodation?.text.toString()
        val accommodation = stringInAccommodationField.toDouble()
        val stringInSchoolUtilitiesField = binding?.schoolUtilities?.text.toString()
        val schoolUtilities = stringInSchoolUtilitiesField.toDouble()
        val stringInTransportField = binding?.transport?.text.toString()
        val transport = stringInTransportField.toDouble()
        val stringInFoodField = binding?.food?.text.toString()
        val food = stringInFoodField.toDouble()
        val stringInEntertainmentField = binding?.entertainment?.text.toString()
        val entertainment = stringInEntertainmentField.toDouble()
        val stringInPersonalUtilitiesField = binding?.personalUtilities?.text.toString()
        val personalUtilities = stringInPersonalUtilitiesField.toDouble()


        val totalExpenses =  accommodation + schoolUtilities + transport + food + entertainment + personalUtilities
        return totalExpenses

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            save.setOnClickListener { goToNextScreen() }
        }

    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_expensesFragment_to_budgetFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}