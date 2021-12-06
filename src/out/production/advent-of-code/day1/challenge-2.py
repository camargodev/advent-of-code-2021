def read_input():
    lines = []
    with open('input.txt') as f:
        lines = f.readlines()
    return list(map(int, lines))

def is_current_index_increasing(numbers, last_sum, pos):
    return numbers[pos+1] > numbers[pos]


def calculate_starting_group_sum(numbers):
    return numbers[0] + numbers[1] + numbers[2]

def count_increasing(numbers):
    increasing = 0
    group_sum = calculate_starting_group_sum(numbers)

    for i in range(0, len(numbers)-3):
        last_sum = group_sum
        group_sum = last_sum - numbers[i] + numbers[i+3]
        if last_sum < group_sum:
            increasing += 1
    return increasing

numbers = read_input()
increasing = count_increasing(numbers)
print(increasing)