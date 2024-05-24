import axios from 'axios'
import { useEffect, useState } from 'react'
import './App.css'
import MotoForm from './components/MotoForm'
import MotoTable from './components/MotoTable'

function App() {
  const [motos, setMotos] = useState([])
  const [editingMoto, setEditingMoto] = useState(null)

  useEffect(() => {
    fetchMotos()
  }, [])

  const handleCreateOrUpdateMoto = async (motoData) => {
    if (editingMoto) {
      await axios.put(`http://localhost:8080/api/moto/${editingMoto.id}`, motoData)
    } else {
      await axios.post(`http://localhost:8080/api/moto`, motoData)
    }
    fetchMotos()
  }

  const fetchMotos = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/moto')
      setMotos(response.data)
    } catch (error) {
      console.log('Error al cargar las motos: ', error)
    }
  }

  const handleEditMoto = (moto) => {
    setEditingMoto(moto)
  }

  const handleDeleteMoto = async (motoId) => {
    await axios.delete(`http://localhost:8080/api/moto/${motoId}`)
    fetchMotos()
  }

  return (
    <div className='App'>
      <h1>Concesionario de Motos</h1>
      <br/>
      <h2>Lista de Motos</h2>
      <MotoTable motos={motos} onEdit={handleEditMoto} onDelete={handleDeleteMoto} />
      <h2>{editingMoto ? 'Editar Moto' : 'Crear nueva Moto'}</h2>
      <MotoForm onSubmit={handleCreateOrUpdateMoto} initialMoto={editingMoto} />
    </div>
  )
}

export default App
