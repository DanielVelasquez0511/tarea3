import MotoRow from "./MotoRow"

function MotoTable({motos, onEdit, onDelete}){

    return (
        <table>
            <thead>
                <tr>
                    <th>MARCA</th>
                    <th>MODELO</th>
                    <th>PLACA</th>
                    <th>PRECIO</th>
                    <th>ESTADO</th>
                    <th>KILOMETRAJE</th>
                </tr>
            </thead>
            <tbody>
                {motos.map((moto) =>(
                    <MotoRow key={moto.id} moto={moto} onEdit={onEdit} onDelete={onDelete}/>
                ))}
            </tbody>
        </table>
    )
}
export default MotoTable
