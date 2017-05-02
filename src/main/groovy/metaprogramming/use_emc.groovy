package metaprogramming

import java.util.logging.*

// Intercept (using methodMissing)
Logger.metaClass.methodMissing = { String name, args ->
    println "inside methodMissing with $name"
    int val = Level.WARNING.intValue() +
        (Level.SEVERE.intValue() - Level.WARNING.intValue()) * Math.random()
    def level = new CustomLevel(name.toUpperCase(),val)
    def impl = { Object... varArgs ->
        delegate.log(level,varArgs[0])
    }
    // Cache the implementation on the metaClass
    Logger.metaClass."$name" = impl

    // Invoke the new implementation
    impl(args)
}


Logger log = Logger.getLogger(this.class.name)
log.wtf 'no effin way'
log.whoa 'dude, seriously'
log.rofl "you're kidding, right?"
log.rofl 'rolling on the floor laughing'
log.whatever 'heavy sigh'
log.sleeping('goodnight')