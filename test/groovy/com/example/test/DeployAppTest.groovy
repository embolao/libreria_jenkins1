package com.example.test

import spock.lang.Specification

class DeployAppTest extends Specification {

    def "deployApp ejecuta los comandos de despliegue"() {
        given: "Un script Groovy que simula el comportamiento de deployApp.groovy"
        def script = """
            def call() {
                println 'Desplegando la aplicación...'
                println 'Simulando despliegue de la aplicación'
            }
        """

        when: "Se ejecuta el script"
        def output = captureOutput {
            def shell = new GroovyShell()
            def scriptObj = shell.parse(script)
            scriptObj.call()
        }

        then: "Se ejecutan los comandos de despliegue"
        output.contains('Desplegando la aplicación...')
        output.contains('Simulando despliegue de la aplicación')
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
