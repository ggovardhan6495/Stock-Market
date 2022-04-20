package com.market.user.service;

import com.market.user.dto.BaseResponseVo;
import com.market.user.dto.SignUpRequest;
import com.market.user.dto.SignUpResponse;

public interface UserService {
	public SignUpResponse registerNewUser(SignUpRequest request );
	public BaseResponseVo deleteUser(String userName);
}
