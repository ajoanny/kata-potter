const potter = (books: Array<number>) => {


    const sets = groupBooksBySet(books)
    optimizedSet(sets)
    let price = 0
    sets.forEach((books) => {
        price += setPrice(new Set(books))
    })
    return price
}

const groupBooksBySet = (books: Array<number>): number[][] => {
    const groups: number[][] = []
    books.forEach((book) => {
        const currentGroup = groups.find((existingGroup) => !existingGroup.includes(book)) || []
        if(currentGroup.length === 0){
            groups.push(currentGroup)
        }
        currentGroup.push(book)
    })
    return groups
}

const optimizedSet = (booksSet: number[][]) => {
    const groupOf3 = booksSet.filter((group) => group.length === 3)

    groupOf3.forEach((of3) => {
        const of5 = booksSet.find((group) => group.length === 5) || []
        const index = of5.findIndex((book) => !of3.includes(book))
        if(!index || of5.length === 0) return
        const book = of5[index]
        of5.splice(index, 1);
        of3.push(book)
    })
}

const PROMOTIONS = [
    1,
    0.95,
    0.90,
    0.80,
    0.75,
]

const setPrice = (books: Set<number>) => {
    return books.size * 8 * PROMOTIONS[books.size - 1]
}

export default potter;