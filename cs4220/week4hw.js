
async function iterateNumbers(numbers){
    let total = 0
    for (let i = 0; i< numbers.length; i+=2) {
        const num1 = (numbers [i-1] > 0 ? numbers [i-1] : 0)
        const num2 = numbers[i]
        try {
            total += await adder(num1, num2)
        } catch (err){
            console.log(err)
        }
    }
    console.log("Total:")
    console.log(total)
}
const adder = (previous,next) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            const error = !next ? `no next number` : null
            if(error)
                reject(error)
            else
                resolve(previous+next)
        }, 10)
    })
}

iterateNumbers([1, 2, 3, 5, 8, 13, 21])
// Total:
// 53

const todos = [{
    name: 'get coffee',
    priority: 9
},
{
    name: 'clean room',
    priority: null
},
{
    name: 'go to CS4220',
    priority: 4
},
{
    name: 'do homework before due date',
    priority: 8
}]

const checkPriority = ({ name , priority }, callback) => {
    setTimeout(() => {
        const error = (priority == null) ? `Missing Priority [ '${name}' ]` : {name, priority}
        callback(error, {name, priority})
    }, 90)
}

/*const makeList = (todos) => {
    let returnTodos = {}
    let errors = {}
    try{
        todos.forEach((todo) => {
            checkPriority(todo, (error, result) => {
                if(error){ 
                    errors += error
                }
                else{
                    returnTodos += todo
                }
            })
        }
        )}
    catch(err) {
    }
    
    console.log(returnTodos)
    console.log(errors)
}*/



async function makePriorityList(todos) {
    let returnTodos = {}
    let errors = {}
   
        todos.forEach((todo) => {
            const thistodo = checkPriority(todo, (error, result) => {
                console.log(error)
                if(error){ 
                   //console.log(result )
                    return error
                }
                else{
                    return result
                }
            })
        })
    console.log(returnTodos)
    console.log(errors)
}

makePriorityList(todos)
