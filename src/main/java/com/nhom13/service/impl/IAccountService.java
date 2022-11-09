package com.nhom13.service.impl;

import com.nhom13.dto.UserDTO;
import com.nhom13.payload.response.DataResponse;

public interface IAccountService {
	DataResponse<UserDTO> getAllAccountUser();
	DataResponse<UserDTO> getAccountUserById(Long id);
	DataResponse<?> editAccountUser(Long id);
	DataResponse<?> blockAccountUser(Long id);
}
