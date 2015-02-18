package com.scrollstourney

class RegisterController {

    def springSecurityService
    
    def index = {
        
    }
    
    def register(RegistrationCommand rc) {
        if (rc.hasErrors()) {
            redirect(action: 'index')
        } else {
            def user = new User(rc.properties)
            user.profile = new Profile(rc.properties)
            if(user.validate() && user.save()) {
                flash.massage = "Sucessfully Created account. Welcome ${rc.igname ?: rc.username}"
                redirect(uri: "/")
            } else {
                redirect(action: 'index')
            }
        }
    }
}

class RegistrationCommand {
    String username
    String password
    String passwordRepeat
    String igname
    String email
    String country
    Date birthday
    boolean sendNews
    int gender
    
    static constraints = {
        importFrom Profile
        importFrom User
        password(
            validator: { passwd, rc ->
                return passwd != rc.username
            })
        passwordRepeat(blank: false,
            validator: { passwd2, rc ->
                return passwd2 == rc.password
            })
    }
    
}
