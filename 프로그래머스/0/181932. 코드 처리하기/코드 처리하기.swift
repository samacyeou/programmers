import Foundation

func solution(_ code:String) -> String {
    var result: Array<Character> = []
    var arr = Array(code)
    var mode = 0

    for i in 0..<arr.count {
        if arr[i] == "1" { // 모드 변경
            mode = mode == 0 ? 1 : 0
            continue
        }

        if mode == 0 && i % 2 == 0 {
            result.append(arr[i])
        } else if mode == 1 && i % 2 == 1 {
            result.append(arr[i])
        }
    }

    return result.isEmpty ? "EMPTY" : String(result)
}