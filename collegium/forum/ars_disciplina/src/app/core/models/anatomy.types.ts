export type AnatomyView =
    | 'male-front'
    | 'male-back'
    | 'female-front'
    | 'female-back';

export interface Region {

    id: string;
    name: string;
    points: string;
    bbox: {
        x: number;
        y: number;
        w: number;
        h: number;
    };
}

export interface AnatomyRegion {

    id: string;
    points: string;
    mirrorId?: string;
    musclePartId?: number;
    muscleId?: number;
    muscleGroupId?: number;
}

export interface ViewBox {

    w: number;
    h: number;
}

export const regionNames: Partial<Record<AnatomyView, Record<string, string>>> = {
    'male-front': {},
    'male-back': {},
    'female-front': {},
    'female-back': {}
};

export interface AnatomyTransform {
    x: number;
    y: number;
    scale: number;
}

export interface AnatomyModel {
    regions: Region[];
    viewBox: string;
    transform: AnatomyTransform;
}