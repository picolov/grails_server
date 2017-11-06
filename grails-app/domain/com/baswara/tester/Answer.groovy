package com.baswara.tester

class Answer {
    String id = UUID.randomUUID().toString()
    int number
    String content

    String createdBy
    Date createdDate
    String updatedBy
    Date updatedDate

    static constraints = {
        content nullable: true
        updatedBy nullable: true
        updatedDate nullable: true
    }

    static mapping = {
        id generator: 'assigned'
        content type: "text"
    }
}
