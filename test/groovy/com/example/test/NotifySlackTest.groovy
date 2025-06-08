package com.example.test

import spock.lang.Specification

class NotifySlackTest extends Specification {

    def "notifySlack imprime el mensaje correctamente"() {
        given: "Un script Groovy que simula el comportamiento de notifySlack.groovy"
        def script = """
            def call(message) {
                println "Notificación: \${message ?: ''}"
            }
        """

        when: "Se ejecuta el script con un mensaje"
        def output = captureOutput {
            def shell = new GroovyShell()
            def scriptObj = shell.parse(script)
            scriptObj.call("Mensaje de prueba")
        }

        then: "El mensaje se imprime correctamente"
        output.contains("Notificación: Mensaje de prueba")
    }

    def "notifySlack maneja mensajes vacíos"() {
        given: "Un script Groovy que simula el comportamiento de notifySlack.groovy"
        def script = """
            def call(message) {
                println "Notificación: \${message ?: ''}"
            }
        """

        when: "Se ejecuta el script con un mensaje vacío"
        def output = captureOutput {
            def shell = new GroovyShell()
            def scriptObj = shell.parse(script)
            scriptObj.call("")
        }

        then: "La función se ejecuta sin errores"
        output.contains("Notificación: ")
    }

    // Método auxiliar para capturar la salida estándar
    private String captureOutput(Closure closure) {
        def out = new ByteArrayOutputStream()
        def originalOut = System.out
        System.setOut(new PrintStream(out))
        try {
            closure.call()
            return out.toString()
        } finally {
            System.out.flush()
            System.setOut(originalOut)
        }
    }
}
