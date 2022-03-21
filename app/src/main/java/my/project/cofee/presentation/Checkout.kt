package my.project.cofee.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import my.project.cofee.R
import my.project.cofee.databinding.CheckoutBinding

private var binding: CheckoutBinding? = null

class Checkout : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.checkout, container, false)

        return binding?.root
    }

}