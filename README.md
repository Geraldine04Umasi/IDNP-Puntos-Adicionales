# INTEGRANTES
- Condorios Yllapuma Jorge Enrique
- Umasi Coaguila Geraldine Marjorie

Link directo: https://github.com/Geraldine04Umasi/IDNP-Puntos-Adicionales/blob/main/app/src/main/java/com/example/listas/MainActivity.kt

# IDNP-Puntos-Adicionales

Explicación 
1. Renderizado diferido (lazy composition)

En Jetpack Compose, el contenido de cada pestaña (Tab) solo se compone cuando se vuelve visible.
Esto significa que si la lista (LazyColumn) está dentro de un tab que aún no se ha seleccionado, no se crea ni se renderiza todavía.

Ejemplo:
Cuando estás en Tab 1, el contenido de Tab 2 (la lista de frutas) aún no existe en memoria, por lo que no consume recursos ni se ejecuta su composición.

2. Cambio de pestaña

Cuando el usuario cambia a Tab 2, Compose detecta el cambio de estado (selectedTabIndex) y compone por primera vez el contenido de esa pestaña.
En ese momento se crea y renderiza la lista LazyColumn.

3. LazyColumn

LazyColumn también implementa su propio mecanismo de renderizado perezoso:
solo crea los elementos visibles en pantalla, mejorando el rendimiento incluso dentro de un tab recién mostrado.

4. Resumen del comportamiento

Si la lista está en un tab no visible, no se renderiza ni consume recursos.

Cuando el tab se vuelve visible, la lista se construye dinámicamente.

Si se cambia de pestaña, Compose puede mantener o descartar el estado según el uso de remember.
