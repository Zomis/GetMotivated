package net.zomis.motivation

sealed interface ActiveScreen {

    data object None : ActiveScreen
    class Summary(val taskViewModel: TaskViewModel) : ActiveScreen
    class GroupOverview(val group: MotivationGroup) : ActiveScreen
    class StepDetail(val detail: MotivationDetail) : ActiveScreen

}
