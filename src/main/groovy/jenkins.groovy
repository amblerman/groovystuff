import java.nio.file.Path
import java.nio.file.Paths

import groovy.json.JsonSlurper
def inputFile = new File('.//jenkins.json')
def inputJSON = new JsonSlurper().parse(inputFile)
def keys = inputJSON.keySet() as List
Path f = Paths.get('resources/upload.csv')

f.withReader {
    for (line in it.lines()) { //<1>
        println line
    }
}
