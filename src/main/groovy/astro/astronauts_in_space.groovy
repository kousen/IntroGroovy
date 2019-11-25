package astro

import groovy.json.*
import groovy.sql.*
import groovy.transform.*
import com.google.gson.Gson

@Canonical
class Assignment {
    String name
    String craft
}

@Canonical
class AstroResponse {
    String message
    int number
    Assignment[] people
}

AstroResponse getAndParseJSON() {
    String jsonTxt = 'http://api.open-notify.org/astros.json'.toURL().text
    def json = new JsonSlurper().parseText(jsonTxt)
    println "There are ${json.number} people in space"
    return new Gson().fromJson(jsonTxt, AstroResponse)
}

void saveAstronautsInDB(AstroResponse response) {
    Sql sql = Sql.newInstance(url: 'jdbc:h2:~/astro', driver: 'org.h2.Driver')
    sql.execute '''
        create table if not exists ASTRONAUTS(
            id int auto_increment primary key,
            name varchar(50),
            craft varchar(50)
        )
    '''

    response.people.each {
        sql.execute "insert into ASTRONAUTS(name, craft) values ($it.name, $it.craft)"
    }
    sql.close()
}

void printAstronautsFromDB() {
    Sql sql = Sql.newInstance(url: 'jdbc:h2:~/astro', driver: 'org.h2.Driver')
    assert sql.rows('select * from ASTRONAUTS').size() == 6

    sql.eachRow('select * from ASTRONAUTS') { row ->
        println "${row.name.padRight(20)} aboard ${row.craft}"
    }
    sql.close()
}

getAndParseJSON().people.each {
    println it
}
