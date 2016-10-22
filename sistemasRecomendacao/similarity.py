rates = {
    'Alice': {
        'item1': 5,
        'item2': 3,
        'item3': 4,
        'item4': 4,
        'item5': '?'
    },
    'User4': {
        'item1': 1,
        'item2': 5,
        'item3': 5,
        'item4': 2,
        'item5': 1
    },
}

rates = {
    'Alice': {
        'item1': 5,
        'item2': 3,
        'item3': 4,
        'item4': 4,
        'item5': '?'
    },
    'User1': {
        'item1': 3,
        'item2': 1,
        'item3': 2,
        'item4': 3,
        'item5': 3
    },
    'User2': {
        'item1': 4,
        'item2': 3,
        'item3': 4,
        'item4': 3,
        'item5': 5
    },  # sim = 0,71
    'User3': {
        'item1': 3,
        'item2': 3,
        'item3': 1,
        'item4': 5,
        'item5': 4
    },  # sim = 0,00
    'User4': {
        'item1': 1,
        'item2': 5,
        'item3': 5,
        'item4': 2,
        'item5': 1
    },
}


def get_medias(rates):
    medias = {}
    for user in rates:
        soma = 0
        count = 0
        for item in rates[user]:
            aux = rates[user][item]
            if aux != "?":
                count += 1
                soma += float(aux)
        medias[user] = soma / count
    return medias


def get_rab(principal):
    sum_rab = {}
    for item in principal:
        if principal[item] != "?":
            sum_rab[item] = round((principal[item] - medias['Alice']), 2)
    return sum_rab


def get_rbb(list_users):
    sum_rbb = {}
    for user in list_users:
        aux = {}
        for item in list_users[user]:
            rbb = list_users[user][item]
            if rbb != "?":
                aux[item] = round((rbb - medias[user]), 2)
        sum_rbb[user] = aux
    return sum_rbb


def get_similarity(rab, rbb):
    similaritys = {}
    for user in rbb:
        numerador = []
        denominador = []
        rab_denominador = []
        rbb_denominador = []
        for item in rbb[user]:
            if item in rab and item in rbb[user]:
                prod_rab = rab[item]
                prod_rbb = rbb[user][item]
                numerador.append(prod_rab * prod_rbb)
                rab_denominador.append(prod_rab**2)
                rbb_denominador.append(prod_rbb**2)
                denominador.append(
                    sum(rab_denominador)**(1/2.0) * sum(rbb_denominador)**(1/2.0)
                )
        sim = round((sum(numerador) / sum(denominador)), 2)
        similaritys[user] = sim
    return similaritys


# print item
# print "principal: ", rate_principal
# print "media ", medias[principal]
# print "neighboor: ", rate_neighboor
# print "media ", medias[user]
# print "rab: " , rab
# print "rbb: " , rbb
# prod = rab * rbb
# print "prod: " , prod
# print "**************"

medias = get_medias(rates)
list_users = rates.copy()
list_users.pop("Alice")
rab = get_rab(rates["Alice"])
rbb = get_rbb(list_users)
sim = get_similarity(rab, rbb)
print sim
