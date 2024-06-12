import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.browser.window
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.zomis.motivation.MotivationTask
import net.zomis.motivation.TasksViewModel
import org.w3c.dom.get
import org.w3c.dom.set

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        val viewModel = remember { TasksViewModel() }
        window.onclose = {
            localStorage["tasks"] = viewModel.serialize()
        }
        LaunchedEffect(Unit) {
            val data = localStorage["tasks"] ?: return@LaunchedEffect
            viewModel.read(data)
        }
        App(viewModel)
    }
}

fun TasksViewModel.read(data: String) {
    val tasks = Json.decodeFromString<List<MotivationTask>>(data)
    this.setTasks(tasks)
}

fun TasksViewModel.serialize() = Json.encodeToString(this.serializedTasks())
