// path: crs-frontend/src/api/courseApi.ts
import axiosClient from './axiosClient';
import type { Course, PagedResponse } from '../types/course';

export const getCourses = () => {
    return axiosClient.get<PagedResponse<Course>>('/api/courses');
};