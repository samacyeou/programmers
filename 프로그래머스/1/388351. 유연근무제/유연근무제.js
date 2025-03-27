function solution(schedules, timelogs, startday) {
    var answer = 0;

    function getScheduleTime(num) {
        const hour = Math.floor(num / 100);
        const minute = Math.floor(num % 100);

        let total = (hour * 60) + minute + 10;

        const nhour = Math.floor(total / 60);
        const nminute = Math.floor(total % 60);

        return nhour * 100 + nminute;
    }

    for (let i = 0; i < schedules.length; i++) {
        const s = getScheduleTime(schedules[i]);

        let d = startday - 1;
        let flag = true;
        for (let j = 0; j < 7; j++) {
            d++;
            if (d % 7 === 6 || d % 7 === 0) continue;
            if (s < timelogs[i][j]) {
                flag = false;
                break;
            }
        }

        if (flag) answer++;
    }

    return answer;
}