<template>
  <main>
    <div class="welcome-container">
      <img src="@/assets/logo.png" alt="Logo" class="logo" />
      <h1>Bienvenido a Task Manager</h1>
      <p>La plataforma líder en gestión de tareas y productividad.</p>
      <div class="buttons-container">
        <router-link to="/login">
          <button class="button">Iniciar Sesión</button>
        </router-link>
        <router-link to="/registro">
          <button class="button secondary">Registrarse</button>
        </router-link>
      </div>
    </div>
  </main>
</template>

<script setup>
import logo from '@/assets/logo.png';
</script>

<style scoped>
main {
  display: flex;
  height: 100vh;
  align-items: center;
  justify-content: center;
  background: #280b45;
}

.welcome-container {
  text-align: center;
  color: white;
}

.logo {
  width: 150px;
  height: auto;
  margin-bottom: 20px;
}

.buttons-container {
  margin-top: 20px;
}

.button {
  padding: 10px 20px;
  margin: 0 10px;
  background-color: #4e0ecc;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  text-decoration: none;
}

.button:hover {
  background-color: #372794;
}

.button.secondary {
  background-color: #6c63ff;
}

.button.secondary:hover {
  background-color: #5a52d5;
}

h1 {
  margin: 20px 0;
}

p {
  font-size: 1.1em;
  margin-bottom: 20px;
}
</style>
