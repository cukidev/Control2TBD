<template>
  <main>
    <div class="title">
      <img src="@/assets/logo.png" alt="Logo" class="logo" />
    </div>
    <div class="content">
      <h1>Gestión de Tareas</h1>
      <router-link to="/tasks/new" class="button">Nueva Tarea</router-link>
      <ul class="task-list">
    <div class="filters">
    <input type="text" v-model="searchQuery" placeholder="Buscar tareas...">
    <select v-model="filterStatus">
      <option value="">Todos los estados</option>
      <option value="pending">Pendiente</option>
      <option value="completed">Completada</option>
    </select>
    </div>
        <li v-for="task in filteredTasks" :key="task.id" class="task-item">
          <h2>{{ task.title }}</h2>
          <p>{{ task.description }}</p>
          <p>Vencimiento: {{ task.due_date }}</p>
          <div class="task-actions">
            <button @click="completeTask(task)" class="button complete" :disabled="task.status === 'completed'">Finalizar</button>
            <router-link :to="`/tasks/edit/${task.id}`" class="button">Editar</router-link>
            <button @click="deleteTask(task.id)" class="button delete">Eliminar</button>
          </div>
        </li>
      </ul>
      <div v-if="tasks.length === 0" class="no-tasks">
        <p>No hay tareas registradas.</p>
      </div>
    </div>
  </main>
</template>


<script setup>
import { ref, onMounted, computed } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

const router = useRouter();
const tasks = ref([]);
const searchQuery = ref('');
const filterStatus = ref('');

onMounted(async () => {
  await fetchTasks();
});


const fetchTasks = async () => {
  try {
    const response = await axios.get("http://localhost:8090/users/tasks");
    console.log("Tareas recibidas:", response.data);
    tasks.value = response.data;
  } catch (error) {
    console.error('Error fetching tasks:', error);
  }
};


const deleteTask = async (taskId) => {
  try {
    await axios.delete(`/api/tasks/${taskId}`);
    tasks.value = tasks.value.filter((task) => task.id !== taskId);
  } catch (error) {
    console.error('Error deleting task:', error);
  }
};

const filteredTasks = computed(() => {
  return tasks.value
    .filter(task => {
      return (filterStatus.value === '' || task.status === filterStatus.value) &&
             (task.title.toLowerCase().includes(searchQuery.value.toLowerCase()) || 
              task.description.toLowerCase().includes(searchQuery.value.toLowerCase()));
    });
});

</script>

<style scoped>
main {
  display: flex;
  flex-direction: column;
  height: 100vh;
  align-items: center;
  justify-content: center;
  background: #280b45;
  color: white;
}

.content {
  width: 60%; 
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  padding: 20px;
  border-radius: 5px;
  background: white;
  color: black;
  text-align: center;
}

.task-list {
  list-style: none;
  padding: 0;
  text-align: left;
}

.task-item {
  background: #f3f3f3;
  margin: 10px 0;
  padding: 15px;
  border-radius: 5px;
}

.task-actions {
  display: flex;
  justify-content: flex-end;
}

.button {
  padding: 10px 15px;
  margin-left: 10px;
  background-color: #4e0ecc; 
  color: white; 
  border: none; 
  border-radius: 4px; 
  cursor: pointer; 
  transition: background-color 0.3s ease;
}

.button:hover {
  background-color: #372794;
}

.button.delete {
  background-color: #e3342f; /* Un color rojo para el botón de eliminar */
}

.button.delete:hover {
  background-color: #cc1f1a;
}

.no-tasks {
  margin-top: 20px;
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

.filters {
  margin-bottom: 20px;
}

.filters input,
.filters select {
  padding: 10px;
  margin-right: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.button.complete {
  background-color: #38c172;
}

.button.complete:hover {
  background-color: #1f9d55;
}

.button.complete:disabled {
  background-color: #6c757d;
  cursor: not-allowed;
}

</style>