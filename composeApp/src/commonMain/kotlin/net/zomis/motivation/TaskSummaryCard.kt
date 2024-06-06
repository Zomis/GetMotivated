package net.zomis.motivation

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TaskSummaryCard(task: TaskViewModel, onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(6.dp).clickable(onClick = onClick).border(2.dp, color = Color.Gray)) {
        Text(task.title.value, modifier = Modifier.padding(2.dp))
        Text(task.motivation.value.asPercentString(), modifier = Modifier.padding(2.dp))
    }
}