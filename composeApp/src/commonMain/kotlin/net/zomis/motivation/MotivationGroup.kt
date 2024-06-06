package net.zomis.motivation

enum class MotivationGroup(val steps: List<MotivationDetail>) {
    Expectancy(expectancyTasks),
    Value(valueTasks),
    Impulsiveness(impulsivenessTasks),
    Delay(emptyList()),
}
