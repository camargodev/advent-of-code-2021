def read_input():
    lines = []
    with open('input.txt') as f:
        lines = f.readlines()
    return list(map(int, lines))


def is_current_index_increasing(numbers, pos):
    return numbers[pos+1] > numbers[pos]

def count_increasing(numbers):
    increasing = 0
    for i in range(0, len(numbers)-1):
        if is_current_index_increasing(numbers, i):
            increasing += 1
    return increasing

numbers = read_input()
increasing = count_increasing(numbers)
print(increasing)