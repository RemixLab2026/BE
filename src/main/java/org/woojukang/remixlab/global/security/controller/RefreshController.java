package org.woojukang.remixlab.global.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.woojukang.remixlab.global.config.exception.dto.ApiResult;
import org.woojukang.remixlab.global.security.dto.response.ReissueResponse;
import org.woojukang.remixlab.global.security.service.RefreshService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user/refresh")
public class RefreshController {

    private final RefreshService refreshService;

    @PostMapping("/reissue")
    public ResponseEntity<ApiResult<ReissueResponse>> reissue(HttpServletRequest request,
                                                              HttpServletResponse response){

        ReissueResponse reissueResponse = refreshService.refreshCookies(request);

        return switch (reissueResponse.status()) {
            case "REFRESH_EXISTS" -> {
                response
                        .setHeader("access",
                                reissueResponse
                                        .AccessToken());
                response
                        .addCookie(refreshService
                                .createCookie("refresh",
                                        refreshService
                                                .reissueRefresh(request)));
                yield new ResponseEntity<>(
                        ApiResult.success(reissueResponse),
                        HttpStatus.OK
                );
            }
            default -> new ResponseEntity<>(
                    ApiResult.fail("REISSUE_FAILED",
                            "토큰 갱신에 실패하였습니다."),
                    HttpStatus.BAD_REQUEST
            );
        };
    }


}
