package com.starmakerinteractive.starmak.ui.game.menu

import androidx.lifecycle.ViewModel
import com.starmakerinteractive.starmak.data.source.local.repo.ScoreRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    scoreRepositoryImpl: ScoreRepositoryImpl
) : ViewModel() {
    val scoreModel = scoreRepositoryImpl.getScore()
}