package com.scrollstourney

class TournamentController {

    def springSecurityService
    
    static scaffold = true
    
    def index = {
        def tourneys = Tournament.getAll() //ToDo: Limit this to a certain group of Tournaments
        [ tourneys : tourneys ]
    }
    
    def info = {
        def tourney = Tournament.findById(params.id)
        if(!tourney) {
            response.sendError(404)
        } else {
            [ tourney : tourney ]
        }
    }
}
