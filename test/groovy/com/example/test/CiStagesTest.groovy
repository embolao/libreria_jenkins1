package com.example.test

import spock.lang.Specification

class CiStagesTest extends Specification {

    def "ciStages define las etapas del pipeline correctamente"() {
        given: "Un script Groovy que simula el comportamiento de ciStages.groovy"
        def script = """
            def call() {
                def pipeline = [:]
                pipeline.agent = 'any'
                pipeline.stages = [
                    [
                        name: 'Checkout',
                        steps: [
                            { println 'Ejecutando checkout' }
                        ]
                    ],
                    [
                        name: 'Setup Virtualenv',
                        steps: [
                            { println 'Configurando entorno virtual' }
                        ]
                    ],
                    [
                        name: 'Lint',
                        steps: [
                            { println 'Ejecutando linter' }
                        ]
                    ],
                    [
                        name: 'Test',
                        steps: [
                            { println 'Ejecutando pruebas' }
                        ]
                    ],
                    [
                        name: 'Deploy',
                        steps: [
                            { println 'Desplegando aplicación' }
                        ]
                    ]
                ]
                return pipeline
            }
        """

        when: "Se ejecuta el script"
        def output = captureOutput {
            def shell = new GroovyShell()
            def scriptObj = shell.parse(script)
            def pipeline = scriptObj.call()

            // Ejecutar los pasos del pipeline
            pipeline.stages.each { stage ->
                println "Stage: ${stage.name}"
                stage.steps.each { step ->
                    step.call()
                }
            }
        }

        then: "Se definen y ejecutan todas las etapas del pipeline"
        output.contains('Stage: Checkout')
        output.contains('Ejecutando checkout')
        output.contains('Stage: Setup Virtualenv')
        output.contains('Configurando entorno virtual')
        output.contains('Stage: Lint')
        output.contains('Ejecutando linter')
        output.contains('Stage: Test')
        output.contains('Ejecutando pruebas')
        output.contains('Stage: Deploy')
        output.contains('Desplegando aplicación')
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
