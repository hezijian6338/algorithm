class IntervalSchedule {
  constructor() {

  }

  IntervalSchedule(intvs) {
    if (intvs.length == 0) {
      return 0
    }

    intvs.sort((a, b) => {
      return a[1] - b[1]
    })

    console.log(intvs)

    let x_end = intvs[0][1]
    let count = 1

    for (let interval of intvs) {
      let start = interval[0]
      if (start >= x_end) {
        x_end = interval[1]
        count++
      }
    }

    return count
  }
}

intvs = [[1, 3], [3, 6], [2, 4]]
let is = new IntervalSchedule()
let res = is.IntervalSchedule(intvs)
console.log(res)