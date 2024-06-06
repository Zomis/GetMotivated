package net.zomis.motivation

data class MotivationTask(
    val taskId: String,
    val expectancy: Float,
    val value: Float,
    val impulsiveness: Float,
    val delay: Float,
    val title: String,
    val description: String
) {
    val motivation: Float get() = (expectancy * value) / (1 + impulsiveness * delay)
}
