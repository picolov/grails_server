package com.baswara.tester


import grails.rest.*
import grails.converters.*

class AnswerController extends RestfulController {
    static responseFormats = ['json', 'xml']
    def springSecurityService
    AnswerController() {
        super(Answer)
    }

    def save() {
        def json = request.JSON
        Answer answer = new Answer()
        answer.content = json.content
        answer.number = json.number
        answer.createdDate = new Date()
        answer.createdBy = springSecurityService.authentication.principal.getUsername()
        answer.save(flush: true)
        respond answer
    }

    def lastAnswer() {
        String username = springSecurityService.authentication.principal.getUsername()
        Answer.findByCreatedBy(username)
        def answer = Answer.where{createdBy == username}.list(sort: 'number', order: 'desc', max: 1)
        respond answer
    }
}
