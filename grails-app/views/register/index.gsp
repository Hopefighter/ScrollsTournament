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
        <title>Register</title>
    </head>
    <body>
        <h1>Lorem Ipsum</h1>
        <div>
            <g:form>
                <label for="username">Username*</label>
                <g:textField name="username"/></br>
                <label for="password">Password*</label>
                <g:passwordField name="password"/></br>
                <label for="passwordRepeat">Repeat password*</label>
                <g:passwordField name="passwordRepeat"/></br>
                <label for="email">Email*</label>
                <g:textField name="email"/></br>
                <label for="igname">In-game name</label>
                <g:textField name="igname"/></br>
                <label for="country">Country</label>
                <g:countrySelect name="country" noSelection="['':'Choose your country...']"/></br>
                <label for="birthday">Birthday</label>
                <g:datePicker 
                    name="birthday" 
                    precision="day" 
                    noSelection="['':'-Choose-']"
                    relativeYears="[-99..0]"/></br>
                <label for="gender">Gender</label>
                <g:radioGroup 
                    name="gender" 
                    labels="['No Selection','Male','Female']" 
                    values="[0,1,2]" 
                    value="0" >
                    <p>${it.label} ${it.radio}</p>
                </g:radioGroup></br>
                <label for="sendNews">Send me News:</label>
                <g:checkBox name="sendNews" value="${true}" checked="${true}"/></br>
                <g:actionSubmit value="Register" action="register"/>
            </g:form>
        </div>
    </body>
</html>
