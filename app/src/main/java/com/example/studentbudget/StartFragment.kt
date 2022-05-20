package com.example.studentbudget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.studentbudget.data.Budget
import com.example.studentbudget.databinding.FragmentStartBinding
import com.example.studentbudget.model.BudgetViewModel
import com.example.studentbudget.model.BudgetViewModelFactory



class StartFragment : Fragment() {


    private val viewModel: BudgetViewModel by activityViewModels {
        BudgetViewModelFactory(
            (activity?.application as BudgetApplication).database
                .budgetDao()
        )


    }

    lateinit var budget: Budget


    private var binding: FragmentStartBinding? = null



    val name = binding?.userName?.text.toString()
    val stringInBudgetField = binding?.income?.text.toString()
    val income = stringInBudgetField.toDouble()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            nextButton.setOnClickListener { goToNextScreen() }
        }

    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_startFragment_to_expensesFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}


