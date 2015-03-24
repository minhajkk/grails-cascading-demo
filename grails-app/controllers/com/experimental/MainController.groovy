package com.experimental

class MainController {

    def index() {
        // creating a few instances of the owned domain class
        def owneda = new Owned(name: 'Owned A')
        def ownedb = new Owned(name: 'Owned B')
        def ownedc = new Owned(name: 'Owned C')

        // now we make these instances belong to an instance of OwnerA
        // first we create an instance of OwnerA
        def ownerA = new OwnerA(name: 'Owner A')

        // then we give it ownership of all the instances of Owned that we created
        ownerA.addToOwned(owneda)
        ownerA.addToOwned(ownedb)
        ownerA.addToOwned(ownedc)

        // now we save the owner instance
        ownerA.save(flush: true, failOnError: true)

        // now we see how many instances of both Owners and Owned are in our db
        println "The number of Owner As in existence are: " + OwnerA.count()
        println "The number of Owned in existence are: " + Owned.count()

        // Now we delete the owner instance
        ownerA.delete(flush: true)

        // now we see how many instances of both Owners and Owned are in our db after the deletion
        println "After deletion of the OwnerA instance..."
        println "The number of Owner As in existence are: " + OwnerA.count()
        println "The number of Owned in existence are: " + Owned.count()

        return render (text: "Done Rendering!")
    }
}
