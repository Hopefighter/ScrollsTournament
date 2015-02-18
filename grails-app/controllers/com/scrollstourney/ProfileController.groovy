package com.scrollstourney

class ProfileController {
    static scaffold = true
    
    def springSecurityService

    def index() { }
    
    def profile = {
        def profile = params.id ? Profile.findById(params.id) : springSecurityService.currentUser.profile
        if(!profile) {
            response.sendError(404)
        } else {
            [ profile : profile ]
        }
    }
}
