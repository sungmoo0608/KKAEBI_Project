import ResponseDto from "apis/response/response.dto";

export type ResponseBody <T> = T | ResponseDto | null;