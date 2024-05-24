const MotoRow = ({moto, onEdit, onDelete}) => {
    const handleEdit = () => {
        onEdit(moto)
    }

    const handleDelete = () => {
        onDelete(moto.id)
    }

    return (
        <tr>
            <td>{moto.marca}</td>
            <td>{moto.modelo}</td>
            <td>{moto.placa}</td>
            <td>{moto.precio}</td>
            <td>{moto.estado}</td>
            <td>{moto.kilometraje}</td>
            <td>
                <button onClick={handleEdit}>Editar 🖋</button>
                <button onClick={handleDelete}>Eliminar 🗑</button>
            </td>
        </tr>
    )
}
export default MotoRow
