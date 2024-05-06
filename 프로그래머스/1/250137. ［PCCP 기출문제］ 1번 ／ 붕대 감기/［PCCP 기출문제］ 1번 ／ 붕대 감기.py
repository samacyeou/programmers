def solution(bandage, health, attacks):
    answer = 0

    max_hp = health
    attack_time = []
    each_damage = []

    for i in attacks:
        attack_time.append(i[0])
        each_damage.append(i[1])

    constant_rehap = 0
    for i in range (1, attack_time[-1]+1):

        if i in attack_time:
            health -= each_damage[0]
            if health <= 0:
                return -1
            each_damage.pop(0)
            constant_rehap = 0

        else:
            # if health < max_hp:
            health += bandage[1]
            constant_rehap += 1

            if constant_rehap == bandage[0]:
                health += bandage[2]
                constant_rehap = 0

            if health > max_hp:
                health = max_hp

    answer = health

    return answer