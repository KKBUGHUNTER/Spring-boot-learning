// src/components/AppBar.tsx

import React from 'react';
import { Link } from 'react-router-dom';

const AppBar: React.FC = () => {
    return (
        <div>
            <nav>
                <ul>
                    <li><Link to="/admin/home">Home</Link></li>
                    <li><Link to="/admin/add">Add Clinic</Link></li>
                    <li><Link to="/admin/update">Update Clinic</Link></li>
                    <li><Link to="/admin/delete">Delete Clinic</Link></li>
                </ul>
            </nav>
        </div>
    );
};

export default AppBar;
