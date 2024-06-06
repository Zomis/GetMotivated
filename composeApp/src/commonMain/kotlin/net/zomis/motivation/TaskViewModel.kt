package net.zomis.motivation

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import kotlin.math.exp
import kotlin.math.round

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

    fun setFromData(task: MotivationTask) {
        this.expectancy.value = task.expectancy
        this.value.value = task.value
        this.impulsiveness.value = task.impulsiveness
        this.delay.value = task.delay
        this.title.value = task.title
        this.description.value = task.description
    }

    fun toData(): MotivationTask = MotivationTask(
        taskId = taskId,
        expectancy = expectancy.value,
        value = value.value,
        impulsiveness = impulsiveness.value,
        delay = delay.value,
        title = title.value,
        description = description.value,
    )

}

fun Float.asPercentString(): String = round(this * 1000f).div(10).toString() + "%"
