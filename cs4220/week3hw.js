//David Krystall

const group1 = {
    name: 'Justice League',
    leader: 'Wonder Woman',
    members: ['Batman', 'Superman']
}

const group2 = {
    name: 'Avengers',
    members: ['Hulk', 'Thor', 'Captain America']
}

const print = ({ name, leader, members }) => {
    if(leader == null){
        leader = ""
    }
    lastMember = members.pop()
    console.log('Team = '+name+ '\n' + 
    'Leader = '+leader+  '\n' + 
    'Members = '+members+ ' and ' +lastMember)
}
print(group1)
print(group2)

class Cart {
    constructor(items = [], total = 0){
        this.items = items
        this.total = total
    }
    addItem({item, quantity = 1, price = 0 }) {
        this.items.push({item, quantity, price})
        return this
    }
    addPrice(name, price){
        const itemName = name.toLowerCase()
        this.items.forEach( item => {
            if(item.item == itemName){
                item.price = price
            }
        })
        return this
    }
    removeItem(name){
        this.items.forEach( item => {
            if(item.item == name.toLowerCase()){
                item.quantity -= 1
            }
        })
        return this
    }
    addTotal(){
        this.items.forEach( item => {
            const itemTotal = (item.price)*(item.quantity)
            this.total += itemTotal
        })
        return this
    }
    get print(){
        this.items.forEach( items =>    {
            console.log("Item: "+ items.item+ " | Quantity: "+items.quantity+" | Price: " +((items.price > 0) ? `${items.price}` : 'n/a'))
        })
        console.log(this.total.toFixed(2))
    }
}

const cart = new Cart()
cart
                .addItem({ item: 'bread', quantity: '1' })
                .addItem({ item: 'soup', quantity: '3' })
                .addItem({ item: 'chips', quantity: '4' })
                .addItem({ item: 'soda', quantity: '1' })
                .addPrice('chiPs', 5.99)
                .removeItem('Chips')
                .addPrice('soda', 1.04)
                .addTotal()
                .print