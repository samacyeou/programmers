import Foundation

func solution(_ survey:[String], _ choices:[Int]) -> String {
    var result = ""
    var charPoint = [Character: Int]()
    let sortedAlphaList: [Character] = ["R", "T", "C", "F", "J", "M", "A", "N"]
    let half = 4
    sortedAlphaList.forEach { charPoint[$0] = 0 }
    for (i, sv) in survey.enumerated() {
        // guard choices[i] != 4 else { continue }
        if choices[i] == 4 { continue }
        for (j, char) in sv.enumerated() {
            let leftRight = choices[i] < half ? 0 : 1
            guard j == leftRight else {
                // charPoint[char] = 0
                continue
            }
            var point = 0
            switch choices[i] {
            case 1, 7:
                point = 3
            case 2, 6:
                point = 2
            case 3, 5:
                point = 1
            default:
                point = 0
            }
            charPoint[char] = (charPoint[char] ?? 0) + point
            break
        }
    }
    for i in stride(from: 0, to: sortedAlphaList.count, by: 2) {
        guard i < sortedAlphaList.count - 1 else { break }
        if let leftPoint = charPoint[sortedAlphaList[i]],
            let rightPoint = charPoint[sortedAlphaList[i + 1]] {
            if leftPoint >= rightPoint {
                result += String(sortedAlphaList[i])
            } 
            if leftPoint < rightPoint {
                result += String(sortedAlphaList[i + 1])
            }
            if result.count == 4 {
                break
            }
        }
    }
    return result
}