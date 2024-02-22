# Rick and Morty
![Rick and Morty!](/assets/rick_and_morty.gif "Rick and Morty")
Para la architectura del proyecto se uso Clean architecture y MVVM para lo que seria la capa de presentación, el proyecto esta organizado siguiendo la siguiente estructura de carpetas:

<ul>
  <li>data</li>
  <ul>
      <li>datasources</li>
      <li>remote</li>
      <li>repositories</li>
    </ul>
  <li>di</li>
  <li>domain
    <ul>
      <li>entities</li>
      <li>repositories</li>
      <li>usecases</li>
    </ul>
  </li>
  <li>ui
    <ul>
      <li>home</li>
      <li>models</li>
      <li>theme</li>
    </ul>
  </li>
  <li>utils</li>
</ul>

# Observaciones
Tomando en cuenta la simplicidad del proyecto y que no se guarda localmente los datos, solo se ha utilizado un lugar para definir las entidades (domain) para los datos, para un proyecto más grande que maneje el modo offline se utilizaria una entidad distinta para cada layer, el cual contendria solo los datos que se necesitaria en el layer, y se haria uso de mappers o extension functions para la conversion entre clases.