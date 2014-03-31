/**
 * Created by bawe on 2014-03-31.
 */

package Pages

import geb.Page


class Homepage extends Page {
    static url = "http://www.mobica.com"
    static at = { title == "Home - Mobica" }
    static content = {

        //aboutUsLink {$("div.navbar ul").find("li", 2)}
        aboutUsLink { $("li", class: contains("item-107")) }

        allMenuLinks { $("div.navbar ul").find("li") }

    }

    def allLinks(){
        allMenuLinks.nextAll().each {
            def counter
            println(klasa)

        }

    }
}
