<template>
    <main>
        <div class="title">
      <img src="@/assets/logo.png" alt="Logo" class="logo" />
    </div>
      <div class="content">
        <h1>Crear Nueva Tarea</h1>
        <form @submit.prevent="createTask" class="form">
          <input v-model="newTask.title" type="text" placeholder="Título" required>
          <textarea v-model="newTask.description" placeholder="Descripción" required></textarea>
          <input v-model="newTask.due_date" type="date" required>
          <div class="form-actions">
            <button type="submit" class="button">Guardar</button>
            <router-link to="/tasks" class="button button-secondary">Cancelar</router-link>
          </div>
        </form>
      </div>
    </main>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import axios from 'axios';
  import { useRouter } from 'vue-router';
  
  const newTask = ref({
    title: '',
    description: '',
    due_date: ''
  });
  
  const router = useRouter();
  
  const createTask = async () => {
    try {
      await axios.post('http://localhost:8090/tasks/save', newTask.value);
      newTask.value = { title: '', description: '', due_date: '' };
      router.push('/tasks');
    } catch (error) {
      console.error('Error creating task:', error);
      alert('Error al crear la tarea. Por favor, intente nuevamente.');
    }
  };

  </script>
  
  <style scoped>
  main {
    display: flex;
    flex-direction: column;
    height: 100vh;
    align-items: center;
    justify-content: center;
    background: #280b45;
  }
  
  .content {
    width: 40%;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); 
    padding: 40px;
    border-radius: 5px;
    background: white;
    text-align: center;
  }
  
  .form {
    display: flex;
    flex-direction: column;
    gap: 15px;
  }
  
  input[type="text"],
  input[type="date"],
  textarea {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    width: 100%;
  }
  
  .form-actions {
    display: flex;
    justify-content: space-between;
    margin-top: 20px;
  }
  
  .button {
    padding: 10px 15px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;
    color: white;
    background-color: #4e0ecc;
  }
  
  .button:hover {
    background-color: #372794;
  }
  
  .button-secondary {
    background-color: #6c757d;
  }
  
  .button-secondary:hover {
    background-color: #565e64;
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
  