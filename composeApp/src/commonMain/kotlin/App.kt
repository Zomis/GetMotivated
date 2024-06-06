import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
fun App() {
    val tasksViewModel = remember {
        TasksViewModel()
    }
    var screen by remember {
        mutableStateOf<ActiveScreen>(ActiveScreen.None)
    }

    MaterialTheme {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxWidth(0.3f).fillMaxHeight()) {
                Button({
                    screen = ActiveScreen.Summary(TaskViewModel(tasksViewModel.createId()))
                }, modifier = Modifier.fillMaxWidth().padding(6.dp)) {
                    Text("Add task")
                }
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    // tasks
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