package org.woojukang.remixlab.query.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woojukang.remixlab.domain.user.dto.request.UserInfoRequest;
import org.woojukang.remixlab.domain.user.dto.response.UserInfoResponse;
import org.woojukang.remixlab.query.user.repository.UserQueryRepository;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserQueryRepository userQueryRepository;

    @Transactional(readOnly = true)
    public UserInfoResponse userInfo
            (String username){

        return new UserInfoResponse(userQueryRepository
                .findByUsername(username)
                .getUsername());

    }
}
