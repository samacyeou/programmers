import Foundation

struct Person: Equatable {
    var name: String
    var giftIndex: Int
    var friends: [Friend]
}

struct Friend: Equatable {
    var name: String
    var sent: Int
    var received: Int
}

func solution(_ friends:[String], _ gifts:[String]) -> Int {
    var sent: [Int] = friends.map { _ in 0 }
    var received: [Int] = friends.map { _ in 0 }
    for action in gifts {
        let sender = action.components(separatedBy: " ").first!
        let receiver = action.components(separatedBy: " ").last!
        guard friends.contains(sender), friends.contains(receiver) else { continue }
        guard sender != receiver else { continue }
        let indexOfSender = friends.firstIndex(of: sender)!
        let indexOfReceiver = friends.firstIndex(of: receiver)!
        sent[indexOfSender] += 1
        received[indexOfReceiver] += 1
    }
    var personInfo: [Person] = []
    for i in 0..<friends.count {
        var user = Person(name: friends[i], giftIndex: sent[i] - received[i], friends: [])
        for action in gifts {
            guard action.contains(user.name) else { continue }
            var userFriends = user.friends
            let sender = action.components(separatedBy: " ").first!
            let receiver = action.components(separatedBy: " ").last!
            guard friends.contains(sender), friends.contains(receiver) else { continue }
            guard sender != receiver else { continue }
            if sender == user.name {
                if var recvFriend = userFriends.filter { $0.name == receiver }.first, 
                let index = userFriends.firstIndex(of: recvFriend) {
                    recvFriend.sent += 1
                    userFriends[index] = recvFriend
                } else {
                    let newFriend = Friend(name: receiver, sent: 1, received: 0) 
                    userFriends.append(newFriend)
                }
            } else if receiver == user.name {
                if var sentFriend = userFriends.filter { $0.name == sender }.first, 
                let index = userFriends.firstIndex(of: sentFriend) {
                    sentFriend.received += 1
                    userFriends[index] = sentFriend
                } else {
                    let newFriend = Friend(name: sender, sent: 0, received: 1) 
                    userFriends.append(newFriend)
                }
            }
            user.friends = userFriends
        }
        personInfo.append(user)
    }
    var giftsNextMonth: [Int] = friends.map { _ in 0 }
    for user in personInfo {
        let userIndex = friends.firstIndex(of: user.name)!
        let friendsOnly = personInfo.filter { $0.name != user.name }
        for friend in friendsOnly {
            // 주고받은 이력 있음
                
            if let giftHistory = user.friends.first(where: {$0.name == friend.name }) {
                if giftHistory.sent > giftHistory.received {
                    // 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
                    giftsNextMonth[userIndex] += 1
                    continue
                } 
                if giftHistory.sent == giftHistory.received {
                    // 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
                    if user.giftIndex > friend.giftIndex {
                        giftsNextMonth[userIndex] += 1
                    }
                }
                continue
            } 

            // 주고받은 이력 없음
            if user.giftIndex > friend.giftIndex {
                // 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
                giftsNextMonth[userIndex] += 1
                continue
            }
        }
    }
    return giftsNextMonth.sorted(by: >).first!
}