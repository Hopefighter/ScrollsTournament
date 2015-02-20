package com.scrollstourney

class Tournament {
    
    String tourneyname
    String description
    String rules
    Date dateHeld
    Date signupperiod //date of latest signup
    Date checkin //time the checkin starts
    Date checkinends //time the checkin ends
    Date dateCreated
    User host
    int maxCompetitors
    int minCompetitors
    int competitionType
    boolean invitation = false
    
    static hasMany = [competitors:Competitor,logs:Log,brackets:Bracket,moderators:User]

    static constraints = {
        description type: 'text', nullable: true
        rules nullable: true
        competitors nullable:true
        logs nullable:true
        brackets nullable:true
        moderators nullable:true
    }
}
