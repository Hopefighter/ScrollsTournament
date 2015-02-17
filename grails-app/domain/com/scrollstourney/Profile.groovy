package com.scrollstourney

class Profile {
    
    String igname
    String email
    String country
    String info
    Date birthday
    Date dateCreated
    boolean sendNews
    
    
    static belongsTo = [user:User]

    static constraints = {
        igname nullable:true
        email blank:false
        country nullable:true
        info nullable: true
        birthday nullable:true
    }
}
