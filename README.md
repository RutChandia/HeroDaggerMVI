# HeroDaggerMVI

Aplicación móvil desarrollada en Kotlin, que utiliza las siguientes tecnologías principales:

## Funcionalidades
- Lista de superhéroes obtenida de una API externa.
- Pantalla de detalles para cada superhéroe.
- Arquitectura basada en **MVI** (Model-View-Intent) utilizando **Orbit MVI**.
- Navegación basada en **Jetpack Compose Navigation**.
- Inyección de dependencias mediante **Dagger Hilt**.

## Arquitectura
El proyecto sigue el patrón de arquitectura MVI:
- **Model**: Gestión de los datos y la lógica de negocio.
- **View**: Interfaz de usuario creada con Jetpack Compose.
- **Intent**: Manejo de los estados de UI y side-effects mediante [Orbit MVI](https://github.com/orbit-mvi/orbit-mvi).

## Capturas de Pantalla
<div style="display: flex; flex-wrap: wrap; gap: 10px;">
    <img src="assets/HDMVI-search.jpg" alt="search" width="258">
    <img src="assets/HDMVI-info.jpg" alt="info" width="259">
    <img src="assets/HDMVI-stats.jpg" alt="details" width="270">
</div>
