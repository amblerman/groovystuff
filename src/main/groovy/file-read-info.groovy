//If you want to run this file as a script or groovyConsole
//you'll need to uncomment the next line:
@Grab('org.apache.tika:tika-core:1.10')

import org.apache.tika.Tika

import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.Files
import java.nio.file.attribute.BasicFileAttributes

//Path f = Paths.get('resources/hello.html') //<1>
Path f = Paths.get('/Users/andrewmoynahan/Documents/test/installed.properties') //<1>
BasicFileAttributes attrs = Files.readAttributes(f, BasicFileAttributes) //<2>

Tika tika = new Tika() //<3>

println """
File name: ${f.fileName}
Absolute path: ${f.toAbsolutePath()}

The file exists: ${Files.exists(f)}

File size: ${Files.size(f)} bytes

The file is readable: ${Files.isReadable(f)}
The file is writable: ${Files.isWritable(f)}
The file is executable: ${Files.isExecutable(f)}
The file is a regular file: ${Files.isRegularFile(f)}

Content type: ${tika.detect(f.toFile())}

Created: ${attrs.creationTime()}
Last modified: ${attrs.lastModifiedTime()}
Last accessed: ${attrs.lastAccessTime()}
"""
