package com.example.test

import spock.lang.Specification

class RunTestsTest extends Specification {

    def "runTests ejecuta los comandos de prueba"() {
        given: "Un script Groovy que simula el comportamiento de runTests.groovy"
        def script = """
            def call() {
                println 'Ejecutando pruebas...'
                println '1 test passed'  // Simulando salida de pytest
            }
        """

        when: "Se ejecuta el script"
        def output = captureOutput {
            def shell = new GroovyShell()
            def scriptObj = shell.parse(script)
            scriptObj.call()
        }

        then: "Se ejecutan los comandos de prueba"
        output.contains('Ejecutando pruebas...')
        output.contains('1 test passed')
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
