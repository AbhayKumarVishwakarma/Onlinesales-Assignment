
def compute(n):
    if n < 10:
        out = n ** 2
    elif n < 20:
        out = 1
        for i in range(1, n - 11):  # Changed n-10 to n-11
            out *= i
    else:
        lim = n - 20
        out = lim * lim
        out = out + lim  # Changed the (-) symbol to (+)
        out = out / 2
    print(out)


n = int(input("Enter an integer: "))
compute(n)
