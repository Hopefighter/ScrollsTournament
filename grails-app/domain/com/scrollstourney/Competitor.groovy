package com.scrollstourney

class Competitor {
    
    String name
    boolean checkedin = false
    
    static belongsTo = [tourney:Tournament]
    
    static hasMany = [users:Competitor_User]

    static constraints = {
        users nullable: true
    }
    
    Competitor_User getMember(int i) {
        for(player in users) {
            if(player.playernumber == i) {
                return player
            }
        }
    }
    
    String toString() {
        return name
    }
}
