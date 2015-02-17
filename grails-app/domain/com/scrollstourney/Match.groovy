package com.scrollstourney

class Match {

    Competitor_User usideOne
    Competitor_User usideTwo
    boolean played = false
    int winnerSideOne = 0
    int winnerSideTwo = 0
    int winner
    
    static belongsTo = [bracket:Bracket]
    
    static constraints = {
        usideOne nullable:true
        usideTwo nullable:true
        winner nullable:true
    }
}
