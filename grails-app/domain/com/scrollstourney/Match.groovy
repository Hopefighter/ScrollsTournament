package com.scrollstourney

class Match {

    Competitor_User usideOne
    Competitor_User usideTwo
    int winnerSideOne = 0 //winner according to sideOne
    int winnerSideTwo = 0 //winner according to sideTwo
    int winner
    
    static belongsTo = [bracket:Bracket]
    
    static constraints = {
        usideOne nullable:true
        usideTwo nullable:true
        winner nullable:true
    }
}
