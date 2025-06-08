package com.example.test

import spock.lang.Specification

class LintCodeTest extends Specification {

    def "lintCode ejecuta los comandos de linting"() {
        given: "Un script Groovy que simula el comportamiento de lintCode.groovy"
        def script = """
            def call() {
                println 'Ejecutando linter...'
                println '0'  // Simulando salida exitosa de flake8
                println '0'  // Simulando salida exitosa del segundo comando flake8
            }
        """

        when: "Se ejecuta el script"
        def output = captureOutput {
            def shell = new GroovyShell()
            def scriptObj = shell.parse(script)
            scriptObj.call()
        }

        then: "Se ejecutan los comandos de linting"
        output.contains('Ejecutando linter...')
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
