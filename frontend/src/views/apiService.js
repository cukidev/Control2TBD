import axios from 'axios';

const API_URL = 'http://localhost:8090';

export const obtenerTareas = () => {
  return axios.get(`${API_URL}/tasks/getAll`);
};

export const obtenerTareaPorId = (id) => {
  return axios.get(`${API_URL}/${id}`);
};

export const crearTarea = (task) => {
  return axios.post(`${API_URL}/`, task);
};

export const actualizarTarea = (task) => {
  return axios.put(`${API_URL}/`, task);
};

export const eliminarTarea = (id) => {
  return axios.delete(`${API_URL}/${id}`);
};

export const obtenerTareasPorEstado = (status) => {
  return axios.get(`${API_URL}/status/${status}`);
};

export const obtenerTareasPorPalabraClave = (keyword) => {
  return axios.get(`${API_URL}/keyword/${keyword}`);
};
