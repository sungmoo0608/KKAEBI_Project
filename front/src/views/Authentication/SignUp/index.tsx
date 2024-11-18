import {ChangeEvent, KeyboardEvent, useRef, useState } from 'react'
import InputBox from './../../../components/InputBox/index';
import './style.css';
import { useNavigate } from 'react-router-dom';
import { EmailCertificationRequestDto, IdCheckRequestDto } from 'apis/request/auth';
import { emailCertificationRequest, idCheckRequest } from 'apis';
import { EmailCertificationResponseDto, IdCheckResponseDto } from 'apis/response/auth';
import ResponsCode from 'types/enums/response-code.enum';
import { ResponseCode } from 'types/enums';
import ResponseDto from 'apis/response/response.dto';
import ResponsDto from 'apis/response/response.dto';
import { ResponseBody } from 'types';


export default function SignUp() {

    const idRef = useRef<HTMLInputElement | null>(null);
    const passwordRef = useRef<HTMLInputElement | null>(null);
    const passwordCheckRef = useRef<HTMLInputElement | null>(null);
    const emailRef = useRef<HTMLInputElement | null>(null);
    const certificationNumberRef = useRef<HTMLInputElement | null>(null);

    const [id, setId] = useState<string>('');
    const [password, setPassword] = useState<string>('');
    const [passwordCheck, setPasswordCheck] = useState<string>('');
    const [email, setEmail] = useState<string>('');
    const [certificationNumber, setCertificationNumber] = useState<string>('');

    const [isIdError, setIdError] = useState<boolean>(false);
    const [isPasswordError, setPasswordError] = useState<boolean>(false);
    const [isPasswordCheckError, setPasswordCheckError] = useState<boolean>(false);
    const [isEmailError, setEmailError] = useState<boolean>(false);
    const [isCertificationNumberError, setCertificationNumberError] = useState<boolean>(false);

    const[idMessage, setIdMassage] = useState<string>('');
    const[passwordMessage, setPasswordMassage] = useState<string>('');
    const[passwordCheckMessage, setPasswordCherckMassage] = useState<string>('');
    const[emailMessage, setEmailMassage] = useState<string>('');
    const[certificationNumberMessage, setCertificationNumberMassage] = useState<string>('');

    const [isIdCheck, setIdCheck] = useState<boolean>(false);
    
    const signUpButtonClass = id && password && passwordCheck && email && certificationNumber ?
    'primary-button-lg' : 'disable-button-lg';

    const emailPattern = /^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\.[a-zA-xZ]{2,4}$/;

    const navigate =  useNavigate();

    const idCheckResponse = (responseBody: ResponseBody<IdCheckResponseDto>) => {
        if (!responseBody) return;
        const { code } = responseBody;
        if (code === ResponsCode.VALIDATION_FAIL) alert('아이디를 입력하세요.');
        if (code === ResponseCode.DUPLICATE_ID) {
            setIdError(true);
            setIdMassage('이미 사용중인 아이디입니다');
            setIdCheck(false);
        }
        if (code === ResponseCode.DATABASE_ERROR) alert('데이터베이스 오류입니다.');
        if (code === ResponseCode.SUCCESS) return;

        setIdError(false);
        setIdMassage('사용 가능한 아이디입니다');
        setIdCheck(true);
    }

    const emailCertificationResponse = (responseBody: ResponseBody<EmailCertificationResponseDto> ) => {

        if (!responseBody) return;
        const { code } = responseBody;

        if ( code === ResponseCode.VALIDATION_FAIL) alert('아이디와 이메일을 모두 입력하세요.');
        if (code === ResponseCode.DUPLICATE_ID) {
            setIdError(true);
            setIdMassage('이미 사용중인 아이디입니다');
            setIdCheck(false);
        }
        if ( code === ResponseCode.VALIDATION_FAIL) alert('이메일 전송에 실패했습니다.');
        if (code === ResponseCode.DATABASE_ERROR) alert('데이터베이스 오류입니다.');
        if (code === ResponseCode.SUCCESS) return;

        setEmailError(false);
        setEmailMassage('인증번호가 전송되었습니다.');
        
    };

    const onIdChangeHandler = (event: ChangeEvent<HTMLInputElement>) =>{
        const { value } = event.target;
        setId(value);
        setIdMassage('');
        setIdCheck(false);
    };
    const onPasswordChangeHandler = (event: ChangeEvent<HTMLInputElement>) =>{
        const { value } = event.target;
        setPassword(value);
        setPasswordMassage('');
    };
    const onPasswordCheckChangeHandler = (event: ChangeEvent<HTMLInputElement>) =>{
        const { value } = event.target;
        setPasswordCheck(value);
        setPasswordCherckMassage('');
    };
    const onEmailChangeHandler = (event: ChangeEvent<HTMLInputElement>) =>{
        const { value } = event.target;
        setEmail(value);
        setEmailMassage('');
    };
    const onCertificationNumberChangeHandler = (event: ChangeEvent<HTMLInputElement>) =>{
        const { value } = event.target;
        setCertificationNumber(value);
        setCertificationNumberMassage('');
    };

    const onIdButtonClickHandler = () => {
        if (!id) return;
        const requestBody: IdCheckRequestDto = { id };

        idCheckRequest(requestBody).then(idCheckResponse);
    };
    const onPasswordButtonClickHandler = () => {
        
    };
    const onPasswordCheckButtonClickHandler = () => {
        
    };
    const onEmailButtonClickHandler = () => {
        if (!id && !email) return;
        const checkedEmail = emailPattern.test(email);
        if (!checkedEmail) {
            setEmailError(true);
            setEmailMassage('이메일 형식이 아닙니다.');
            return;
        }

        const requestBody: EmailCertificationRequestDto = { id, email };
        emailCertificationRequest(requestBody).then(emailCertificationResponse);
        
    };
    const onCertificationNumberButtonClickHandler = () => {
        
    };

    const onSignUpButtonClickHandler = () => {

    };

    const onSignInButtonClickHandler = () => {
        navigate('/auth/sign-in');
    };

    const onIdKeyDownHandler = (event: KeyboardEvent<HTMLInputElement>) => {
        if (event.key !== 'Enter') return;
        onIdButtonClickHandler();

    };
    const onPasswordKeyDownHandler = (event: KeyboardEvent<HTMLInputElement>) => {
        if (event.key !== 'Enter') return;
        if (!passwordCheckRef.current) return;
        passwordCheckRef.current.focus();
    };
    const onPasswordCheckKeyDownHandler = (event: KeyboardEvent<HTMLInputElement>) => {
        if (event.key !== 'Enter') return;
        if (!emailRef.current) return;
        emailRef.current.focus();
    };
    const onEmailKeyDownHandler = (event: KeyboardEvent<HTMLInputElement>) => {
        if (event.key !== 'Enter') return;
        onEmailButtonClickHandler();
    };
    const onCertificationNumberKeyDownHandler = (event: KeyboardEvent<HTMLInputElement>) => {
        if (event.key !== 'Enter') return;
        onCertificationNumberButtonClickHandler();

    };

    return (
        <div id='sign-up-wrapper'>
            <div className='sign-up-image'></div>
            <div className='sign-up-container'>
                <div className='sign-up-box'>
                    <div className='sign-up-title'>{'도깨비 금융쇼핑몰 서비스'}</div>
                    <div className='sign-up-content-box'>
                        <div className='sign-up-content-sns-sign-in-box'>
                            <div className='sign-up-content-sns-sign-in-title'>{'SNS 회원가입 서비스'}</div>
                            <div className='sign-up-content-sns-sign-in-button-box'>
                                <div className='kakao-sign-in-button'></div>
                                <div className='naver-sign-in-button'></div>
                            </div>
                        </div>
                        <div className='sign-up-content-divider'></div>
                        <div className='sign-up-content-input-box'>
                            <InputBox ref={idRef} title='아이디' placeholder='아이디를 입력해주세요' type='text' value={id} onChange={onIdChangeHandler} isErrorMessage={isIdError} message={idMessage} buttonTitle='중복확인' onButtonClick={onIdButtonClickHandler} onKeydown={onIdKeyDownHandler} />
                            <InputBox ref={passwordRef} title='비밀번호' placeholder='비밀번호를 입력해주세요' type='password' value={password} onChange={onPasswordChangeHandler} isErrorMessage={isPasswordError} message={passwordMessage} onButtonClick={onPasswordButtonClickHandler} onKeydown={onPasswordKeyDownHandler} />
                            <InputBox ref={passwordCheckRef} title='비밀번호 확인' placeholder='비밀번호를 입력해주세요' type='password' value={passwordCheck} onChange={onPasswordCheckChangeHandler} isErrorMessage={isPasswordCheckError} message={passwordCheckMessage} onButtonClick={onPasswordCheckButtonClickHandler} onKeydown={onPasswordCheckKeyDownHandler} />
                            <InputBox ref={emailRef} title='이메일' placeholder='이메일 주소를 입력해주세요' type='text' value={email} onChange={onEmailChangeHandler} isErrorMessage={isEmailError} message={emailMessage} buttonTitle='이메일 인증' onButtonClick={onEmailButtonClickHandler} onKeydown={onEmailKeyDownHandler} />
                            <InputBox ref={certificationNumberRef} title='인증번호' placeholder='인증번호 4자리를 입력해주세요' type='text' value={certificationNumber} onChange={onCertificationNumberChangeHandler} isErrorMessage={isCertificationNumberError} message={certificationNumberMessage} buttonTitle='인증 확인' onButtonClick={onCertificationNumberButtonClickHandler} onKeydown={onCertificationNumberKeyDownHandler} />
                        </div>
                        <div className='sign-up-content-button-box'>
                            <div className={`${signUpButtonClass} full-width`} onClick={onSignUpButtonClickHandler}>{'회원가입'}</div>
                            <div className='text-link-lg full-width' onClick={onSignInButtonClickHandler}>{'로그인'}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
