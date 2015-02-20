package com.scrollstourney

import grails.transaction.Transactional

@Transactional
class TournamentService {

    def finalizeTourney(Tournament tourney, String mods) {
        //add Moderators
        switch(tourney.competitionType) {
            case 1: //Single Elimination, Solo
                singleElimSolo(tourney)
                break
        }
    }
    
    def singleElimSolo(Tournament tourney) {
        int max = tourney.maxCompetitors
        for(int i=1; i*2<=max; i++) {
            for(int j=1;j*(2**i)<=max;j++) {
                //ToDo: Black Voodoo Magicz
            }
        }
    }
}
