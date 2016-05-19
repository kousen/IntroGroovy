package ast.sortable

List golfers = [
        new Golfer(score: 70, first: 'Tiger', last: 'Woods'),
        new Golfer(score: 68, first: 'Tom', last: 'Watson'),
        new Golfer(score: 68, first: 'Bubba', last: 'Watson'),
        new Golfer(score: 69, first: 'Ty', last: 'Webb')
]

println golfers.sort() // score, then last, then first