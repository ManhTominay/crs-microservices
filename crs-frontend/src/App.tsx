// path: crs-frontend/src/App.tsx
import { useEffect, useState } from 'react';
import { getCourses } from './api/courseApi';
import type { Course } from './types/course';
import type { AxiosResponse, AxiosError } from 'axios';

function App() {
    const [courses, setCourses] = useState<Course[]>([]);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        getCourses()
            .then((res: AxiosResponse) => {
                setCourses(res.data.content || res.data || []);
            })
            .catch((err: AxiosError) => {
                console.error(err);
                setError(`Loi ket noi: ${err.message || 'Khong the ket noi den Gateway'}`);
            });
    }, []);

    return (
        <div style={{ padding: 24, fontFamily: 'sans-serif' }}>
            <h1>Kiem tra ket noi CRS qua Gateway</h1>
            {error && <p style={{ color: 'red', fontWeight: 'bold' }}>{error}</p>}
            <h3>Danh sach khoa hoc:</h3>
            <pre>{JSON.stringify(courses, null, 2)}</pre>
        </div>
    );
}

export default App;