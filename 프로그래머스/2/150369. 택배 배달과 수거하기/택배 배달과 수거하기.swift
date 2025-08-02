import Foundation
func solution(_ cap:Int, _ n:Int, _ deliveries:[Int], _ pickups:[Int]) -> Int64 {
    // 꼼꼼히 문제분석
    // 문제 조건 - 시간복잡도 한계 예측 및 알고리즘 추려내기 (이진탐색, BFS, DFS, 등)
    // 구현방법 선정
    // 알고리즘? & 시간복잡도

    // 가장 먼 곳 부터 갔다오는게 최적 -> 가장먼곳의 배달 & 수거개수를 맞추면서 내려와야함.
    // 단순구현..?
    var deliveries = deliveries
    var pickups = pickups

    var totalDistance: Int64 = 0

    var dIndex = n - 1
    var pIndex = n - 1

    while dIndex >= 0 || pIndex >= 0 {
        while dIndex >= 0 && deliveries[dIndex] == 0 { dIndex -= 1 } // delivery인덱스 내려줌
        while pIndex >= 0 && pickups[pIndex] == 0 { pIndex -= 1 } // pickup 인덱스 내려줌
        if dIndex < 0 && pIndex < 0 { break }
        var inTruck = 0

        if dIndex >= 0 {
            for i in 0...dIndex {
                let currentIndex = dIndex - i
                if deliveries[currentIndex] == 0 { continue }
                if cap >= inTruck + deliveries[currentIndex] {
                    inTruck += deliveries[currentIndex]
                    deliveries[currentIndex] = 0
                } else if cap < inTruck + deliveries[currentIndex] {
                    let diff = cap - inTruck
                    inTruck = cap
                    deliveries[currentIndex] -= diff
                }
                if inTruck == cap { break }
            }
        }

        inTruck = 0

        if pIndex >= 0 {
            for i in 0...pIndex {
                let currentIndex = pIndex - i
                if pickups[currentIndex] == 0 { continue }
                if cap >= inTruck + pickups[currentIndex] {
                    inTruck += pickups[currentIndex]
                    pickups[currentIndex] = 0
                } else if cap < inTruck + pickups[currentIndex] {
                    let diff = cap - inTruck
                    pickups[currentIndex] -= diff
                    inTruck = cap
                }
                if inTruck == cap { break }
            }
        }
        totalDistance += Int64((max(pIndex, dIndex) + 1) * 2)
    }

    return totalDistance
}