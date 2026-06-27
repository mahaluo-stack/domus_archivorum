import { MusculiParsDTO } from "../models/dto/musculorum/musculi-pars.dto.interface";
import { MusculiRegioDTO } from "../models/dto/musculorum/musculi-regio.dto.interface";
import { MusculiDTO } from "../models/dto/musculorum/musculi.dto.interface";
import { MuscleGroup } from "../models/interfaces/muscle/muscle.group.interface";
import { Muscle } from "../models/interfaces/muscle/muscle.interface";
import { MusclePart } from "../models/interfaces/muscle/muscle.part.interface";

export class MuscleMapper {

    static fromDto(dto: MusculiDTO): Muscle {
        return {
            id: dto.musculiIdentitas,
            name: dto.nomen,
            description: dto.descriptio
        };
    }

    static fromDtos(dtos: MusculiDTO[]): Muscle[] {
        return dtos.map(MuscleMapper.fromDto);
    }
}

export class MuscleGroupMapper {

    static fromDto(dto: MusculiRegioDTO): MuscleGroup {
        return {
            id: dto.musculiRegioIdentitas,
            name: dto.nomen,
            description: dto.descriptio
        };
    }

    static fromDtos(dtos: MusculiRegioDTO[]): MuscleGroup[] {
        return dtos.map(MuscleGroupMapper.fromDto);
    }
}

export class MusclePartMapper {

    static fromDto(dto: MusculiParsDTO): MusclePart {
        return {
            id: dto.musculiParsIdentitas,
            name: dto.nomen,
            description: dto.descriptio
        };
    }

    static fromDtos(dtos: MusculiParsDTO[]): MusclePart[] {
        return dtos.map(MusclePartMapper.fromDto);
    }
}