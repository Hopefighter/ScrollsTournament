package com.scrollstourney

class Bracket {
    
    Competitor sideOne
    Competitor sideTwo
    int rounds
    int scoreOne = 0
    int scoreTwo = 0
    boolean over = false
    
    static belongsTo = [tourney:Tournament]
    
    static hasMany = [matches:Match,childbrackets:Bracket]

    static constraints = {
        sideOne nullable:true
        sideTwo nullable:true
        childbrackets nullable:true
        matches nullable:true
    }
}
