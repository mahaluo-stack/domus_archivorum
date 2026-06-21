export function mapNamedEntity<T extends Record<string, unknown>>(
    dto: T,
    idField: keyof T
) {
    return {
        id: dto[idField] as number,
        name: dto.[nomen] as string,
        description: dto.[descriptio] as string
    };
}