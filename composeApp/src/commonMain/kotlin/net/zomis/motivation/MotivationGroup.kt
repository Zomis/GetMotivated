package net.zomis.motivation

enum class MotivationGroup(val positive: Boolean, val steps: List<MotivationDetail>) {
    Expectancy(positive = true, expectancyTasks),
    Value(positive = true, valueTasks),
    Impulsiveness(positive = false, impulsivenessTasks),
    Delay(positive = false, emptyList()),
}
