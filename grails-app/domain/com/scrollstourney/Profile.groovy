package com.scrollstourney

class Profile {
    
    String igname
    String email
    String country
    String info
    Date birthday
    Date dateCreated
    boolean sendNews = false
    boolean mailConfirmed = false
    int gender
    
    
    static belongsTo = [user:User]

    static constraints = {
        igname nullable:true
        email email: true, nullable:false, blank:false
        country nullable:true
        info nullable: true
        birthday nullable:true
    }
    
    String toString() {
        return (igname?:user.username)
    }
}
