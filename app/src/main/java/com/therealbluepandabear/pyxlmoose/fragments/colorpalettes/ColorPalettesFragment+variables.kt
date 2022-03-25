package com.therealbluepandabear.pyxlmoose.fragments.colorpalettes

import com.therealbluepandabear.pyxlmoose.databinding.FragmentColorPalettesBinding
import com.therealbluepandabear.pyxlmoose.listeners.ColorPalettesFragmentListener

var binding_: FragmentColorPalettesBinding? = null

val binding get(): FragmentColorPalettesBinding {
    return binding_!!
}

lateinit var caller: ColorPalettesFragmentListener