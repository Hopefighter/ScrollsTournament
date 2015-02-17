package com.scrollstourney

class Tournament {
    
    String tourneyname
    String description
    String rules
    Date dateHeld
    Date signupperiod
    Date checkin
    User host
    int maxCompetitors
    int minCompetitors
    int competitionType
    byte[] banner
    
    
    
    static hasMany = [competitors:Competitor,logs:Log,brackets:Bracket,moderators:User]

    static constraints = {
        competitors nullable:true
        logs nullable:true
        brackets nullable:true
        banner nullable:true
        moderators nullable:true
    }
}
