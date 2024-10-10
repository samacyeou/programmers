class Solution {

    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        val videoLenSecond = timeToSecond(video_len)
        var posSecond = timeToSecond(pos)
        val opStartSecond = timeToSecond(op_start)
        val opEndSecond = timeToSecond(op_end)

        if (posSecond in opStartSecond..opEndSecond) {
            posSecond = opEndSecond
        }

        commands.forEach { command ->
            when (command) {
                "prev" -> {
                    if (posSecond - 10 < 0) {
                        posSecond = 0
                    } else {
                        posSecond -= 10
                    }
                    
                    if (posSecond in opStartSecond..opEndSecond) {
                        posSecond = opEndSecond
                    }
                }
                "next" -> {
                    if (posSecond + 10 > videoLenSecond) {
                        posSecond = videoLenSecond
                    } else {
                        posSecond += 10
                    }
                    
                    if (posSecond in opStartSecond..opEndSecond) {
                        posSecond = opEndSecond
                    }
                }
            }
        }

        if (posSecond in opStartSecond..opEndSecond) {
            posSecond = opEndSecond
        }

        return secondToTime(posSecond)
    }

    fun timeToSecond(time: String): Int {

        val (minute, second) = time.replace("\"", "")
            .split(":")
            .map { it.toInt() }

        return minute * 60 + second
    }

    fun secondToTime(second: Int): String {

        val minute = second / 60
        val second = second % 60

        return String.format("%02d:%02d", minute, second)
    }

}