import re

def solution(new_id):
    new_id = new_id.lower() #1

    unusable = re.findall(r'[^-^a-z^0-9^_^.]', new_id) #2
    for u in unusable: new_id = new_id.replace(u, '')
    new_id = new_id.replace('^','')

    while new_id.count('..') > 0: new_id = new_id.replace('..', '.') #3

    if new_id.startswith('.'): #4
        while new_id.startswith('.'): new_id = new_id[1:]
    if new_id.endswith('.'): 
        while new_id.endswith('.'): new_id = new_id[:-1] 

    if new_id == "": new_id = "a" #5

    if len(new_id) >= 16: new_id = new_id[:15] #6
    if new_id.endswith('.'): 
        while new_id.endswith('.'): new_id = new_id[:-1] 

    if len(new_id) <= 2: #7
        c = new_id[-1]
        while len(new_id) <3: new_id += c

    return new_id