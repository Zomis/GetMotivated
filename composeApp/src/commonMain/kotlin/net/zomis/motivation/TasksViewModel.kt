package net.zomis.motivation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class TasksViewModel {

    private val _tasks = mutableStateOf<List<MotivationTask>>(emptyList())
    val tasks: State<List<MotivationTask>> = _tasks

    @OptIn(ExperimentalStdlibApi::class)
    fun createId(): String = tasks.value.hashCode().toHexString()

}