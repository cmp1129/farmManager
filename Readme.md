# 🐄🌾 FarmManager

FarmManager es una aplicación de gestión integral de explotaciones agrícolas y ganaderas. Este proyecto nace con la idea de proporcionar una solución digital adaptable a las necesidades reales de los granjeros, modernizando la administración de animales, cultivos, maquinaria, empleados y finanzas.

---

## 📌 Funcionalidades actuales: Gestión de Animales 🐑

En esta primera fase se ha implementado el módulo de **Gestión de Animales**, que permite:

- 📃 Listar todos los animales registrados.
- 🐾 Filtrar animales por especie.
- 🔍 Consultar detalle de un animal.
- 🗑️ Eliminar animales.
- ✏️ Añadir y guardar nuevos animales.
- 📊 Dashboard y Estadísticas de los animales de tu BD.

---

## 📦 Estructura del Proyecto

```
src/
└── main/
├── java/com/farm/farm/
│ ├── controller/
│ │ └── AnimalController.java
│ ├── model/
│ │ └── Animal.java
│ ├── repository/
│ │ └── AnimalRepository.java
│ └── service/
│ └── AnimalService.java
└── resources/
└── templates/
└── plantillaAnimales.html
```

---

## 🛠️ Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.4.5**
- **Spring MVC**
- **Spring Data JPA**
- **Thymeleaf**
- **H2 Database (en desarrollo)**
- **Gradle**
- **Charts.js**

---

## 📈 Futuras implementaciones

El objetivo es extender FarmManager Pro hasta cubrir todas las áreas habituales de gestión de una granja:

### 📌 Módulos previstos:

- 🌿 **Gestión de Cultivos**

  - Registro de parcelas y tipos de cultivo.
  - Fechas de siembra y cosecha.
  - Control de incidencias (plagas, sequías…).

- 🚜 **Gestión de Maquinaria**

  - Registro de maquinaria disponible.
  - Control de mantenimientos y revisiones.

- 👨‍🌾 **Gestión de Empleados**

  - Alta y baja de personal.
  - Control de jornadas y tareas.

- 💶 **Gestión Económica**

  - Registro de ingresos y gastos.
  - Facturación.
  - Estadísticas de rentabilidad.

---

## 🚀 Cómo ejecutar el proyecto

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tuusuario/farmmanager-pro.git
   ```
