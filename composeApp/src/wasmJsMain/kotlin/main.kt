import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.browser.window
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.zomis.motivation.MotivationTask
import net.zomis.motivation.TasksViewModel
import org.w3c.dom.get
import org.w3c.dom.set

@OptIn(ExperimentalComposeUiApi::class, FlowPreview::class)
fun main() {
    ComposeViewport(document.body!!) {
        val viewModel = remember { TasksViewModel() }
        LaunchedEffect(Unit) {
            launch {
                val data = localStorage["tasks"] ?: return@launch
                viewModel.read(data)
            }.join()

            // Periodically save
            val flow: Flow<List<MotivationTask>> = flow {
                while (true) {
                    emit(viewModel.serializedTasks())
                    delay(2000)
                }
            }
            // Ignore first - no need to save what we just read
            flow.drop(1).distinctUntilChanged().debounce(1000).collect {
                localStorage["tasks"] = viewModel.serialize()
            }
        }
        App(viewModel)
    }
}

fun TasksViewModel.read(data: String) {
    val tasks = Json.decodeFromString<List<MotivationTask>>(data)
    this.setTasks(tasks)
}

fun TasksViewModel.serialize() = Json.encodeToString(this.serializedTasks())
