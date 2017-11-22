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
        def result = [redirect: 'info']
        String username = springSecurityService.authentication.principal.getUsername()
        Answer.findByCreatedBy(username)
        List<Answer> answerList = Answer.where{createdBy == username}.list(sort: 'number', order: 'desc', max: 1)
        if (answerList.size() > 0) {
            switch (answerList.get(0).number) {
                case 0: result.redirect = 'qa'; break;
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

    def finishanswer() {
        def result = [answer:[]]
        List<Answer> userAnswer = Answer.findAllByNumber(15, [sort: "createdBy", order: "asc"])
        for (Answer answer:userAnswer) {
            Answer info = Answer.findByCreatedByAndNumber(answer.createdBy, 0)
            String[] userInfo = info.content.split("\\|")
            Answer no11 = Answer.findByCreatedByAndNumber(answer.createdBy, 11)
            Answer no12 = Answer.findByCreatedByAndNumber(answer.createdBy, 12)
            Answer no13 = Answer.findByCreatedByAndNumber(answer.createdBy, 13)
            Answer no14 = Answer.findByCreatedByAndNumber(answer.createdBy, 14)
            Answer no15 = Answer.findByCreatedByAndNumber(answer.createdBy, 15)
            Answer no6 = Answer.findByCreatedByAndNumber(answer.createdBy, 6)
            Answer no7 = Answer.findByCreatedByAndNumber(answer.createdBy, 7)
            Answer no8 = Answer.findByCreatedByAndNumber(answer.createdBy, 8)
            Answer no9 = Answer.findByCreatedByAndNumber(answer.createdBy, 9)
            Answer no10 = Answer.findByCreatedByAndNumber(answer.createdBy, 10)
            String logic1,logic2,logic3,logic4,logic5
            int logic = 0
            if (no6.content.equals("4")) {
                logic1 = "pola angka benar"
                logic++
            } else logic1 = "pola angka salah"
            if (no7.content.equals("2")) {
                logic2 = "deret angka benar"
                logic++
            } else logic2 = "deret angka salah"
            if (no8.content.equals("4")) {
                logic3 = "logical reasoning benar"
                logic++
            }else logic3 = "logical reasoning salah"
            if (no9.content.equals("1")) {
                logic4 = "pola kalimat benar"
                logic++
            }else logic4 = "pola kalimat salah"
            if (no10.content.equals("4")) {
                logic5 = "pola gambar benar"
                logic++
            } else logic5 = "pola gambar salah"
            result.answer.add([name: userInfo[0],
                             email: userInfo[1],
                             mobile: userInfo[2],
                             univ: userInfo[3],
                             lulus: userInfo[4],
                             exp: userInfo[5],
                            logic: logic,
                            logic1: logic1,
                               logic2: logic2,
                               logic3: logic3,
                               logic4: logic4,
                               logic5: logic5,
                               no11: no11.content,
                               no12: no12.content,
                               no13: no13.content,
                               no14: no14.content,
                               no15: no15.content])
        }
        respond result
    }
}
