import { MusculiDTO } from "../models/dto/musculorum/musculi.dto.interface";
import { Muscle } from "../models/interfaces/muscle/muscle.interface";

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