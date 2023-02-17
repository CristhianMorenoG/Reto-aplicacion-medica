# Reto-aplicacion-medica
## ¿Cómo empezar?

1. Debemos descargar el proyecto
2. Debemos abrir el proyecto con Intellij
3. Para este proyecto usamos como motor de bd postgresql por ende debes descargar pgadmin y crear una base de datos en mi caso se llama `clinica`, en caso de que se llame diferente y haya cierta configuración de la bd se debe modificar los **poperties** del proyecto
4. Luego de tener la bd montada debes correr el proyecto con el archivo `ClinicaAplication`
5. Cuando el proyecto este arriba, puedes usar la configuración de swagger para revisar el proyecto esto con la url: [http://localhost:8080/app/swagger-ui/index.html#/](http://localhost:8080/app/swagger-ui/index.html#/)


## Documentación

El proyecto se dividió en 2 controladores, uno para él `doctor` y otro para los `pacientes`,
esto con el objetivo de dividir que puede hacer el doctor y que puede hacer un paciente.

tenemos los siguientes endpoints

### Endpoints Doctores

[GET]`app/citas_sin_confirmar`
Este get me trae todas las citas cuya confirmación es NULL para poder ver que citas están
aún sin confirmar.

[POST]`app/confirmar_cita/cita/{cita_id}`
Este endpoint nos ayuda para poder confirmar una cita establecida a través de su id y su campo en la bd de `confirmacion` se establece como `True`

[POST]`app/crear_horario`
Este endpoint me crea el horario del Dr, añadiendo el día, la hora de inicio, el minuto de inicio, la hora y minuto de fin de la jornada laboral.

[POST]`app/crear_paciente`
Este endpoint me crea un paciente.

[DELETE]`app/paciente/{doc_paciente}`
Este endpoint me elimina un paciente a partir de su documento

[PATCH]`app/paciente/{doc_paciente}`
Este endpoint me actualiza la información de un paciente específico a través de su documento

[POST]`app/rechazar_cita/cita/{cita_id}`
Este endpoint me actualiza la `confirmacion` de una cita en falso y vuelve disponible el horario del **Dr** en ese horario.

### Endpoints Pacientes
[POST]`app/agendar_cita`
Este endpoint me crea y me agenda una cita, con `confirmacion` en `NULL`

[GET]`app/ver_disponibilidad`
Este endpoint me trae todo el horario disponible del **Dr**, esto se hace sacando el horario disponible y las citas agendadas.
