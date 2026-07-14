import { MusculiRegioMusculiDTO } from "../models/dto/nexuum/musculi-musculi-pars.dto.interface";
import { MusculiMusculiParsDTO } from "../models/dto/nexuum/musculi-regio-musculi.dto.interface";
import { MuscleConfig } from "../models/muscle/muscle-config.interface";
import { MuscleGroupConfig } from "../models/muscle/muscle-group-config.interface";

export class MuscleConfigMapper {

    static fromDto(dto: MusculiMusculiParsDTO): MuscleConfig {
        return {
            muscleId: dto.musculiIdentitas,
            musclePartIds: dto.musculiParsIdentitates
        };
    }

    static fromDtos(dtos: MusculiMusculiParsDTO[]): MuscleConfig[] {
        return dtos.map(MuscleConfigMapper.fromDto);
    }
}

export class MuscleGroupConfigMapper {

    static fromDto(dto: MusculiRegioMusculiDTO): MuscleGroupConfig {
        return {
            muscleGroupId: dto.musculiRegioIdentitas,
            muscleIds: dto.musculiIdentitates
        };
    }

    static fromDtos(dtos: MusculiRegioMusculiDTO[]): MuscleGroupConfig[] {
        return dtos.map(MuscleGroupConfigMapper.fromDto);
    }
}