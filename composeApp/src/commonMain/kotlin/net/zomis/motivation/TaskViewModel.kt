package net.zomis.motivation

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf

class TaskViewModel(val taskId: String) {

    val expectancy = mutableStateOf(0.5f)
    val value = mutableStateOf(0.5f)
    val impulsiveness = mutableStateOf(0.5f)
    val delay = mutableStateOf(0.5f)

    val title = mutableStateOf("Title")
    val description = mutableStateOf("Description")

    val motivation = derivedStateOf {
        (expectancy.value * value.value) / (1 + impulsiveness.value * delay.value)
    }

}
