import com.scrollstourney.*
import static java.util.Calendar.*

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                createSampleData()
            }
        }
    }
    
    private createSampleData() {
        def now = new Date()
        
        println("creating Users...")
        def hope = new User(
            username: "Hopefighter",
            password: "test",
            profile: new Profile(
                igname: "Hopefighter",
                email: "hopefighterjojo@gmail.com",
                country: "DE",
                info: "„Lorem ipsum dolor sit amet, consectetur, adipisci velit, ...",
                birthday: new Date(1997,1,9),
                sendNews: true,
                mailConfirmed: true)).save(failOnError: true)
        def adminRole = new Role(authority: "ROLE_ADMIN").save(failOnError: true)
        UserRole.create(hope,adminRole)
        def agne = new User(
            username: "agne",
            password: "test1",
            profile: new Profile(
                igname: "Orangee",
                email: "orangee@scrolldier.com",
                country: "NO",
                info: "„Admin on Scrolldier",
                birthday: new Date(1993,6,14),
                sendNews: true,
                mailConfirmed: true)).save(failOnError: true)
        def zylus = new User(
            username: "zylus",
            password: "test2",
            profile: new Profile(
                igname: "Zylus",
                email: "zy@lus.com",
                country: "DE",
                info: "„Scrolls Moderator",
                birthday: null,
                sendNews: true,
                mailConfirmed: true)).save(failOnError: true)
        def gareth = new User(
            username: "gareth",
            password: "test3",
            profile: new Profile(
                igname: "SeeMeScrollin",
                email: "gareth@mojang.com",
                country: "NO",
                info: "„Scrolls Community Manager",
                birthday: new Date(1993,6,14),
                sendNews: true,
                mailConfirmed: true)).save(failOnError: true)
        
        println("creating Tournament...")
        def testtourney = new Tournament(
            tourneyname: "Test Tournament",
            description: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata",
            rules: "Do what you want cause a Pirate is free! You are a pirate",
            dateHeld: now+5,
            signupperiod: now+3,
            checkin: now+5,
            host: hope,
            maxCompetitors: 8,
            minCompetitors: 4,
            competitionType: 1,
            banner: null).save(failOnError: true)
        
        println("creating Competitors...")
        def hopecomp = new Competitor(
            name: "Hopefighter",
            tourney:testtourney).save(failOnError: true)
        def agnecomp = new Competitor(
            name: "Orangee",
            tourney:testtourney).save(failOnError: true)
        def zyluscomp = new Competitor(
            name: "Zylus",
            tourney:testtourney).save(failOnError: true)
        def garethcomp = new Competitor(
            name: "SeeMeScrollin",
            tourney:testtourney).save(failOnError: true)
        
        println("adding Users to Competitors...")
        hopecomp.addToUsers(user: hope, playernumber: 0).save()
        agnecomp.addToUsers(user: agne, playernumber: 0).save()
        zyluscomp.addToUsers(user: zylus, playernumber: 0).save()
        garethcomp.addToUsers(user: gareth, playernumber: 0).save()
        
        println("creating brackets...")
        def bracketa = new Bracket(
            sideOne: hopecomp,
            sideTwo: agnecomp,
            rounds: 3,
            tourney: testtourney).save(failOnError: true)
        def bracketb = new Bracket(
            sideOne: zyluscomp,
            sideTwo: garethcomp,
            rounds: 3,
            tourney: testtourney).save(failOnError: true)
        def bracketc = new Bracket(
            rounds: 5,
            tourney: testtourney).save(failOnError: true)
        
        bracketc.addToChildbrackets(bracketa)
        bracketc.addToChildbrackets(bracketb)
        bracketc.save()
        
        println("adding Matches...")
        bracketa.addToMatches(
            usideOne: hopecomp.getMember(0), 
            usideTwo: agnecomp.getMember(0)).save()
        bracketb.addToMatches(
            usideOne: zyluscomp.getMember(0), 
            usideTwo: garethcomp.getMember(0)).save()
        
        println("finishing up Tournament...")
        testtourney.addToModerators(agne)
        testtourney.addToLogs(message: "Tournament Created")
        testtourney.addToCompetitors(hopecomp)
        testtourney.addToCompetitors(agnecomp)
        testtourney.addToCompetitors(zyluscomp)
        testtourney.addToCompetitors(garethcomp)
        testtourney.addToBrackets(bracketa)
        testtourney.addToBrackets(bracketb)
        testtourney.addToBrackets(bracketc)
        testtourney.save()
        
        println("Done setting up!")
    }
}
