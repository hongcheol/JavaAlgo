import itertools
import operator
def solution(orders, course):
    answer = []
    sort_orders = []
    for o in orders:
        o = sorted(o,key=lambda strings: strings[0])
        sort_orders.append(o)
    for menu_num in course:
        combo = dict()
        for order in sort_orders:
            if len(order) < menu_num:
                continue
            nCr = itertools.combinations(order,menu_num)
            for combi in nCr:
                s = ''
                for c in combi:
                    s += c
                #print(s)
                if s not in combo:
                    combo[s] = 0
                combo[s] += 1
        if combo != {}:
            maxi = max(combo, key = lambda key : combo[key])
            
            if combo[maxi] != 1:
                for menu in combo:
                    if combo[menu] == combo[maxi]:
                        answer.append(menu)
    answer.sort()    
    return answer
