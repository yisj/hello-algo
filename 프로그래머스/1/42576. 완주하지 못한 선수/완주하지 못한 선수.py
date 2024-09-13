def solution(participant, completion):

    player = dict()

    for p in participant:
        if p not in player:
            player[p] = 1
        else:
            player[p] += 1

    for c in completion:
        player[c] -= 1
    
    answer = ''
    for key in player:
        if player[key] != 0:
            answer = key
            break

    
    return answer