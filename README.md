# Biblioteca Compartida para Jenkins

[![Build Status](https://img.shields.io/jenkins/build?job=mi-shared-library)](https://jenkins.example.com/job/mi-shared-library)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![GitHub release](https://img.shields.io/github/release/tu-usuario/mi-shared-library.svg)](https://github.com/tu-usuario/mi-shared-library/releases)

Una biblioteca compartida de Jenkins que proporciona funciones reutilizables para la automatización de pipelines CI/CD. Incluye utilidades para construcción, pruebas, análisis de código y despliegue de aplicaciones.

## 🚀 Características Principales

- **Gestión de Entornos**: Configuración automática de entornos virtuales Python
- **Análisis de Código**: Integración con linters y herramientas de calidad
- **Pruebas Automatizadas**: Ejecución de pruebas unitarias y de integración
- **Despliegue**: Flujos de trabajo estandarizados para despliegues
- **Notificaciones**: Integración con canales de comunicación como Slack

## 📦 Requisitos

- Jenkins 2.277.1 o superior
- Java 11 o superior
- Python 3.x (para funciones específicas)
- Gradle 7.0+ (para desarrollo y pruebas)

## 🛠️ Instalación

### Configuración en Jenkins

1. Ve a **Manage Jenkins** > **Configure System**
2. Desplázate a **Global Pipeline Libraries**
3. Añade una nueva biblioteca con estos detalles:
   - **Name**: `mi-shared-library`
   - **Default version**: Rama o etiqueta deseada (ej. `main`)
   - **Retrieval method**: Modern SCM
   - **Source Code Management**: Git
   - **Project Repository**: URL de tu repositorio Git

### Uso en Jenkinsfile

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

## 🧪 Ejecución de Pruebas

Para ejecutar las pruebas unitarias localmente:

```bash
# Instalar dependencias (solo primera vez)
./gradlew build

# Ejecutar pruebas
./gradlew test

# Generar reporte de cobertura
./gradlew jacocoTestReport
```

## 📂 Estructura del Proyecto

```
.
├── mi-shared-library/     # Código fuente de la biblioteca
│   ├── src/               # Código Groovy
│   ├── vars/              # Variables y funciones globales
│   └── resources/         # Recursos estáticos
├── test/                  # Pruebas unitarias
│   └── groovy/
│       └── com/example/test/
├── build.gradle          # Configuración de Gradle
├── Jenkinsfile           # Pipeline de CI/CD
└── README.md             # Este archivo
```

## 📚 Documentación Detallada

Consulta la [documentación completa](mi-shared-library/DOCUMENTATION.md) para obtener información detallada sobre todas las funciones disponibles y su uso.

## 🤝 Contribución

¡Las contribuciones son bienvenidas! Por favor, lee nuestras [pautas de contribución](CONTRIBUTING.md) para más detalles.

## 📄 Licencia

Este proyecto está licenciado bajo la Licencia Embolao - ver el archivo [LICENSE](LICENSE) para más detalles.

## ✉️ Contacto

Equipo de Desarrollo

---

<div align="center">
    <p>Hecho con ❤️ por el equipo de desarrollo</p>
</div>
