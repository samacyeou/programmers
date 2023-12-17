function compareLines(lines) {
    let differ = 0;
    
    for (let i = 0; i < lines.length - 1; i++) {
        let line1 = lines[i];
        
        for (let j = i + 1; j < lines.length; j++) {
            const line2 = lines[j];

            if (line1[0] <= line2[0]) {
                if (line1[1] <= line2[0]) continue;
                else if (line1[1] <= line2[1]) {
                    differ += line1[1] - line2[0];
                    [line1[1], lines[j][0]] = [line2[0], line1[1]];
                } else {
                    differ += line2[1] - line2[0];
                    lines[j] = [line2[1], line1[1]];
                    line1[1] = line2[0];
                    j = i;
                }
            } else {
                if (line1[0] >= line2[1]) continue;
                else if (line1[1] >= line2[1]) {
                    differ += line2[1] - line1[0];
                    [line1[0], lines[j][1]] = [line2[1], line1[0]];
                } else {
                    differ += line1[1] - line1[0];
                    lines[j] = [line1[1], line2[1]];
                    line1 = [line2[0], line1[0]];
                    j = i;
                }
            }
        }
        
    }

    return differ;
}


function solution(lines) {
    let answer = 0;
    
    answer = compareLines(lines);
    
    return answer;
}

