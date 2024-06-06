import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import net.zomis.motivation.MotivationTask
import net.zomis.motivation.TasksViewModel
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.inputStream
import kotlin.io.path.outputStream

private val file = Paths.get("tasks.json")
fun main() = application {
    val tasks = remember {
        TasksViewModel()
    }
    LaunchedEffect(Unit) {
        try {
            tasks.readFromFile(file)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    Window(
        onCloseRequest = {
            tasks.writeToFile(file)
            exitApplication()
        },
        title = "GetMotivated",
        state = rememberWindowState(position = WindowPosition(Alignment.Center)),
    ) {
        App(tasks)
    }
}

@OptIn(ExperimentalSerializationApi::class)
fun TasksViewModel.readFromFile(path: Path) {
    val tasks = Json.decodeFromStream<List<MotivationTask>>(path.inputStream())
    this.setTasks(tasks)
}

@OptIn(ExperimentalSerializationApi::class)
fun TasksViewModel.writeToFile(path: Path) {
    Json.encodeToStream(this.serializedTasks(), path.outputStream())
}
