package com.scrollstourney

class Competitor_User {
    
    boolean confirmed = false
    int playernumber
    
    static belongsTo = [competitor:Competitor,user:User]

    static constraints = {
        competitor(unique: ['competitor','user'])
    }
}
