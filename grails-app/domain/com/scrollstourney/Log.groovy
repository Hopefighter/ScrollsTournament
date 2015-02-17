package com.scrollstourney

class Log {
    
    Date dateCreated
    String message
    
    static belongsTo = [tourney:Tournament]

    static constraints = {
    }
}
