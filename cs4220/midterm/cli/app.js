const
    cards = require('../custom/index.js'),
    inquirer = require('inquirer')


async function discardPrompt(result) {
    const displayCards = result.map(card => {
        return { name: `${card.value} of ${card.suit}`, value: card.code }
    })

    return inquirer.prompt([{
        type: 'checkbox',
        message: 'select cards to throw away',
        name: 'cards',
        choices: displayCards,
        validate: cards => {
            if (cards.length > 4)
                return 'You may only discard up to 4 cards'
            else
                return true
        }
    }])
}

const findAndRemove = (current, throwaway) => {
    return current.filter(card => !throwaway.includes(card.code))
}

const print = (cards, remaining) => {
    console.log(`\n --- CARDS ---`)
    cards.forEach(card => {
        console.log(`${card.value} of ${card.suit}`)
    })
    console.log(`\n --- REMAINING CARDS ---`)
    console.log(remaining)
}

async function play() {
    const shuffle = true
    const n = 5

    const deck = await cards.deck(shuffle);
    const original = await cards.draw(deck.deck_id, n)

    const throwaway = await discardPrompt(original.cards)

    const filterCards = findAndRemove(original.cards, throwaway.cards)
    const newCards = await cards.draw(deck.deck_id, throwaway.cards.length)


    const finalHand = filterCards.concat(newCards.cards)
    print(finalHand, newCards.remaining)
}

async function draw(shuffle = true, n = 5) {
    const deck = await cards.deck(shuffle);
    const original = await cards.draw(deck.deck_id, n)

    print(original.cards, original.remaining)
}

module.exports = {
    draw,
    play
}