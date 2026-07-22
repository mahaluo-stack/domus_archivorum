import { DisciplinaDTO } from "../models/dto/disciplinarum/disciplina.dto.interface";
import { Exercise } from "../models/exercise/exercise.interface";

export class ExerciseMapper {

    static fromDto(dto: DisciplinaDTO): Exercise {
        return {
            id: dto.disciplinaIdentitas,
            name: dto.nomen,
            description: dto.descriptio
        };
    }

    static fromDtos(dtos: DisciplinaDTO[]): Exercise[] {
        return dtos.map(ExerciseMapper.fromDto);
    }
}