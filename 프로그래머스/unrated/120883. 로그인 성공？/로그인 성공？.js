function checkLogin(id_pw, db) {
    let loginCheck = '';
    for (let id of db) {
        if (id_pw[0] === id[0]) {
            if (id_pw[1] === id[1]) {
                loginCheck = "login";
                break;
            } else {
                loginCheck = "wrong pw";
                break;
            }
        }
    }
    
    if (!loginCheck) loginCheck = "fail";
    
    return loginCheck;
}

function solution(id_pw, db) {
    let answer = '';
    
    answer = checkLogin(id_pw, db);
    
    return answer;
}