
// Arrays and Methods on Arrays
const planets = [ 'venus', 'earth', 'mars']
//console.log(planets)
//console.log(planets.length)

// // when using methods push() or pop() the keyword const can still be used
// // push
 planets.push('jupitar', 'saturn', 'uranus', 'neptune', 'pluto')
//  console.log(planets)

// // pop & accessing
// const accesslast = planets[planets.length - 1]
// console.log(accesslast)
// console.log(planets)
// const last = planets.pop()  // this mutates the array
// console.log(last)
// console.log(planets)

// // unshift
 //planets.unshift('mercury') // this mutates the array
// console.log(planets)

// // shift & accessing
//const accessFirst = planets[0]
//console.log(accessFirst)

//const first = planets.shift() // this mutates the array
// console.log(first)
// console.log(planets)


// // Looping Arrays
// for (let i = 0; i < planets.length; i++) {
//     const planet = planets[i]
//     console.log(planet + ' is a planet')
// }

// planets.forEach((planet, index) => {
//     console.log(planet, index)
// })

// // Looping Strings
const word = 'hello'
// for (let i = 0; i < word.length; i++) {
//     const letter = word[i]
//     console.log(letter)
// }



// // Objects
const transformer = {
    name: 'Optimus Prime',
    team: 'Autobots',
    colors: ['red', 'blue', 'silver']
}

//console.log(transformer)

// // additional keys can be applied using either notation
transformer.homeWorld = 'Cybertron'
transformer['vehicle'] = 'truck'
//console.log(transformer)


const type = 'vehicle'
transformer[type] = 'bigrig'

// // Methods on Objects
 const keys = Object.keys(transformer) // returns an array of keys on the objects
 //console.log(keys)

 const values = Object.values(transformer) // returns an array of values on the objects
 //console.log(values)

// // Looping Objects
// for (const prop in transformer) {
//     console.log(prop)              // property name
//     console.log(transformer[prop]) // value
//  }


// // Building Complex Objects
const company = {
    name: 'EA',
    type: 'Video Games',
    subsidiaries: ['BioWare', 'DICE', 'PopCap']
}
company.subsidiaries.push('Respawn')
//console.log(company)

const games = [{
    name: 'Battlefield V',
    release: 2018
},
{
    name: 'FIFA 19',
    release: 2018
},
{
    name: 'Anthem',
    release: 2019
}]

Object.assign(company, {games : games})
company.games = games
 console.log(company)

company.games.push({ name: 'Sea of Solitude', release: 'TBD'})
// console.log(company)


// // Functions
// function addTwo(n) {
//     return n + 2
// }
// console.log(addTwo(2))


// // Assigned as a variable
const say = console.log
//say('Anything I want.')

const addNumbers = (n, m) => {
    return n + m
}
//console.log(addNumbers(2, 3))

// Passed as arguments to another function
function addFunction(fn) {
    return fn(1, 3)
}
//console.log(addFunction(addNumbers))


// returned as value from a function
function getFunction(n) {
    if (n % 2 === 0)
        return function add() {
            return n + 2
        }
    else
        return function subtract() {
            return n - 2
        }
}

const fn = getFunction(8)
console.log(fn())