package com.starmakerinteractive.starmak.ui.game.slot

import android.util.Log
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
    var isRoll by mutableStateOf(false)

    val score = scoreRepositoryImpl.getScore()

    var currentBet by mutableStateOf(0)

    var lastWin by mutableStateOf(0)

    fun rollSlots() {
        if (!isRoll) {
            isRoll = true
        }
    }

    fun updateSlots(slotId: Int, list: List<SlotModel>, initial: Boolean = false) {
        Log.d("TAG", "updateSlots: $slotId")
        isRoll = false
        listOfSlots.remove(slotId)
        listOfSlots[slotId] = list

        if (!initial && slotId == 5 && currentBet != 0) {
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
            Log.d("TAG", "updateSlots: $matches")
            if (matches != 0) saveScore(matches)
        }
    }

    fun increaseBet() = viewModelScope.launch {
        if (currentBet < score.first().score && !isRoll) {
            currentBet += 50
        }
    }

    fun decreaseBet() = viewModelScope.launch {
        if (currentBet != 0 && !isRoll) {
            currentBet -= 50
        }
    }

    fun maxBet() = viewModelScope.launch {
        if (!isRoll) {
            currentBet = score.first().score
        }
    }

    private fun saveScore(matches: Int) = viewModelScope.launch(Dispatchers.IO) {
        val newScore = score.first().score + (1000 * matches)
        lastWin = newScore
        scoreRepositoryImpl.updateScore(ScoreModel(1, newScore))
    }
}