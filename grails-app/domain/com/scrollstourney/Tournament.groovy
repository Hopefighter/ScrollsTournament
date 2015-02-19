package com.scrollstourney

class Tournament {
    
    String tourneyname
    String description
    String rules
    Date dateHeld
    Date signupperiod
    Date checkin
    Date dateCreated
    User host
    int maxCompetitors
    int minCompetitors
    int competitionType
    
    static hasMany = [competitors:Competitor,logs:Log,brackets:Bracket,moderators:User]

    static constraints = {
        description type: 'text', nullable: true
        competitors nullable:true
        logs nullable:true
        brackets nullable:true
        moderators nullable:true
    }
}
