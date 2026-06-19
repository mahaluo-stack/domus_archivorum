import { Role } from "../constants/roles.enum";

export interface User {
    id: number;
    name: string;
    email: string;
    roles: Role[];
}