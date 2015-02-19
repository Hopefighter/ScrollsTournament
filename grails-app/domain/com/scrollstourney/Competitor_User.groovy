package com.scrollstourney

class Competitor_User {
    
    boolean confirmed = false
    int playernumber //leader of group is 0
    
    static belongsTo = [competitor:Competitor,user:User]

    static constraints = {
        competitor(unique: ['competitor','user'])
    }
}
