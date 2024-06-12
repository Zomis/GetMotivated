import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.zomis.motivation.*
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(tasksViewModel: TasksViewModel) {
    var screen by remember {
        mutableStateOf<ActiveScreen>(ActiveScreen.None)
    }

    MaterialTheme {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxWidth(0.3f).fillMaxHeight()) {
                Button({
                    screen = ActiveScreen.Summary(tasksViewModel.newTask())
                }, modifier = Modifier.fillMaxWidth().padding(6.dp)) {
                    Text("Add task")
                }
                val sortedTasks = derivedStateOf {
                    tasksViewModel.tasks.value.sortedByDescending { it.motivation.value }
                }

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(sortedTasks.value, key = { it.taskId }) {
                        TaskSummaryCard(it) { screen = ActiveScreen.Summary(it) }
                    }
                }
            }
            Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
                Button({}, modifier = Modifier.fillMaxWidth().padding(6.dp)) {
                    Text("Get motivated NOW!")
                }

                when (val it = screen) {
                    ActiveScreen.None -> {}
                    is ActiveScreen.Summary -> {
                        // sliders and summary (title + what are you avoiding)
                        TaskSummaryEdit(it.taskViewModel)
                    }
                    is ActiveScreen.GroupOverview -> {
                        // overview of group (value, expectancy, impulsiveness...)
                        GroupOverview(it.group)
                    }
                    is ActiveScreen.StepDetail -> {
                        // specific task detailed information (+ possible text field for notes), e.g. "splash some water on your face"
                        DetailView(it.detail)
                    }
                }
            }
        }
    }
}