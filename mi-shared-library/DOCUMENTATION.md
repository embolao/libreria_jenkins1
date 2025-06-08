# Documentación de la Biblioteca Compartida de Jenkins

Esta biblioteca compartida proporciona funciones útiles para la automatización de pipelines de CI/CD en Jenkins. Incluye un conjunto completo de pruebas unitarias para garantizar la calidad del código. A continuación se detalla su uso, pruebas y las funciones disponibles.

## Tabla de Contenidos
1. [Requisitos](#requisitos)
2. [Configuración](#configuración)
3. [Uso en Jenkinsfile](#uso-en-jenkinsfile)
4. [Funciones Disponibles](#funciones-disponibles)
   - [buildApp](#buildapp)
   - [ciStages](#cistages)
   - [deployApp](#deployapp)
   - [lintCode](#lintcode)
   - [notifySlack](#notifyslack)
   - [runTests](#runtests)
5. [Pruebas](#pruebas)
   - [Ejecutar Pruebas](#ejecutar-pruebas)
   - [Estructura de Pruebas](#estructura-de-pruebas)
   - [Cobertura de Pruebas](#cobertura-de-pruebas)
6. [Ejemplo Completo](#ejemplo-completo)

## Requisitos

- Jenkins 2.277.1 o superior
- Pipeline plugin
- Git plugin
- Python 3.x (para las funciones de Python)
- Java 11 o superior (para ejecutar las pruebas)
- Gradle 7.0 o superior

## Configuración

1. En Jenkins, ve a **Manage Jenkins** > **Configure System**
2. Desplázate hasta **Global Pipeline Libraries**
3. Agrega una nueva biblioteca con los siguientes detalles:
   - **Name**: `mi-shared-library`
   - **Default version**: Especifica una rama o etiqueta
   - **Retrieval method**: Modern SCM
   - **Source Code Management**: Git
   - **Project Repository**: URL de tu repositorio Git

## Uso en Jenkinsfile

Para usar esta biblioteca en tu pipeline, agrega esta línea al inicio de tu Jenkinsfile:

```groovy
@Library('mi-shared-library@<versión>') _
```

## Funciones Disponibles

### buildApp

Configura un entorno virtual de Python e instala las dependencias.

**Uso:**
```groovy
buildApp()
```

**Detalles:**
- Crea un entorno virtual de Python
- Actualiza pip
- Instala las dependencias de requirements.txt si existe

---

### ciStages

Ejecuta todas las etapas del pipeline de CI/CD en orden.

**Uso:**
```groovy
ciStages()
```

**Etapas incluidas:**
1. Checkout del código
2. Configuración del entorno (buildApp)
3. Análisis de código (lintCode)
4. Ejecución de pruebas (runTests)
5. Despliegue (deployApp)

---

### deployApp

Simula el despliegue de la aplicación.

**Uso:**
```groovy
deployApp()
```

**Nota:** Actualmente es una implementación simulada. Debes personalizar esta función según tus necesidades de despliegue.

---

### lintCode

Ejecuta el linter Flake8 en el código Python.

**Uso:**
```groovy
lintCode()
```

**Detalles:**
- Instala Flake8 si no está instalado
- Ejecuta Flake8 en el directorio actual
- Excluye el directorio venv

---

### notifySlack

Envía una notificación a Slack.

**Uso:**
```groovy
notifySlack("Mensaje de prueba")
```

**Parámetros:**
- `message` (String): Mensaje a enviar a Slack

**Nota:** Actualmente solo muestra el mensaje en la consola. Para habilitar las notificaciones reales, configura el webhook de Slack y descomenta la línea correspondiente en el código.

---

### runTests

Ejecuta las pruebas unitarias usando pytest.

**Uso:**
```groovy
runTests()
```

**Detalles:**
- Configura el PYTHONPATH correctamente
- Ejecuta pytest en el directorio de pruebas
- Asume que las pruebas están en `src/agente_prueba2/tests/`

## Pruebas

La biblioteca incluye pruebas unitarias completas escritas con Spock Framework para garantizar la calidad y estabilidad del código.

### Ejecutar Pruebas

Para ejecutar todas las pruebas unitarias:

```bash
./gradlew test
```

Para generar un informe de cobertura (requiere configuración adicional de JaCoCo):

```bash
./gradlew jacocoTestReport
```

### Estructura de Pruebas

Las pruebas se organizan de la siguiente manera:

```
test/
└── groovy/
    └── com/example/test/
        ├── BuildAppTest.groovy      # Pruebas para buildApp
        ├── CiStagesTest.groovy     # Pruebas para el pipeline de CI
        ├── DeployAppTest.groovy    # Pruebas para deployApp
        ├── LintCodeTest.groovy     # Pruebas para lintCode
        ├── NotifySlackTest.groovy  # Pruebas para notifySlack
        └── RunTestsTest.groovy     # Pruebas para runTests
```

### Cobertura de Pruebas

Cada función de la biblioteca tiene pruebas que cubren:

- Flujos de trabajo estándar
- Casos límite
- Manejo de errores
- Validación de parámetros

## Ejemplo Completo

```groovy
@Library('mi-shared-library@main') _

pipeline {
    agent any

    stages {
        stage('CI/CD Pipeline') {
            steps {
                script {
                    ciStages()
                }
            }
        }
    }

    post {
        success {
            notifySlack("✅ Pipeline completado exitosamente")
        }
        failure {
            notifySlack("❌ El pipeline ha fallado")
        }
    }
}
```

## Personalización

Puedes personalizar cualquiera de las funciones copiando el archivo correspondiente desde `vars/` a tu repositorio y modificándolo según tus necesidades.
