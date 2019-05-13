const
    superagent = require('superagent'),
    inquirer = require('inquirer')

async function draw(shuffle = false, count = 1) {
    const base = 'https://deckofcardsapi.com/api/deck'

    const deckResponse = await superagent.get(`${base}/${shuffle ? 'new/shuffle' : 'new'}`)
    const deckId = deckResponse.body.deck_id

    const drawResponse = await superagent.get(`${base}/${deckId}/draw/?count=${count}`)
    const result = drawResponse.body

    console.log('-- CARDS --')
    console.log(`YOU HAVE DRAWN ${result.cards.length} CARDS`)

    const drawAnother = await anotherCardPrompt()
    console.log(drawAnother)

    if (drawAnother.card) {
        // draw again from the SAME deck
        // print(???)
    } else {
        // print(???)
    }

    /* RUN the app using
        node cli.js draw --shuffle true --count 3

        shuffle: can be true or false
        count: can be from 1 to 51
    */

    /* IF the user picks YES - Then Draw Another Card
        (1) Display all 3 Cards as
            5 of SPADES
            JACK of HEARTS
            3 of CLUBS
        (2) Display the total of all 3 Cards (Assume King, Queen, Jack with value of 10 and Ace with value of 11)
            TOTAL CARD VALUE: 18
        (3) Display the remaining cards in the deck using the value from the API (no calculations needed)
            REMAINING CARDS: 49
    */

    /* IF the user picks NO - Then Do Nothing
        (1) Display all 2 Cards as
            5 of SPADES
            JACK of HEARTS
        (2) Display the total of all 3 Cards (Assume King, Queen, Jack with value of 10 and Ace with value of 11)
            TOTAL CARD VALUE: 15
        (3) Display the remaining cards in the deck using the value from the API (no calculations needed)
            REMAINING CARDS: 50
    */


    /*  In both case you MUST write a helper function called print(???)
        - Pass the print function the information needed to print the information required
        - Use ONLY 1 loop in the code you add
        - Use the responses from the API for remaining cards (do not hard code 52 or do any type math)
        - Do no hard code (only exception are the words and values for ACE (11), KING, QUEEN, JACK (10))
    */


}

async function anotherCardPrompt() {
    return inquirer.prompt([{
        type: 'confirm',
        name: 'card',
        message: 'Would you like to draw another card?'
    }])
}

module.exports = { draw }
