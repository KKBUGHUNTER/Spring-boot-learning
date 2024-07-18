import React, { useState, useEffect, CSSProperties } from 'react';
import deleteIcon from '../../../src/assets/delete.png';

type Clinic = {
    id: number;
    address: string;
    name: string;
};

const HomePage: React.FC = () => {
    const [clinics, setClinics] = useState<Clinic[]>([]);
    const [formData, setFormData] = useState<Clinic>({ id: 0, address: '', name: '' });
    const [isEditing, setIsEditing] = useState(false);

    useEffect(() => {
        fetchClinics();
    }, []);

    const fetchClinics = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/clinics', {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
            });

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            const data = await response.json();
            setClinics(data);
        } catch (error) {
            console.error('Error fetching clinics:', error);
        }
    };

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };

    const handleRowClick = (clinic: Clinic) => {
        setFormData(clinic);
        setIsEditing(true);
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        const method = isEditing ? 'PUT' : 'POST';
        const url = isEditing
            ? `http://localhost:8080/api/clinics/${formData.id}`
            : 'http://localhost:8080/api/clinics';

        try {
            const response = await fetch(url, {
                method: method,
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            const newClinic = await response.json();
            setClinics(prevClinics =>
                isEditing
                    ? prevClinics.map(clinic =>
                          clinic.id === newClinic.id ? newClinic : clinic
                      )
                    : [...prevClinics, newClinic]
            );

            setFormData({ id: 0, address: '', name: '' });
            setIsEditing(false);
        } catch (error) {
            console.error('Error submitting clinic:', error);
        }
    };

    const handleDelete = async (id: number) => {
        try {
            const response = await fetch(`http://localhost:8080/api/clinics/${id}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                },
            });

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            setClinics(prevClinics => prevClinics.filter(clinic => clinic.id !== id));
        } catch (error) {
            console.error('Error deleting clinic:', error);
        }
    };

    const style: { [key: string]: CSSProperties } = {
        container: {
            display: 'flex',
            padding: '20px',
            maxWidth: '1200px',
            margin: '0 auto',
        },
        title: {
            textAlign: 'center',
            marginBottom: '20px',
            width: '100%',
        },
        tableContainer: {
            flex: 7,
            marginRight: '20px',
        },
        table: {
            width: '70%',
            borderCollapse: 'collapse',
            marginRight: '20px',
            textAlign: 'center',
        },
        th: {
            border: '1px solid #ddd',
            padding: '8px',
            textAlign: 'center',
        },
        td: {
            border: '1px solid #ddd',
            padding: '8px',
            textAlign: 'center',
        },
        formContainer: {
            flex: 3,
            display: 'flex',
            flexDirection: 'column',
        },
        form: {
            display: 'flex',
            flexDirection: 'column',
            gap: '10px',
        },
        inputContainer: {
            display: 'flex',
            alignItems: 'center',
            gap: '10px',
        },
        input: {
            padding: '8px',
            borderRadius: '4px',
            border: '1px solid #ddd',
            flex: 1,
        },
        button: {
            padding: '10px',
            borderRadius: '5px',
            border: 'none',
            background: '#007BFF',
            color: '#fff',
            cursor: 'pointer',
        },
    };

    return (
        <div style={style.container}>
            <div style={style.tableContainer}>
                <h2 style={style.title}>All Clinics</h2>
                <table style={style.table}>
                    <thead>
                        <tr>
                            <th style={style.th}>ID</th>
                            <th style={style.th}>Name</th>
                            <th style={style.th}>Address</th>
                            <th style={style.th}></th>
                        </tr>
                    </thead>
                    <tbody>
                        {clinics.map(clinic => (
                            <tr key={clinic.id} onClick={() => handleRowClick(clinic)} style={{ cursor: 'pointer' }}>
                                <td style={style.td}>{clinic.id}</td>
                                <td style={style.td}>{clinic.name}</td>
                                <td style={style.td}>{clinic.address}</td>
                                <td style={style.td}>
                                    <img src={deleteIcon} alt="delete" height={25} onClick={(e) => { e.stopPropagation(); handleDelete(clinic.id); }} style={{ cursor: 'pointer' }} />
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <div style={style.formContainer}>
                <h2 style={style.title}>{isEditing ? 'Update Clinic' : 'Add Clinic'}</h2>
                <form style={style.form} onSubmit={handleSubmit}>
                    <div style={style.inputContainer}>
                        <label>
                            Name:
                            <input
                                style={style.input}
                                type="text"
                                name="name"
                                value={formData.name}
                                onChange={handleChange}
                            />
                        </label>
                    </div>
                    <div style={style.inputContainer}>
                        <label>
                            Address:
                            <input
                                style={style.input}
                                type="text"
                                name="address"
                                value={formData.address}
                                onChange={handleChange}
                            />
                        </label>
                        <br />
                        <button style={style.button} type="submit">{isEditing ? 'Update' : 'Add'}</button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default HomePage;
