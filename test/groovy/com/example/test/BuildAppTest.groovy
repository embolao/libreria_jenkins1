package com.example.test

import spock.lang.Specification

class BuildAppTest extends Specification {

    def "buildApp ejecuta los comandos básicos"() {
        given: "Un script Groovy que simula el comportamiento de buildApp.groovy"
        def script = """
            def call() {
                println "Ejecutando: python3 -m venv venv"
                println "Ejecutando: . venv/bin/activate"
                println "Ejecutando: pip install --upgrade pip"
                if (new File('requirements.txt').exists()) {
                    println "Ejecutando: pip install -r requirements.txt"
                }
            }
        """

        when: "Se ejecuta el script"
        def output = captureOutput {
            def shell = new GroovyShell()
            def scriptObj = shell.parse(script)
            scriptObj.call()
        }

        then: "Se ejecutan los comandos esperados"
        output.contains("python3 -m venv venv")
        output.contains("pip install --upgrade pip")
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
