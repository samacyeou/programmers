import Foundation

func solution(_ board:[[Int]]) -> Int {
    let maxRows = board.count
    let maxColumns = maxRows
    let totalCells = maxRows * maxColumns
    let mineValue = 1
    let mineRange = 1
    let checkingPointOffsets: [(Int, Int)] 
        = (-mineRange...mineRange).flatMap{ offsetY in
            return (-mineRange...mineRange).map{ offsetX in
                (offsetX, offsetY)
            }
        }

    var mineCount = 0

    func isInMineRange(row: Int, column: Int) -> Bool {
        let checkingPoints = checkingPointOffsets
            .map { (offsetX, offsetY) in
                (offsetX + row, offsetY + column)
            }.filter { (newColumn, newRow) in
                newColumn >= 0 && newColumn < maxColumns
                && newRow >= 0 && newRow < maxRows
            }

        guard checkingPoints.contains(where: { board[$1][$0] == 1 }) else {
            return false
        }

        return true
    }

    for r in 0..<maxRows {
        for c in 0..<maxColumns {
            guard isInMineRange(row: r, column: c) else {
                continue
            }

            mineCount += 1
        }
    }

    return totalCells - mineCount
}