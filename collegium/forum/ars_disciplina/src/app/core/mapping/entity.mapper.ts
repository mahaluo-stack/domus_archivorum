import { EntiaMusculiDTO } from "../models/dto/entia/entia-musculi.dto.interface";
import { MuscleEntity } from "../models/entity/muscle.entity";
import { MuscleGroupMapper, MusclePartMapper } from "./musculorum.mapper";

export class EntityMapper {

    static fromDto(dto: EntiaMusculiDTO): MuscleEntity {
        return {
            muscleId: dto.musculiIdentitas,
            muscleName: dto.nomenMusculi,
            muscleDescription: dto.descriptioMusculi,
            muscleGroup: MuscleGroupMapper.fromDto(dto.musculiRegio),
            muscleParts: MusclePartMapper.fromDtos(dto.musculiPars)
        };
    }

    static fromDtos(dtos: EntiaMusculiDTO[]): MuscleEntity[] {
        return dtos.map(EntityMapper.fromDto);
    }
}