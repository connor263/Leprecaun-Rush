package com.starmakerinteractive.starmak

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {
    val stringRoute = mutableStateOf("")
    val isLoading = mutableStateOf(true)
}