# Rick and Morty
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