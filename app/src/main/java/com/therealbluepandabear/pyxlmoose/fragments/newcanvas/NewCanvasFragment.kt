package com.therealbluepandabear.pyxlmoose.fragments.newcanvas

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.therealbluepandabear.pyxlmoose.databinding.FragmentNewCanvasBinding
import com.therealbluepandabear.pyxlmoose.listeners.NewCanvasFragmentListener

class NewCanvasFragment : Fragment() {
    var root: View? = null

    private fun instantiateRoot() {
        root = binding.fragmentNewCanvasRootLayout
    }

    private fun setup() {
        instantiateRoot()
        setOnClickListeners()
    }

    companion object {
        fun newInstance(): NewCanvasFragment {
            return NewCanvasFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NewCanvasFragmentListener) caller = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding_ = FragmentNewCanvasBinding.inflate(inflater, container, false)

        setup()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding_ = null
    }
}