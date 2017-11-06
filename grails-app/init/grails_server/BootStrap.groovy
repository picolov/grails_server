package grails_server

import com.baswara.tester.Authority
import com.baswara.tester.User
import com.baswara.tester.UserAuthority

class BootStrap {

    def init = { servletContext ->
//        def role1 = new Authority(authority:"ROLE_USER").save flush:true
//        def user1 = new User(username:"picolov@gmail.com",password:"password").save flush:true
//        UserAuthority.create(user1, role1)
//        def user2 = new User(username:"kimkim@gmail.com",password:"password").save flush:true
//        UserAuthority.create(user2, role1)

    }
    def destroy = {
    }
}
