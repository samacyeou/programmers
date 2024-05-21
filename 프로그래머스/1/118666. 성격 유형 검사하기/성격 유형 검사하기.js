function solution(survey, choices) {
    var answer = '';
    var result = [];

    let surveyMap = new Map();

    surveyMap.set("R", 0);
    surveyMap.set("T", 0);
    surveyMap.set("C", 0);
    surveyMap.set("F", 0);
    surveyMap.set("J", 0);
    surveyMap.set("M", 0);
    surveyMap.set("A", 0);
    surveyMap.set("N", 0);

    survey.map((value, index) => {
        if(choices[index] == 1) surveyMap.set(value[0], surveyMap.get(value[0]) + 3);       
        else if(choices[index] == 2) surveyMap.set(value[0], surveyMap.get(value[0]) + 2); 
        else if(choices[index] == 3) surveyMap.set(value[0], surveyMap.get(value[0]) + 1);
        else if(choices[index] == 4) {}
        else if(choices[index] == 5) surveyMap.set(value[1], surveyMap.get(value[1]) + 1);
        else if(choices[index] == 6) surveyMap.set(value[1], surveyMap.get(value[1]) + 2);
        else if(choices[index] == 7) surveyMap.set(value[1], surveyMap.get(value[1]) + 3);
    });

    for(var i=0; i<[...surveyMap].length; i+=2){
        //console.log(`now surveyMap[i][0]: ${[...surveyMap][i]}`)
        if([...surveyMap][i][1] > [...surveyMap][i+1][1]) result.push([...surveyMap][i][0]);
        else if([...surveyMap][i][1] < [...surveyMap][i+1][1]) result.push([...surveyMap][i+1][0]);
        else if([...surveyMap][i][1] == [...surveyMap][i+1][1]){
            //console.log("same score!!");
            //console.log([...surveyMap].join().charCodeAt(i*4), [...surveyMap].join().charCodeAt(i*4+4));
            result.push([...surveyMap][i][0]);
        }
    }

    answer = result.join('');
    //console.log(result);
    return answer;
}