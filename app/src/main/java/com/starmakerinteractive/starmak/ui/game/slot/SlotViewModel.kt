package com.starmakerinteractive.starmak.ui.game.slot

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.starmakerinteractive.starmak.data.model.game.ScoreModel
import com.starmakerinteractive.starmak.data.model.game.SlotModel
import com.starmakerinteractive.starmak.data.source.local.repo.ScoreRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SlotViewModel @Inject constructor(
    private val scoreRepositoryImpl: ScoreRepositoryImpl
) : ViewModel() {
    private val listOfSlots = mutableStateMapOf<Int, List<SlotModel>>()
    var isPlaying by mutableStateOf(false)

    val score = scoreRepositoryImpl.getScore()

    var currentInvestment by mutableStateOf(0)

    var lastProfit by mutableStateOf(0)

    fun playSlots() {
        if (!isPlaying) {
            isPlaying = true
        }
    }

    fun updateSlots(slotId: Int, list: List<SlotModel>, initial: Boolean = false) {
        isPlaying = false
        listOfSlots.remove(slotId)
        listOfSlots[slotId] = list

        if (!initial && slotId == 5 && currentInvestment != 0) {
            var matches = 0
            val lists = listOfSlots.values

            lists.forEach { currentList ->
                currentList.forEach { currentSlot ->


                    lists.forEach List@{ checkList ->
                        checkList.forEach { checkSlot ->
                            if (currentSlot.drawableRes == checkSlot.drawableRes &&
                                currentSlot.key < checkSlot.key &&
                                currentSlot.id == checkSlot.id
                            ) {
                                currentSlot.isMatch = true
                                checkSlot.isMatch = true
                                matches++
                            }
                        }
                    }
                }
            }
            if (matches != 0) saveScore(matches)
        }
    }

    fun increaseInvestment() = viewModelScope.launch {
        if (currentInvestment < score.first().score && !isPlaying) {
            currentInvestment += 50
        }
    }

    fun decreaseInvestment() = viewModelScope.launch {
        if (currentInvestment != 0 && !isPlaying) {
            currentInvestment -= 50
        }
    }

    fun maxInvestment() = viewModelScope.launch {
        if (!isPlaying) {
            currentInvestment = score.first().score
        }
    }

    private fun saveScore(matches: Int) = viewModelScope.launch(Dispatchers.IO) {
        val newScore = score.first().score + (1000 * matches)
        lastProfit = newScore
        scoreRepositoryImpl.updateScore(ScoreModel(1, newScore))
    }
}