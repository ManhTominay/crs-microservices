// path: crs-frontend/src/api/axiosClient.ts
import axios from 'axios';

const axiosClient = axios.create({
    baseURL: import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080',
    headers: {
        'Content-Type': 'application/json',
    },
});

// Tự động đính kèm Token vào header cho mỗi request gửi đi
axiosClient.interceptors.request.use(
    (config) => {
        // Lấy token từ localStorage (hoặc chỗ bạn lưu token khi đăng nhập)
        const token = localStorage.getItem('token');
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

export default axiosClient;