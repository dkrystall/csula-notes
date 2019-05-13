const
    yargs = require('yargs'),
    app = require('./app')

const flags = yargs
    .usage('$0: Usage <cmd> [options]')
    .command({
        command: 'draw',
        desc: 'draws cards from a deck',
        builder: (yargs) => {
            return yargs.options('s', {
                alias: 'shuffle',
                describe: 'shuffles the deck before drawing',
                boolean: true
            })
            .options('c', {
                alias: 'count',
                describe: 'number of cards to draw',
            })
        },
        handler: (argv) => {
            app.draw(argv.shuffle, argv.count)
        }
    })
    .help('help')
    .argv
