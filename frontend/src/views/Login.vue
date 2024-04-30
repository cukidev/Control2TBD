<template>
  <main>
    <div class="title">
      <img src="@/assets/logo.png" alt="Logo" class="logo" />
    </div>
    <div class="content">
      <div class="form">
        <h1>Task Manager</h1>
      </div>
      <div>
      </div>
      <div class="form">
        <input placeholder="Nombre de usuario" type="text" v-model="user">
        <input placeholder="Contraseña" type="password" v-model="password">
        <button @click="sendForm">Iniciar sesión</button>
      </div>
    </div>
  </main>
</template>

<script setup>
  import logo from '@/assets/logo.png';
  import { useRouter } from 'vue-router';
  import axios from 'axios';
  import { ref } from 'vue';



  const user = ref("");
  const password = ref("");
  const router = useRouter();

  const sendForm = async () => {
    if (user.value.trim() === "") {
      window.alert("Debe ingresar un usuario");
      return;
    }

    if (password.value.trim() === "") {
      window.alert("Debe ingresar una contraseña");
      return;
    }

    const body = {
      user: user.value,
      password: password.value
    };

    try {
    const response = await axios.post("http://localhost:8090/users/login", body);
    localStorage.setItem('userToken', response.data.jwt);
    localStorage.setItem('userId', response.data.userId);
    router.push('/tasks');
  } catch (error) {
    console.error('Error during login attempt:', error);
    window.alert('Error al iniciar sesión. Por favor, intente nuevamente.');
  }
}
</script>

<style scoped>

main {
  display: flex;
  flex-direction: column;
  height: 100vh;
  width: 100vw;
  align-items: center;
  justify-content: center;
  background: #280b45;
}

.content {
  width: 30%; 
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); 
  padding: 40px;
  border-radius: 5px;
  background: white;
  display: flex
}

.form {
  display: flex;
  flex-direction: column;
  gap: 10px; 
}


input {
  padding: 10px;
  border: 1px solid #ccc; 
  border-radius: 4px; 
}

button {
  padding: 10px;
  background-color: #4e0ecc; 
  color: white; 
  border: none; 
  border-radius: 4px; 
  cursor: pointer; 
  transition: background-color 0.3s ease; 
}

button:hover {
  background-color: #372794; 
}

h1 {
  margin-bottom: 20px; 
  color: #4e0ecc; 
}

.logo {
  width: 100px;
  height: auto; 
  display: block;
  margin: 20px auto;
}
</style>
