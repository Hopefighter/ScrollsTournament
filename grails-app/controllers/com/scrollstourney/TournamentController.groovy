package com.scrollstourney

class TournamentController {

    def springSecurityService
    
    def tournamentService
    
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
    
    def hosttourney = {
        
    }
    
    def createtourney(TournamentCreationCommand tcc) {
        if(tcc.hasErrors()) {
            redirect(action: 'hosttourney')
        } else {
            def host
            host = bindData(tcc, springSecurityService.currentUser)
            println(tcc.properties)
            def tourn = new Tournament(tcc.properties)
            if(tourn.validate() && tourn.save()) {
                tournamentService.finalizeTourney(tourn, mods)
            } else {
                redirect(action: 'hosttourney')
            }
        }
    }
}

class TournamentCreationCommand {
    String tourneyname
    String description
    String rules
    Date dateHeld
    Date checkin
    Date checkinends
    Date signupperiod
    int maxCompetitors
    int minCompetitors
    int competitonType
    boolean invitational = false
    String mods
    
    static constraints = {
        importFrom Tournament
        mods nullable:true
        checkin(
            validator: { checkin, tcc ->
                return checkin > tcc.signupperiod
        })
        checkinends(
            validator: { checkinend, tcc ->
                return checkinend > tcc.checkin
            })
        dateHeld(
            validator: { dheld, tcc ->
                return dheld > tcc.checkinends
            })
    }
}
