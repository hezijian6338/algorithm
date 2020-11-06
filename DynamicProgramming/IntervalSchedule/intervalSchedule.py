import functools

class IntervalSchedule(object):
    def __init__(self, intvs):
        self.intvs = intvs
    
    def IntervalSchedule(self) -> int:
        if len(self.intvs) == 0:
            return 0
        def s(x, y):
            return x[1] < y[1]
        sorted(self.intvs, key=functools.cmp_to_key(s))

        print(self.intvs)

        count = 1

        x_end = self.intvs[0][1]

        for intv in self.intvs:
            if intv[0] >= x_end:
                count += 1
                x_end = intv[1]

        return count

intvs = [[1, 3], [2, 4], [3, 6]]
IS = IntervalSchedule(intvs)
print(IS.IntervalSchedule())