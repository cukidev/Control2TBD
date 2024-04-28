import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Registro from '@/views/Registro.vue'
import Login from '@/views/Login.vue'
import TaskList from '@/views/TaskList.vue'
import TaskEdit from '@/views/TaskEdit.vue'
import TaskNew from '@/views/TaskNew.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/registro',
      name: 'registro',
      component: Registro
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/tasks',
      name: 'tasks',
      component: TaskList
    }
    ,
    {
      path: '/tasks/new',
      name: 'tasks-new',
      component: TaskNew
    }
    ,
    {
      path: '/tasks/:id',
      name: 'tasks-edit',
      component: TaskEdit
    }
    
  ]
})

export default router
