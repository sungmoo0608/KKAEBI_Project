import { ResponseCode, ResponseMessage } from "types/enums";

export default interface ResponsDto {
    code: ResponseCode;
    message: ResponseMessage;
}