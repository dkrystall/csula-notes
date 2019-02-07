/**
 * David Krystall
 * CS4220
 * Homework 1, Week 2
 */
const log = console.log
const replaceLetters = (str, arr) => {
    let word = str
    let returnString = ""
    for(letter in word){
        let erase = false
        let thisLetter = word.charAt(letter)
        arr.forEach( letter => {
            if (thisLetter == letter){
                erase = true
            } 
        });
        if (erase) {
            returnString+="-"
        } else {
            returnString+=thisLetter
        }
        erase = false
    }
    return returnString
}
log("Replace letters on Dumbo given [D,u,o]")
log(replaceLetters("Dumbo", ['D','u','o']))

const sumArray = (arr) => {
    let sum = 0
    arr.forEach( number => {
        if(parseInt(number)>0){
            log(number)
            sum += parseInt(number)
        }
    })
    return sum
}
log(sumArray([0,4,'5', 3, 'a', 'L', null, 12]))

const countingWords = (arr) => {
    let dictionary = {}
    arr.forEach((word) => {
        let thisWord = {
            word: '',
            repetitions: 0
        }
        if (word in dictionary){
            dictionary[word] += 1
        } else {
            thisWord.word = word 
            thisWord.repetitions = 1
            dictionary[word] = thisWord.repetitions
        }
    })
    log(dictionary)
}
countingWords(['hi', 'hi', 'hello', 'world', 'hello', 'hi' , 'greetings'])

const animalArray = [
    [
        { property: 'name', assign: 'Garfield'},   
        { property: 'owner', assign: 'Jon Arbuckle'},
        { property: 'type', assign: 'cat' }
    ],
    [
        { property: 'name',assign: 'Snoopy' },   
        { property: 'owner',assign: 'Charlie Brown' },
        { property: 'type',assign: 'dog' }
    ]
]

const createAnimals = (arr) => {
    let animals = {}
    arr.forEach( (animal, index) => {
        let thisAnimal = {}
        for(aspect in animal){
            const prop = animal[aspect].property
            const assign = animal[aspect].assign
            thisAnimal[prop] = assign
        }
        animals[index] = thisAnimal
    })
    log(animals)
}

createAnimals(animalArray)
