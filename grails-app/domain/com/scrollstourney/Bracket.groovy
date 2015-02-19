package com.scrollstourney

class Bracket {
    
    Competitor sideOne
    Competitor sideTwo
    int rounds
    int tourneyround //the round of the tourney the bracket is placed
    int roundpos // the inter-round position of the bracket
    boolean over = false
    
    static belongsTo = [tourney:Tournament]
    
    static hasMany = [matches:Match,childbracketswin:Bracket,childbracketsloss:Bracket]

    static constraints = {
        sideOne nullable:true
        sideTwo nullable:true
        childbracketswin nullable:true
        childbracketsloss nullable:true
        matches nullable:true
    }
    
    List<Competitor> getCompetitors() {
        def competitors = new ArrayList<Competitor>()
        if(!sideOne || !sideTwo) {
        for(each in childbracketswin) {
            if(it.over) {
                competitors.add(it.roundpos, it.getResult(true))
            }
        }
        for(each in childbracketsloss) {
            if(it.over) {
                competitors.add(it.roundpos, it.getResult(false))
            }
        }
        def array = competitors.toArray()
        sideOne = array[0]
        sideTwo = array[-1]
        } else {
            competitors.add(1, sideOne)
            competitors.add(2, sideTwo)
        }
        return competitors
    }
    
    Competitor getResult(boolean wl) { //wl:true = winner, wl:false = loser
        if(over) {
            def competitors = this.getCompetitors()
            def score = 0
            for(each in matches) {
                if(it.winner) {
                    switch(it.winner) {
                        case 1:
                            score++
                            break
                        case 2:
                            score--
                            break
                    }
                }
            }
            if(wl) {
                if(score > 0) {
                    return sideOne
                } else {
                    return sideTwo
                }
            } else {
                if(score < 0) {
                    return sideOne
                } else {
                    return sideTwo
                }
            }
        } else {
            return null
        }
    }
}
