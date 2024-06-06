package net.zomis.motivation

data class MotivationDetail(
    val name: String,
    val subtasks: List<String>
)

val expectancyTasks = listOf(
    MotivationDetail(
        name = "Action is required",
        subtasks = listOf("Remember: Lack of effort guarantees failure!")
    ),
    MotivationDetail(
        name = "Recognize Success",
        subtasks = listOf(
            "Achieve one goal after another.",
            "Recognize small improvements as *victories.*",
            "Keep a daily log."
        )
    ),
    MotivationDetail(
        name = "Get Inspired",
        subtasks = listOf(
            "Make your inspirations visible.",
            "Know what inspires you and why.",
            "Review your inspirations."
        )
    ),
    MotivationDetail(
        name = "Plan for the Worst, Hope for the Best",
        subtasks = listOf(
            "What could go wrong?",
            "Draw on past experiences.",
            "Make a backup plan."
        )
    ),
    MotivationDetail(
        name = "Accept Your Procrastination",
        subtasks = listOf(
            "Remember that you are human.",
            "Log your procrastination habits.",
            "Don't trivialize \"I'll only give in once.\""
        )
    ),
    MotivationDetail(
        name = "Contrast",
        subtasks = listOf(
            "Compare *ideal* state with *current* state.",
            "Visualize and contrast the present and future."
        )
    ),
    MotivationDetail(
        name = "Check Your Mindset",
        subtasks = listOf(
            "Nothing is carved in stone.",
            "Qualities and skills are cultivated through effort."
        )
    )
)

val impulsivenessTasks = listOf(
    MotivationDetail(
        name = "Set a Goal",
        subtasks = listOf(
            "Make them: *Specific* *Realistic* *Meaningful*",
            "Break it down!",
            "*Input* - \"For x minutes.\" - is often better than *output* - \"Finish this.\"",
            "\"*Achieve this*\" is better than \"*Avoid that*\""
        )
    ),
    MotivationDetail(
        name = "Run a \"Dash\"",
        subtasks = listOf("Commit to doing it for only 5 minutes, set a timer.")
    ),
    MotivationDetail(
        name = "Eliminate Temptations",
        subtasks = listOf(
            "Recognize what is tempting you.",
            "Eliminate it! (Or hide it.)",
            "Focus on the *abstract* aspects of your temptation (not the fun parts)."
        )
    ),
    MotivationDetail(
        name = "Make Failure Painful",
        subtasks = listOf(
            "How will failure be painful?",
            "Make it more painful.",
            "Make a costly bet with someone."
        )
    ),
    MotivationDetail(
        name = "Eliminate Distractions",
        subtasks = listOf(
            "Recognize what is distracting you.",
            "Eliminate it! (Or hide it.)"
        )
    ),
    MotivationDetail(
        name = "Create Routines & Habits",
        subtasks = listOf(
            "Can part of this be turned into a habit?",
            "Can part of this be added to an existing routine?",
            "Separate work and play.",
            "Schedule leisure before work."
        )
    ),
    MotivationDetail(
        name = "Use Goal Reminders",
        subtasks = listOf(
            "Read an inspiring quote.",
            "*Look* at your goals.",
            "Make your goals visible."
        )
    ),
    MotivationDetail(
        name = "Stop Suppressing Thoughts",
        subtasks = listOf("Do not 'force' distractions out of your head.")
    ),
    MotivationDetail(
        name = "Make Progress Visual",
        subtasks = listOf("Track your progress.")
    ),
    MotivationDetail(
        name = "Use Negative Pairing",
        subtasks = listOf(
            "Pair temptations with undesirable images.",
            "Imagine a disastrous outcome."
        )
    )
)

val valueTasks = listOf(
    MotivationDetail(
        name = "Find Meaning",
        subtasks = listOf(
            "Set and review your major life goals.",
            "How does this connect?"
        )
    ),
    MotivationDetail(
        name = "Find Flow",
        subtasks = listOf(
            "Match difficulty with skill.",
            "Too easy? Make it harder. Too hard? Make it easier."
        )
    ),
    MotivationDetail(
        name = "Create Competition",
        subtasks = listOf(
            "Compete against yourself.",
            "Compete against others.",
            "Turn it into a game, make it fun!"
        )
    ),
    MotivationDetail(
        name = "Get Some Energy",
        subtasks = listOf(
            "Get your blood moving.",
            "Splash cold water on your face.",
            "Eat well.",
            "Energize your environment. (e.g. music)",
            "Plan around your energy, not your time."
        )
    ),
    MotivationDetail(
        name = "Create a Reward",
        subtasks = listOf(
            "Reward your success.",
            "Make the situation more rewarding."
        )
    ),
    MotivationDetail(
        name = "Keep Your Brain Healthy",
        subtasks = listOf(
            "Get enough sleep.",
            "Exercise regularly.",
            "Take genuine breaks.",
            "Reduce your commitments."
        )
    ),
    MotivationDetail(
        name = "Use Productive Procrastination",
        subtasks = listOf("What can you avoid doing by doing this?")
    ),
    MotivationDetail(
        name = "Add Accountability",
        subtasks = listOf(
            "Who knows about this?",
            "Can you make it public?"
        )
    ),
    MotivationDetail(
        name = "Mix Bitter & Sweet",
        subtasks = listOf(
            "Combine long-term interests with short-term gains."
        )
    ),
    MotivationDetail(
        name = "Find Passion",
        subtasks = listOf(
            "Know what you are passionate about.",
            "Is this connected?",
            "Is this intrinsically motivating?"
        )
    )
)
