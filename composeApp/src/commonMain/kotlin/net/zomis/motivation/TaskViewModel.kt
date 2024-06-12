package net.zomis.motivation

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import net.zomis.motivation.MotivationGroup.*
import kotlin.math.absoluteValue
import kotlin.math.round

class TaskViewModel(val taskId: String) {

    val expectancy = mutableStateOf(0.5f)
    val value = mutableStateOf(0.5f)
    val impulsiveness = mutableStateOf(0.5f)
    val delay = mutableStateOf(0.5f)

    val title = mutableStateOf("Title")
    val description = mutableStateOf("Description")

    val motivation = derivedStateOf {
        motivation(expectancy.value, value.value, impulsiveness.value, delay.value)
    }

    private fun motivation(expectancy: Float, value: Float, impulsiveness: Float, delay: Float): Float
        = (expectancy * value) / (1 + impulsiveness * delay)

    private fun motivationDelta(group: MotivationGroup): Float {
        val h = if (group.positive) .0001f else -.0001f
        val fxh = when (group) {
            Expectancy -> motivation(expectancy.value + h, value.value, impulsiveness.value, delay.value)
            Value -> motivation(expectancy.value, value.value + h, impulsiveness.value, delay.value)
            Impulsiveness -> motivation(expectancy.value, value.value, impulsiveness.value + h, delay.value)
            Delay -> motivation(expectancy.value, value.value, impulsiveness.value, delay.value + h)
        }
        val fx = motivation.value
        return (fxh - fx) / h.absoluteValue
    }

    val improvements = derivedStateOf {
        MotivationGroup.entries.map { it to motivationDelta(it) }.sortedByDescending { it.second }
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
