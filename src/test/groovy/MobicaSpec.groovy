
/**
 * Created by bawe on 2014-03-31.
 */


import Pages.Homepage
import geb.spock.GebReportingSpec
import geb.Page

class MobicaSpec extends GebReportingSpec {

    def "Successful redirection to Mobica page"(){

        given: "I am on Mobica page"
        to Homepage

        expect: "There is proper page title"
        at Homepage

    }
    def "Clicking on 'About us' links opens menu"(){
        given: "I am on Mobica page"
        to Homepage

        when: "clicking on menu link"
        aboutUsLink.click()

        then:
        title == "About us - Mobica"
    }
    def "Displaying menu links"() {
        given: "I am on Mobica page"
        to Homepage

        when:

        println(allLinks())
        //println (allMenuLinks.getAttribute("class"))
        //println (allMenuLinks.nextAll())
        //allLinks()



        then:
        getTitle()
    }
}