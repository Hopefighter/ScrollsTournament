<div>
    <g:link controller="tournament" action="info" id="${tourney.id}">
        <h3>${tourney.tourneyname}</h3>
    </g:link>
    <div>
        Host: 
        <g:link controller="profile" action="profile" id="${tourney.host.profile.id}">
            ${tourney.host.getDisplayString()}
        </g:link>
        | Held: ${tourney.dateHeld.getDateTimeString()} 
        <!-- ToDo: make this date more beautifull, using FancydateTagLib-->
    </div>
</div>