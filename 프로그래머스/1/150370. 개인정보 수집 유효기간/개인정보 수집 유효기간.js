/*
오늘 날짜를 의미하는 문자열 today : YYYY.MM.DD
약관의 유효기간을 담은 1차원 문자열 배열 terms : 약관종류(A~Z) 유효기간(1~100)
수집된 개인정보의 정보를 담은 1차원 문자열 배열 privacies : 날짜(YYYY.MM.DD) 약관종류

파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return 

주의할 점: 1 ≤ DD ≤ 28
*/

function solution(today, terms, privacies) {
    //유효기간 / 12 = 년
    //유효기간 % 12 = 월
    //유효기간 -> 00.00의 숫자로 치환
    //privacies의 YYYY.MM + 00.00 + ".DD" 와 today 비교
    //연도, 월, 날짜 순서대로 비교하면서 break 걸기
    const [ty, tm, td] = today.split(".").map(t => +t);

    terms = terms.map(t => t.split(" "));

    const obj = {};
    terms.forEach(t =>{
        obj[t[0]] = +t[1];
    })

    privacies = privacies.map(p => p.split(" "));

    const trash = [];

    privacies.forEach((p,i)=>{
        const [year, month, day] = p[0].split(".").map(r => +r);
        const value = obj[p[1]];
        const idx = value % 12;
        let aday = day - 1;
        let amonth = month + idx;
        let ayear = year + Math.floor(value / 12);

        if(aday === 0){
            aday = 28;
            amonth -= 1;
        }
        if(amonth > 12){
            ayear = ayear + Math.floor(amonth / 12);
            amonth = amonth % 12 === 0 ? 12 : amonth % 12;
        }
        

        const isBigDay = td < aday;
        const isBigMonth = tm < amonth;
        const isBigYear = ty < ayear;
        switch(true){
            case isBigYear:
                break;
            case isBigMonth:
                if(ty === ayear) break;
            case isBigDay:
                if(tm === amonth && ty === ayear) break;
            default:
                if(ty === ayear && tm === amonth && td === aday){}
                else trash.push(i + 1)
        }
    })
    return trash;
}