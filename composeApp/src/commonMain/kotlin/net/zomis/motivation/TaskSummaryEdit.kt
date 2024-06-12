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
import kotlin.math.round

@Composable
fun TaskSummaryEdit(taskViewModel: TaskViewModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(start = 6.dp, end = 6.dp, bottom = 6.dp)) {
            Text("Title")
            TextField(taskViewModel.title.value, { taskViewModel.title.value = it }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(3.dp))
            Text("What are you not motivated to do?")
            TextField(taskViewModel.description.value, { taskViewModel.description.value = it }, modifier = Modifier.fillMaxWidth())
        }

        Column(modifier = Modifier.padding(6.dp)) {
            MotivationSlider("Expectancy", taskViewModel.expectancy)
            MotivationSlider("Value", taskViewModel.value)
            MotivationSlider("Impulsiveness", taskViewModel.impulsiveness)
            MotivationSlider("Delay", taskViewModel.delay)
        }

        Column(modifier = Modifier.padding(6.dp)) {
            Text("Motivation")
            Text(taskViewModel.motivation.value.toString())
            Text("Recommended improvements")
            Text(taskViewModel.improvements.value.toString())
        }
    }
}

@Composable
private fun MotivationSlider(title: String, value: MutableState<Float>) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp)) {
        val intValue = round(value.value * 1000).div(10).toString() + "% "
        Text(intValue + title, modifier = Modifier.fillMaxWidth(0.3f))
        Slider(value.value, { value.value = it }, modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
private fun TaskSummaryEditPreview() {
    TaskSummaryEdit(TaskViewModel(""))
}
