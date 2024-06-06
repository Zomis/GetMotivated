package net.zomis.motivation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TaskSummaryEdit(taskViewModel: TaskViewModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(taskViewModel.title.value, { taskViewModel.title.value = it }, modifier = Modifier.weight(1f).padding(6.dp))
            TextField(taskViewModel.description.value, { taskViewModel.description.value = it }, modifier = Modifier.weight(1f).padding(6.dp))
        }

        MotivationSlider("Expectancy", taskViewModel.expectancy)
        MotivationSlider("Value", taskViewModel.value)
        MotivationSlider("Impulsiveness", taskViewModel.impulsiveness)
        MotivationSlider("Delay", taskViewModel.delay)

        Spacer(modifier = Modifier.height(12.dp))
        Text("Motivation")
        Text(taskViewModel.motivation.value.toString())
    }
}

@Composable
private fun MotivationSlider(title: String, value: MutableState<Float>) {
    Row(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
        Text(title, modifier = Modifier.fillMaxWidth(0.3f))
        Slider(value.value, { value.value = it }, modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
private fun TaskSummaryEditPreview() {
    TaskSummaryEdit(TaskViewModel(""))
}
