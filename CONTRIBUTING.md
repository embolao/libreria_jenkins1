# Guía de Contribución

¡Gracias por tu interés en contribuir a nuestra biblioteca compartida de Jenkins! Apreciamos tu tiempo y esfuerzo. Por favor, tómate un momento para revisar esta guía antes de enviar tus cambios.

## 📋 Tabla de Contenidos

- [Cód de Conducta](#%EF%B8%8F-código-de-conducta)
- [¿Cómo Contribuir?](#%EF%B8%8F-cómo-contribuir)
- [Reportar Errores](#-reportar-errores)
- [Solicitud de Funciones](#-solicitud-de-funciones)
- [Proceso de Revisión de Código](#-proceso-de-revisión-de-código)
- [Estándares de Código](#-estándares-de-código)
- [Pruebas](#-pruebas)
- [Commit y Mensajes de Commit](#-commit-y-mensajes-de-commit)
- [Licencia](#-licencia)

## 👥 Código de Conducta

Este proyecto y todos los participantes se rigen por nuestro [Código de Conducta](CODE_OF_CONDUCT.md). Al participar, se espera que respetes este código.

## ✨ ¿Cómo Contribuir?

1. **Fork** el repositorio
2. Crea una rama para tu característica (`git checkout -b feature/AmazingFeature`)
3. Haz commit de tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Haz push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un **Pull Request**

## 🐛 Reportar Errores

Por favor, usa el [seguidor de incidencias](https://github.com/tu-usuario/mi-shared-library/issues) para informar de errores o problemas.

### Plantilla para Reporte de Errores

```markdown
## Descripción

[Descripción clara y concisa del error]

## Pasos para Reproducir
1. Ir a '...'
2. Hacer clic en '...'
3. Desplazarse hasta '...'
4. Ver error

## Comportamiento Esperado
[Lo que esperabas que ocurriera]

## Capturas de Pantalla
[Si es aplicable, añade capturas de pantalla para ayudar a explicar el problema]

## Entorno (por favor completa la siguiente información):
- Versión de Jenkins: [ej. 2.303.1]
- Versión de Java: [ej. 11.0.11]
- Sistema Operativo: [ej. Ubuntu 20.04]
- Plugin: [ej. Pipeline: 2.7]

## Contexto Adicional
[Añade cualquier otro contexto sobre el problema aquí]
```

## 💡 Solicitud de Funciones

¡Apreciamos tus sugerencias de nuevas características! Por favor, sigue estos pasos:

1. Verifica si la característica ya ha sido solicitada
2. Proporciona una descripción detallada de la funcionalidad deseada
3. Explica por qué esta característica sería útil
4. Especifica si estarías dispuesto a ayudar a implementarla

## 🔍 Proceso de Revisión de Código

1. Asegúrate de que todas las pruebas pasen
2. Actualiza la documentación si es necesario
3. Los cambios deben ser revisados por al menos un mantenedor
4. Los pull requests deberán pasar todas las comprobaciones de CI/CD

## 📏 Estándares de Código

### Estilo de Código

- Sigue las [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) para código Java/Groovy
- Usa 4 espacios para la indentación
- Línea máxima de 120 caracteres

### Documentación

- Documenta todas las funciones públicas
- Incluye ejemplos de uso
- Mantén el README.md actualizado

## 🧪 Pruebas

- Añade pruebas para cualquier nueva funcionalidad
- Asegúrate de que todas las pruebas pasen
- Mantén la cobertura de código por encima del 80%

## 💾 Commit y Mensajes de Commit

Usamos [Conventional Commits](https://www.conventionalcommits.org/) para nuestros mensajes de commit. El formato del mensaje debe ser:

```
<tipo>[ámbito opcional]: <descripción>

[Cuerpo opcional]

[Pie de página opcional]
```

### Tipos de Commit

- `feat`: Nueva característica
- `fix`: Corrección de error
- `docs`: Cambios en la documentación
- `style`: Cambios que no afectan el significado del código (espacios, formato, etc.)
- `refactor`: Cambio en el código que no corrige un error ni añade una característica
- `perf`: Cambios que mejoran el rendimiento
- `test`: Añadir o corregir pruebas
- `chore`: Cambios en el proceso de construcción o herramientas auxiliares

### Ejemplos

```
feat: añadir autenticación con OAuth2

Se ha implementado la autenticación usando OAuth2 con soporte para múltiples proveedores.

Cierra #123
```

```
fix(core): corregir fuga de memoria en el manejador de conexiones

Se ha corregido una fuga de memoria que ocurría cuando se cerraban conexiones inactivas.

Fixes #456
```

## 📄 Licencia

Al contribuir, aceptas que tus contribuciones se regirán por la [Licencia Embolao](LICENSE).

---

## Contacto del Equipo

Para cualquier consulta relacionada con contribuciones o el proyecto en general, puedes contactar al equipo de desarrollo.

---

¡Gracias por contribuir a hacer de este proyecto algo mejor! 🎉

<div align="center">
    <p>Equipo de Desarrollo</p>
</div>
