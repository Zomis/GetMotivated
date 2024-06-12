package net.zomis.motivation

import androidx.compose.ui.graphics.Color

data class ColorWithBorder(val color: Color, val border: Color)
data class ColorTheme(val subtask: Color, val task: ColorWithBorder, val group: ColorWithBorder)

class Colors {

    val expectancy = ColorTheme(
        subtask = Color(248, 241, 227),
        task = ColorWithBorder(color = Color(242, 228, 160), border = Color(239, 208, 84)),
        group = ColorWithBorder(color = Color(239, 208, 84), border = Color(203, 180, 29)),
    )

    val value = ColorTheme(
        subtask = Color(234, 243, 247),
        task = ColorWithBorder(Color(205, 232, 250), Color(172, 212, 239)),
        group = ColorWithBorder(Color(152, 198, 229), Color(102, 163, 204)),
    )

    val impulsiveness = ColorTheme(
        subtask = Color(230, 236, 219),
        task = ColorWithBorder(Color(210, 242, 160), Color(195, 224, 150)),
        group = ColorWithBorder(Color(173, 215, 106), Color(126, 172, 52)),
    )

    val red = ColorTheme(
        subtask = Color(252, 240, 235),
        task = ColorWithBorder(Color(250, 217, 205), Color(250, 198, 180)),
        group = ColorWithBorder(Color(245, 172, 147), Color(229, 153, 123)),
    )

}