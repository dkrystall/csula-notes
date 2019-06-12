const
    superagent = require('superagent'),
    inquirer = require('inquirer')
    
async function draw(shuffle = false, count = 1) {
    const base = 'https://deckofcardsapi.com/api/deck'

    const deckResponse = await superagent.get(`${base}/${shuffle ? 'new/shuffle' : 'new'}`)
    const deckId = deckResponse.body.deck_id

    const firstDrawResponse = await superagent.get(`${base}/${deckId}/draw/?count=${count}`)
    const result = firstDrawResponse.body
    const drawResponse = await superagent.get(`${base}/${deckId}/draw/?count=1`)
    const result2 = drawResponse.body
    console.log('-- CARDS --')
    console.log(`YOU HAVE DRAWN ${result.cards.length} CARDS`)

    const drawAnother = await anotherCardPrompt()
    console.log(drawAnother)

    if (drawAnother.card) {
        print(result.cards, result2.cards)
    } else {
        print(result.cards)
    }

    async function print(first, second) {
        //console.log(first)
        let value = 0
        let remaining = 0
        for (i = 0; i<first.length; i++){
            console.log(`${first[i].value} of ${first[i].suit}`)
            if(first[i].value > 0 && first[i].value <10){
                value += parseInt(first[i].value)
            } else if(first[i].value == "ACE"){
                value += 11
            } else {
                value += 10
            }
        }
        if (second != null){
            remaining = result2.remaining
            console.log(`${second[0].value} of ${second[0].suit}`)
            if(second[0].value > 0 && second[0].value <10){
                value += parseInt(second[0].value)
            } else if(second[0].value == "ACE"){
                value += 11
            } else {
                value += 10
            }
        } else {
            remaining = result.remaining
        }
        console.log(`TOTAL CARD VALUE: ${value}`)
        console.log(`CARDS REMAINING: ${remaining}`)
    }

}

async function anotherCardPrompt() {
    return inquirer.prompt([{
        type: 'confirm',
        name: 'card',
        message: 'Would you like to draw another card?'
    }])
}

module.exports = { draw }
