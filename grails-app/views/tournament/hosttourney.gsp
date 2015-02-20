<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample title</title>
    </head>
    <body>
        <h1>Create a Tournament</h1>
        Redo this page properly
        <g:form>
            <label for="tourneyname">Tournament Name</label>
            <g:textField name="tourneyname"/></br>
            <label for="description">Description</label>
            <g:textArea name="description"/></br>
            <label for="rules">Rules</label>
            <g:textArea name="rules"/></br>
            <label for="dateHeld">Start of Tournament</label>
            <g:datePicker 
                    name="dateHeld" 
                    precision="minute"
                    relativeYears="[0..1]"/></br>
            <label for="signupperiod">Signup ends</label>
            <g:datePicker 
                    name="signupperiod" 
                    precision="minute"
                    relativeYears="[0..1]"/></br>
            <label for="checkin">Checkin Starts at</label>
            <g:datePicker 
                    name="checkin" 
                    precision="minute"
                    relativeYears="[0..1]"/></br>
            <label for="checkinends">End of Checkin</label>
            <g:datePicker 
                    name="checkinends" 
                    precision="minute"
                    relativeYears="[0..1]"/></br>
            <label for="minCompetitors">Minimum Number of Competitors</label>
            <g:select name="minCompetitors" from="['4','8','16','32','64','128','256']" /></br>
            <label for="maxCompetitors">Maximum Number of Competitors</label>
            <g:select name="maxCompetitors" from="['4','8','16','32','64','128','256']"/></br>
            <label for="competitionType">Type of Competition</label>
            <g:radioGroup name="competitionType" values="['1']" labels="['Single Elimination']" >
                ${it.radio} ${it.label} 
            </g:radioGroup></br>
            <label for="invitational">Invitational</label>
            <g:checkBox name="invitational" value="${true}" /></br>
            <label for="mods">Moderators</label>
            <g:textArea name="mods" value="Currently not working, will be added soon"/></br>
            <g:actionSubmit value="Create Tournament" action="createtourney"/>
        </g:form>
        
    </body>
</html>
