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
        def result = [redirect: 'getready']
        String username = springSecurityService.authentication.principal.getUsername()
        Answer.findByCreatedBy(username)
        List<Answer> answerList = Answer.where{createdBy == username}.list(sort: 'number', order: 'desc', max: 1)
        if (answerList.size() > 0) {
            switch (answerList.get(0).number) {
                case 1: result.redirect = 'ws'; break;
                case 2: result.redirect = 'ed'; break;
                case 3: result.redirect = 'rf'; break;
                case 4: result.redirect = 'tg'; break;
                case 5: result.redirect = 'yh'; break;
                case 6: result.redirect = 'uj'; break;
                case 7: result.redirect = 'ik'; break;
                case 8: result.redirect = 'ol'; break;
                case 9: result.redirect = 'az'; break;
                case 10: result.redirect = 'sx'; break;
                case 11: result.redirect = 'dc'; break;
                case 12: result.redirect = 'fv'; break;
                case 13: result.redirect = 'gb'; break;
                case 14: result.redirect = 'hn'; break;
                case 15: result.redirect = 'finish'; break;
                case 16: result.redirect = 'finish'; break;
            }
        }
        respond result
    }
}
