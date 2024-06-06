package net.zomis.motivation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class TasksViewModel {

    private val _tasks = mutableStateOf<List<TaskViewModel>>(emptyList())
    val tasks: State<List<TaskViewModel>> = _tasks

    @OptIn(ExperimentalStdlibApi::class)
    private fun createId(): String = tasks.value.hashCode().toHexString()

    fun newTask(): TaskViewModel {
        val vm = TaskViewModel(createId())
        _tasks.value += vm
        return vm
    }

    fun setTasks(tasks: List<MotivationTask>) {
        _tasks.value = tasks.map {
            TaskViewModel(it.taskId).apply { setFromData(it) }
        }
    }

    fun serializedTasks(): List<MotivationTask> = _tasks.value.map { it.toData() }

}