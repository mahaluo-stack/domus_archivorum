import { MusculiParsDTO } from "../musculorum/musculi-pars.dto.interface";
import { MusculiRegioDTO } from "../musculorum/musculi-regio.dto.interface";

export interface EntiaMusculiDTO {
    musculiIdentitas: number;
    nomenMusculi: string;
    descriptioMusculi: string;
    musculiRegio: MusculiRegioDTO,
    musculiPars: MusculiParsDTO[]
}